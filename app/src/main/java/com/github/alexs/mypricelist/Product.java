package com.github.alexs.mypricelist;

/**
 * Created by alex on 24/03/15.
 */
public class Product {
    private int id;
    public String name;

    public Product(String name){
        super();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
