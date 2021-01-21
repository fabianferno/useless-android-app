package com.example.useless_android_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLClientInfoException;

public class DbHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;

    public DbHelper(Context context) {
        super(context, "details.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table customers(customerName text, customerMobile text,sales text,dateOfSale text,region text,typeOfCustomer text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveLog(String customerName, String customerMobile, String sales, String dateOfSale, String region, String typeOfCustomer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerName", customerName);
        contentValues.put("customerMobile", customerMobile);
        contentValues.put("sales", sales);
        contentValues.put("dateOfSale", dateOfSale);
        contentValues.put("region", region);
        contentValues.put("typeOfCustomer", typeOfCustomer);

        sqLiteDatabase.insert("customers", null, contentValues);
    }
}
