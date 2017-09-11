package project.jakkit.restaurant;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
import java.text.SimpleDateFormat;
/**
 * Created by KHAMMA on 03/09/2017.
 */

public class TableActivity extends ActionBarActivity {
    private TableTABLE objTableTEBLE;

    private TextView txtShowOfficer;
    private String strOfficer, strTable, strUserID;
    private String strNumTa1 = "01", strNumTa2 = "02", strNumTa3 = "03", strNumTa4 = "04", strNumTa5 = "05",
            strNumTa6 = "06", strNumTa7 = "07", strNumTa8 = "08", strNumTa9 = "09";
    private String stt_default = "0", stt_table;

    ConnectionClass connectionClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        connectionClass = new ConnectionClass();

        objTableTEBLE = new TableTABLE(this);

        //Clear All Data
        clearDataTo();
        bindWidget();
        showOfficer();
        getOfficerID();
        showDate();

        synJSONstatusTable();

        checkTable1();
        checkTable2();
        checkTable3();
        checkTable4();
        checkTable5();
        checkTable6();
        checkTable7();
        checkTable8();
        checkTable9();
    }

    private void checkTable1() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa1);
        stt_table = strMyResult[1];
        Button btn_ok = (Button) findViewById(R.id.button1);
        if (stt_default.equals(stt_table)) {
            btn_ok.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable2() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa2);
        stt_table = strMyResult[1];
        Button btn_ok2 = (Button) findViewById(R.id.button2);
        if (stt_default.equals(stt_table)) {
            btn_ok2.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok2.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable3() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa3);
        stt_table = strMyResult[1];
        Button btn_ok3 = (Button) findViewById(R.id.button3);
        if (stt_default.equals(stt_table)) {
            btn_ok3.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok3.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable4() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa4);
        stt_table = strMyResult[1];
        Button btn_ok4 = (Button) findViewById(R.id.button4);
        if (stt_default.equals(stt_table)) {
            btn_ok4.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok4.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable5() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa5);
        stt_table = strMyResult[1];
        Button btn_ok5 = (Button) findViewById(R.id.button5);
        if (stt_default.equals(stt_table)) {
            btn_ok5.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok5.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable6() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa6);
        stt_table = strMyResult[1];
        Button btn_ok6 = (Button) findViewById(R.id.button6);
        if (stt_default.equals(stt_table)) {
            btn_ok6.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok6.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable7() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa7);
        stt_table = strMyResult[1];
        Button btn_ok7 = (Button) findViewById(R.id.button7);
        if (stt_default.equals(stt_table)) {
            btn_ok7.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok7.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable8() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa8);
        stt_table = strMyResult[1];
        Button btn_ok8 = (Button) findViewById(R.id.button8);
        if (stt_default.equals(stt_table)) {
            btn_ok8.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok8.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void checkTable9() {
        String strMyResult[] = objTableTEBLE.searchTableData(strNumTa9);
        stt_table = strMyResult[1];
        Button btn_ok9 = (Button) findViewById(R.id.button9);
        if (stt_default.equals(stt_table)) {
            btn_ok9.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        } else {
            btn_ok9.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void clearDataTo() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("restaurantV2_2.db", MODE_PRIVATE, null);
        objSqLiteDatabase.delete("toTABLE", null, null);
    }

    private void showOfficer() {
        strOfficer = getIntent().getExtras().getString("Officer");
        txtShowOfficer.setText(strOfficer);
    }
    private void getOfficerID() {
        strUserID = getIntent().getExtras().getString("IDofficer");
    }

    private void bindWidget() {
        txtShowOfficer = (TextView) findViewById(R.id.txtShowOfficer);
    }

    private void showDate() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView time = (TextView) findViewById(R.id.txtShowDateTime);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH : mm : ss");
                                String dateString = sdf.format(date);
                                time.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }

    private void chooseOnOffTable() {
        CharSequence[] charItem = {"เปิดโต๊ะ (ON)", "ปิดโต๊ะ (OFF)"};

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.restaurant2);
        objBuilder.setTitle("เลือกสถานะโต๊ะ" + "[" + strTable + "]");
        objBuilder.setCancelable(false);
        objBuilder.setSingleChoiceItems(charItem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:
                        stt_table = "1";
                        upDataTableToMySQL();
                        Intent intent = new Intent(TableActivity.this, OrderActivity.class);
                        intent.putExtra("Officer", strOfficer);
                        intent.putExtra("Table", strTable);
                        intent.putExtra("IDofficer", strUserID);
                        startActivity(intent);
                        break;
                    case 1:
                        stt_table = "0";
                        upDataTableToMySQL();
                        break;
                }   // switch

                dialog.dismiss();

            }   // event
        });
        objBuilder.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog objAlertDialog = objBuilder.create();
        objAlertDialog.show();


    }

    public String upDataTableToMySQL() {
        String z = "";
        boolean isSuccess = false;

        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
                z = "Please check internet connection";
            } else {
                String query = "UPDATE data_table SET sttTable_id = '" + stt_table + "' WHERE table_id = '" + strTable + "'";

                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);

                clearDataTo();
                synJSONstatusTable();

                Toast.makeText(getApplicationContext(), "บันทึกเรียบร้อย", Toast.LENGTH_SHORT).show();

                z = "insert into successfull";
                isSuccess = true;
            }
        } catch (Exception ex) {
            isSuccess = false;
            z = "Exceptions" + ex;
        }
        return z;
    }

    public void btn1Click(View view) {
        strTable = "01";
        chooseOnOffTable();
    }

    public void btn2Click(View view) {
        strTable = "02";
        chooseOnOffTable();
    }

    public void btn3Click(View view) {
        strTable = "03";
        chooseOnOffTable();
    }

    public void btn4Click(View view) {
        strTable = "04";
        chooseOnOffTable();
    }

    public void btn5Click(View view) {
        strTable = "05";
        chooseOnOffTable();
    }

    public void btn6Click(View view) {
        strTable = "06";
        chooseOnOffTable();
    }

    public void btn7Click(View view) {
        strTable = "07";
        chooseOnOffTable();
    }

    public void btn8Click(View view) {
        strTable = "08";
        chooseOnOffTable();
    }

    public void btn9Click(View view) {
        strTable = "09";
        chooseOnOffTable();
    }

    private void synJSONstatusTable() {
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
            HttpPost objHttpPost = new HttpPost("http://192.168.1.40/get_data_table.php");
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

                String strTableId = objJSONObject.getString("table_id");
                String strStatus = objJSONObject.getString("sttTable_id");

                long addValue = objTableTEBLE.addValueToTable(strTableId, strStatus);
            }   // for

        } catch (Exception e) {
            Log.d("oic", "Update ==> " + e.toString());
        }
    }
}
