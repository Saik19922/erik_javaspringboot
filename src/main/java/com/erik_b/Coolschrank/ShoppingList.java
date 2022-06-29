package com.erik_b.Coolschrank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingList{

    private String FridgeId;
    private ArrayList<Product> shoppinglist = new ArrayList<Product>();

    public ShoppingList() {

    }

    public ShoppingList(String FridgeId) {
        this.FridgeId = FridgeId;
    }

    public String getFridgeId() {
        return FridgeId;
    }

    public void setFridgeId(String fridgeId) {
        FridgeId = fridgeId;
    }

    public void addItem(ResponseInventory[] inventory) {

        for (ResponseInventory i : inventory) {
            if (i.getActual().intValue() < i.getTarget().intValue()) {
                Product product = new Product();
                product.setId(i.getId());
                product.setName(i.getName());
                product.setActual(i.getActual());
                product.setTarget(i.getTarget());
                product.setProductvalue(i.getActual(), i.getTarget());

                shoppinglist.add(product);
            }
        }
    }

    public void changeItem(String id, String FridgeId) {

        if (Objects.equals(getFridgeId(), FridgeId)) {
            Number productvalue = findItem(id).getProductvalue();
            findItem(id).setActual(productvalue);
        }
    }

    public Product findItem(String id) {
        for (Product p : shoppinglist) {
            String ids = String.valueOf(p.getId()); // cast
            if(ids.equals(id)){
                return p;
            }
        }
        return null;
    }

    public void outputList(){
        for (Product responseInventories : shoppinglist) {
            System.out.println(responseInventories);
        }
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(shoppinglist);
    }

    public void setShoppinglist(ArrayList<Product> shoppinglist) {
        this.shoppinglist = shoppinglist;
    }

    public ArrayList<Product> getShoppinglist() {
        return shoppinglist;
    }

    public void deleteAll() {
        shoppinglist.clear();
    }
    @Override
    public String toString() {
        return "ShoppingList{" +
                "shoppinglist=" + shoppinglist +
                '}';
    }
}

class Product {
    private int id;
    private String name;
    private Number actual;
    private Number target;

    @JsonIgnore
    private Number productvalue;

    public Product(){

    }

    public Product(int id, String name, Number actual, Number target) {
        this.id = id;
        this.name = name;
        this.actual = actual;
        this.target = target;
    }

    public Number getProductvalue() {
        return productvalue;
    }

    public void setProductvalue(Number actual, Number target) {
        this.productvalue = target.doubleValue()-actual.doubleValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getTarget() {
        return target;
    }

    public void setTarget(Number target) {
        this.target = target;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Number getActual() {
        return actual;
    }

    public void setActual(Number actual) {
        this.actual = actual;
    }
    /*public Product() {
        this.name = null;
        this.target = null;
    }*/

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actual=" + actual +
                ", target=" + target +
                '}';
    }

}


class ProductResponse {



    private String name;
    private double needvalue;


    public double getNeedvalue() {
        return needvalue;
    }

    public void setNeedvalue(double needvalue) {
        this.needvalue = needvalue;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "name='" + name + '\'' +
                ", needvalue=" + needvalue +
                '}';
    }
}
