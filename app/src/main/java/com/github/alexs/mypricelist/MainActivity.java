package com.github.alexs.mypricelist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    //private String[] products = {"UbuntuUbuntuUbuntuUbuntuUbuntuUbuntuUbuntuUbuntuUbuntuUbuntu", "Android", "iOS", "Windows", "Mac OSX",
    //        "Google Chrome OS", "Debian", "Mandriva", "Solaris", "Unix", "Ubuntu", "Android", "iOS", "Windows", "Mac OSX",
    //        "Google Chrome OS", "Debian", "Mandriva", "Solaris", "Unix"};

    ProductListDatabaseHandler productDb;
    ProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getListView();


        //ListView products_list = (ListView)findViewById(R.id.product_list);
        //ArrayAdapter<String> productsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,products);
        //ArrayAdapter<String> productsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, products);
        //products_list.setAdapter(productsAdapter);
    }

    public void getListView(){
        productDb = new ProductListDatabaseHandler(this);
        //productDb.getWritableDatabase();
        ArrayList<Product> products = new ArrayList<Product>(productDb.getAllProducts());
        // Create the adapter to convert the array to views
        adapter = new ProductsAdapter(this,products);
        //productDb.getAllProducts();
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.product_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);

                Toast.makeText(getBaseContext(), String.valueOf(product.getId()), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showProductForm(MenuItem item){
        Intent intent = new Intent(this,ProductForm.class);
        startActivity(intent);

        //Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
    }

    private void openDB(){
        productDb = new ProductListDatabaseHandler(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        getListView();
    }


}
