package project.jakkit.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KHAMMA on 11/09/2017.
 */

public class OrderTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeDatabase, readDatabase;

    public static final String TABLE_ORDER = "orderTABLE";
    public static final String COLUMN_ID_ORDER = "_listID";
    public static final String COLUMN_TABLEID = "TableID";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_STTPAY = "sttPay";

    public OrderTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeDatabase = objMyOpenHelper.getWritableDatabase();
        readDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    public String[] readAllListID() {

        String strListID[] = null;
        Cursor objCursor = readDatabase.query(TABLE_ORDER, new String[]{COLUMN_ID_ORDER, COLUMN_ID_ORDER}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListID = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListID[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_ID_ORDER));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListID;
    }
    public String[] readAllListTableID() {

        String strListTableID[] = null;
        Cursor objCursor = readDatabase.query(TABLE_ORDER, new String[]{COLUMN_ID_ORDER, COLUMN_TABLEID}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListTableID = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListTableID[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_TABLEID));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListTableID;
    }
    public String[] readAllListDate() {

        String strListDate[] = null;
        Cursor objCursor = readDatabase.query(TABLE_ORDER, new String[]{COLUMN_ID_ORDER, COLUMN_DATE}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListDate = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListDate[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_DATE));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListDate;
    }

    public String[] readAllListSttPay() {

        String strListSttPay[] = null;
        Cursor objCursor = readDatabase.query(TABLE_ORDER, new String[]{COLUMN_ID_ORDER, COLUMN_STTPAY}, null, null, null, null, null);
        objCursor.moveToFirst();
        strListSttPay = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListSttPay[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_STTPAY));
            objCursor.moveToNext();
        }   // for
        objCursor.close();
        return strListSttPay;
    }

    public String[] searchOrder(String strListID) {

        try {

            String strResult[] = null;
            Cursor objCursor = readDatabase.query(TABLE_ORDER,
                    new String[] {COLUMN_ID_ORDER, COLUMN_TABLEID, COLUMN_DATE, COLUMN_STTPAY},
                    COLUMN_ID_ORDER + "=?",
                    new String[] {String.valueOf(strListID)},
                    null, null, null, null);

            if (objCursor != null) {

                if (objCursor.moveToFirst()) {

                    strResult = new String[objCursor.getColumnCount()];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                }
            }
            objCursor.close();
            return strResult;

        } catch (Exception e) {
            return null;
        }
        //return new String[0];
    }

    public long addValueToOrder(String strListID, String strTableID, String strDate, String strSttPay) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_ID_ORDER, strListID);
        objContentValues.put(COLUMN_TABLEID, strTableID);
        objContentValues.put(COLUMN_DATE, strDate);
        objContentValues.put(COLUMN_STTPAY, strSttPay);

        return writeDatabase.insert(TABLE_ORDER, null, objContentValues);
    }
}
