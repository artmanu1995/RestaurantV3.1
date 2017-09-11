package project.jakkit.restaurant;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.app.ProgressDialog;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by KHAMMA on 04/09/2017.
 */

public class ListOrderActivity extends ActionBarActivity {
    private OrderTABLE objOrderTABLE;
    private ListOrderTABLE objListOrderTABLE;
    private TextView txtShowTable;
    private String strOfficer, strTable, strNumFood, strFood, strPrice, strVolume;

    ConnectionClass connectionClass;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        objOrderTABLE = new OrderTABLE(this);
        objListOrderTABLE = new ListOrderTABLE(this);

        connectionClass = new ConnectionClass();
        progressDialog = new ProgressDialog(this);

        synJSONtoSQLiteOrderTABLE();
        synJSONtoSQLiteListOrderTABLE();

        bindWidget();

        showTable();

    }
    private void showTable() {
        strTable = getIntent().getExtras().getString("Table");
        txtShowTable.setText(strTable);
    }

    public void Click(View view) {
        Button btt_ok = (Button) findViewById(R.id.btt_list);

//        onPreExecute();
//        InserMySQL();

        Intent intent = new Intent(ListOrderActivity.this, TableActivity.class);
        intent.putExtra("Officer", strOfficer);

        startActivity(intent);
    }

    protected void onPreExecute() {
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }
    private void synJSONtoSQLiteOrderTABLE() {
        //Setup New Policy
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy objPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(objPolicy);
        }
        //Create InputStream
        InputStream objInputStream = null;
        String strJSON = "";
        try {
            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost("http://192.168.1.40/get_order.php");
            HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
            HttpEntity objHttpEntity = objHttpResponse.getEntity();
            objInputStream = objHttpEntity.getContent();

        } catch (Exception e) {
            Log.d("oic", "InputStream ==> " + e.toString());
        }
        //Create strJSON
        try {
            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
            StringBuilder objStringBuilder = new StringBuilder();
            String strLine = null;

            while ((strLine = objBufferedReader.readLine()) != null) {
                objStringBuilder.append(strLine);
            }   // while
            objInputStream.close();
            strJSON = objStringBuilder.toString();
        } catch (Exception e) {
            Log.d("oic", "strJSON ==> " + e.toString());
        }
        //UpData SQLite
        try {
            final JSONArray objJsonArray = new JSONArray(strJSON);
            for (int i = 0; i < objJsonArray.length(); i++) {
                JSONObject objJSONObject = objJsonArray.getJSONObject(i);
                String strListID = objJSONObject.getString("listO_id");
                String strTableID = objJSONObject.getString("table_id");
                String strDate = objJSONObject.getString("order_date");
                String strSttPay = objJSONObject.getString("sttPay_id");
                long AddValue = objOrderTABLE.addValueToOrder(strListID, strTableID, strDate, strSttPay);

            }   // for

        } catch (Exception e) {
            Log.d("oic", "Update ==> " + e.toString());
        }
    }
    private void synJSONtoSQLiteListOrderTABLE(){
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy objPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(objPolicy);
        }
        //Create InputStream
        InputStream objInputStream = null;
        String strJSON = "";
        try {
            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost("http://192.168.1.40/get_list_order.php");
            HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
            HttpEntity objHttpEntity = objHttpResponse.getEntity();
            objInputStream = objHttpEntity.getContent();

        } catch (Exception e) {
            Log.d("oic", "InputStream ==> " + e.toString());
        }
        //Create strJSON
        try {
            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
            StringBuilder objStringBuilder = new StringBuilder();
            String strLine = null;

            while ((strLine = objBufferedReader.readLine()) != null) {
                objStringBuilder.append(strLine);
            }   // while
            objInputStream.close();
            strJSON = objStringBuilder.toString();
        } catch (Exception e) {
            Log.d("oic", "strJSON ==> " + e.toString());
        }
        //UpData SQLite
        try {
            final JSONArray objJsonArray = new JSONArray(strJSON);
            for (int i = 0; i < objJsonArray.length(); i++) {
                JSONObject objJSONObject = objJsonArray.getJSONObject(i);
                String strLlistID =objJSONObject.getString("listO_id");
                String strLDate = objJSONObject.getString("food_id");
                Integer intLAmount = objJSONObject.getInt("listO_amount");
                String strLHotLevel = objJSONObject.getString("listO_hot");
                String strLSttSend = objJSONObject.getString("sttSO_id");
                long AddValue = objListOrderTABLE.addValueToListOrder(strLlistID, strLDate, intLAmount, strLHotLevel, strLSttSend);
            }   // for

        } catch (Exception e) {
            Log.d("oic", "Update ==> " + e.toString());
        }
    }

    protected String InserMySQL() {
        String z="";
        boolean isSuccess=false;

        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
                z = "Please check your internet connection";
            } else {

                String query = "insert into test_order values(NULL,'" + strOfficer + "','" + strNumFood + "','" + strFood + "','" + strPrice + "','" + strVolume + "','" + strTable + "')";

                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);

                z = "Register successfull";
                isSuccess = true;


            }
        } catch (Exception ex) {
            isSuccess = false;
            z = "Exceptions" + ex;
        }
        return z;
    }

    private void bindWidget() {
        txtShowTable = (TextView) findViewById(R.id.txtShowTable);
    }
}
