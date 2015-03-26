package com.github.alexs.mypricelist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
    private static final String KEY_ID = "id";
    private static final String PRODUCT_NAME = "name";

    public ProductListDatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //construct table for products
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + PRODUCT_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + PRODUCT_NAME + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    // Upgrading the database between versions
    // This method is called when database is upgraded like modifying the table structure,
    // adding constraints to database, etc
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 1){
            //Drop tables if exists
            db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
            // Create tables
            onCreate(db);
        }

    }

    // Insert record into database
    public void addProduct(Product product){
        //Open database
        SQLiteDatabase db = this.getWritableDatabase();
        //Define values for each field
        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME, product.getName());
        //Insert row
        db.insertOrThrow(PRODUCT_TABLE,null,values);
        db.close();
    }

    public List<Product> getAllProducts(){
        ArrayList<Product> products = new ArrayList<Product>();
        //Select all
        String selectQuery = "SELECT * FROM " + PRODUCT_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        //loop through all rows and add to list
        if (cursor.moveToFirst()){
            do{
                Product product = new Product(cursor.getString(1));
                product.setId(cursor.getInt(0));
                // Adding product to list
                products.add(product);
            }while (cursor.moveToNext());
        }

        return products;
    }
}