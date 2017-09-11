package project.jakkit.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KHAMMA on 03/04/2017.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "restaurantV2_2.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER_TABLE = "create table userTABLE (_id text primary key, " + " User text, Password text, Name text);";
    private static final String CREATE_FOOD_TABLE = "create table foodTABLE (_id text primary key, "+" Food text, Price int);";
    private static final String CREATE_TO_TABLE = "create table toTABLE (_id text primary key, "+" Status text)";
    private static final String CREATE_ORDER_TABLE = "create table orderTABLE (_listID text primary key, "+" TableID text, Date text, sttPay text)";
    private static final String CREATE_LISTO_TABLE = "create table listoTABLE (_llistID text primary key, "+" FoodID text, Amount int, HotLevel text, sttSend text)";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }   // Constructor
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FOOD_TABLE);
        db.execSQL(CREATE_TO_TABLE);
        db.execSQL(CREATE_ORDER_TABLE);
        db.execSQL(CREATE_LISTO_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}   // MyOpenHelper
