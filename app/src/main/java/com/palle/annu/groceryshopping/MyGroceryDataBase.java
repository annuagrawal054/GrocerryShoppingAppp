package com.palle.annu.groceryshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by annu on 17/10/16.
 */
public class MyGroceryDataBase {

    SQLiteDatabase sqLiteDatabasee;
    MyHelper myHelper;
    Cursor cursor;

    public MyGroceryDataBase(Context context) {
        myHelper = new MyHelper(context, "groceryapp.db", null, 1);
    }

    public void open() {
        sqLiteDatabasee = myHelper.getWritableDatabase();
    }

    public void insertgrocery(String item, Integer quantity, String unit, String price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item);
        contentValues.put("quantity", quantity);
        contentValues.put("quantity_unit", unit);
        contentValues.put("price", price);
        sqLiteDatabasee.insert("grocery", null, contentValues);
    }

    public Cursor getItem() {
        cursor = sqLiteDatabasee.query("grocery", null, null, null, null, null, null);
        return cursor;
    }

    public void close() {
        sqLiteDatabasee.close();
    }

    public class MyHelper extends SQLiteOpenHelper {


        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table grocery(_id integer primary key, item text, quantity integer, quantity_unit text,price text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
