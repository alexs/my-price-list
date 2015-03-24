package com.github.alexs.mypricelist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alex on 23/03/15.
 */
public class ProductListDatabaseHandler extends SQLiteOpenHelper{
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "myproductlist";

    // Products table
    private static final String PRODUCT_TABLE = "products";

    //Product Columns
    private static final String KEY_ID = id;
    private static final String PRODUCT_NAME = name;

    public ProductListDatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
