package com.github.alexs.mypricelist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ProductForm extends ActionBarActivity {

    EditText nameProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        Button save_product_button = (Button)findViewById(R.id.save_product_button);


        save_product_button.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View v){
                 try{
                     nameProduct = (EditText)findViewById(R.id.product_name_editText);
                     String product_name = nameProduct.getText().toString();

                     // Create our sqlite database object
                     ProductListDatabaseHandler db = new ProductListDatabaseHandler(v.getContext());
                     // Inserting product data
                     db.addProduct(new Product(product_name));
                     Toast.makeText(v.getContext(), "Producto almacenado", Toast.LENGTH_LONG).show();
                     finish();

                 }
                 catch(Exception e)
                 {
                     Toast.makeText(v.getContext(), e.toString(), Toast.LENGTH_LONG).show();
                 }

             }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_form, menu);
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
}
