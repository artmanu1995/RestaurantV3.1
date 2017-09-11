package project.jakkit.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KHAMMA on 11/09/2017.
 */

public class ListOrderTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeDatabase, readDatabase;

    public static final String TABLE_LISTO = "listoTABLE";
    public static final String COLUMN_ID_LISTO = "_llistID";
    public static final String COLUMN_FOODID = "FoodID";
    public static final String COLUMN_AMOUNT = "Amount";
    public static final String COLUMN_HOT = "HotLevel";
    public static final String COLUMN_STTSEND = "sttSend";

    public ListOrderTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeDatabase = objMyOpenHelper.getWritableDatabase();
        readDatabase = objMyOpenHelper.getReadableDatabase();
    }   // Constructor

    public String[] readAllListLID() {

        String strListLID[] = null;
        Cursor objCursor = readDatabase.query(TABLE_LISTO, new String[]{COLUMN_ID_LISTO, COLUMN_ID_LISTO}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListLID = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListLID[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_ID_LISTO));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListLID;
    }
    public String[] readAllListFoodID() {

        String strListFoodID[] = null;
        Cursor objCursor = readDatabase.query(TABLE_LISTO, new String[]{COLUMN_ID_LISTO, COLUMN_FOODID}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListFoodID = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListFoodID[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_FOODID));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListFoodID;
    }
    public String[] readAllListAmount() {

        String strListAmount[] = null;
        Cursor objCursor = readDatabase.query(TABLE_LISTO, new String[]{COLUMN_ID_LISTO, COLUMN_AMOUNT}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListAmount = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListAmount[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_AMOUNT));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListAmount;
    }
    public String[] readAllListHot() {

        String strListHot[] = null;
        Cursor objCursor = readDatabase.query(TABLE_LISTO, new String[]{COLUMN_ID_LISTO, COLUMN_HOT}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListHot = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListHot[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_HOT));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListHot;
    }

    public String[] readAllListSttSend() {

        String strListSttSend[] = null;
        Cursor objCursor = readDatabase.query(TABLE_LISTO, new String[]{COLUMN_ID_LISTO, COLUMN_STTSEND}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListSttSend = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListSttSend[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_STTSEND));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListSttSend;
    }

    public String[] searchListOrder(String strLlistID) {

        try {
            String strResult[] = null;
            Cursor objCursor = readDatabase.query(TABLE_LISTO,
                    new String[] {COLUMN_ID_LISTO, COLUMN_FOODID, COLUMN_AMOUNT, COLUMN_HOT, COLUMN_STTSEND},
                    COLUMN_ID_LISTO + "=?",
                    new String[] {String.valueOf(strLlistID)},
                    null, null, null, null);

            if (objCursor != null) {
                if (objCursor.moveToFirst()) {
                    strResult = new String[objCursor.getColumnCount()];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                    strResult[4] = objCursor.getString(4);
                }
            }
            objCursor.close();
            return strResult;

        } catch (Exception e) {
            return null;
        }
        //return new String[0];
    }

    public long addValueToListOrder(String strLlistID, String strLDate, Integer intLAmount, String strLHotLevel, String strLSttSend) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_ID_LISTO, strLlistID);
        objContentValues.put(COLUMN_FOODID, strLDate);
        objContentValues.put(COLUMN_AMOUNT, intLAmount);
        objContentValues.put(COLUMN_HOT, strLHotLevel);
        objContentValues.put(COLUMN_STTSEND, strLSttSend);
        return writeDatabase.insert(TABLE_LISTO, null, objContentValues);
    }
}
