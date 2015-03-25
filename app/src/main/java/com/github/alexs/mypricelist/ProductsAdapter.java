package com.github.alexs.mypricelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alex on 24/03/15.
 */
public class ProductsAdapter extends ArrayAdapter<Product>{
    public ProductsAdapter(Context context, ArrayList<Product> products){
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Get the data product for this position
        Product product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product, parent, false);
        }
        // Lookup view for data population
        TextView product_name = (TextView) convertView.findViewById(R.id.product_name_textview);

        // Populate the data into the template view using the data object
        product_name.setText(product.name);
        // Return the completed view to render on screen
        return convertView;
    }

}
