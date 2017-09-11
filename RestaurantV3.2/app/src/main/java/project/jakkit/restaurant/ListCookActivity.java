package project.jakkit.restaurant;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

import android.app.ProgressDialog;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by KHAMMA on 07/09/2017.
 */

public class ListCookActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_list);

    }
}
