package com.erik_b.Coolschrank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coolschrank { //evtl als Interface?
    private String id;
    private ResponseInventory[] inventory; //




    public Coolschrank() {

    }

    public ResponseInventory[] getInventory() {
        return inventory;
    }

    public void setInventory(ResponseInventory[] inventory) {
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void createShoppingList() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.deleteAll();

        for (ResponseInventory i : inventory) {
            if (i.getActual().intValue() == 0) {
                ShoppingListItem product = new ShoppingListItem();
                product.setName(i.getName());
                product.setTarget(i.getTarget());
                shoppingList.addItem(product);
                //shoppingList.output();
                System.out.println(i);
            }
            else
                System.out.println("Fridge filled");
        }
        shoppingList.output();
    }
}

class RequestInventory {
    private String name;
    private Number actual; // der Wert der aktuell im Kühlschrank vorhanden ist
    private Number target; // >=0 Stellt dar wie viel im Kühlschrank sein sollen

    public RequestInventory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getActual() {
        return actual;
    }

    public void setActual(Number actual) {
        this.actual = actual;
    }

    public Number getTarget() {
        return target;
    }

    public void setTarget(Number target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                //"id=" + id +
                ", name='" + name + '\'' +
                ", actual=" + actual +
                ", target=" + target +
                '}';
    }
    public boolean checkActualValue() {
        int value = (int) this.actual;
        return value == 0;
    }

}

class ResponseInventory{

    private int id;
    private String name;
    private Number actual; // der Wert der aktuell im Kühlschrank vorhanden ist
    private Number target; // >=0 Stellt dar wie viel im Kühlschrank sein sollen

    public ResponseInventory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getActual() {
        return actual;
    }

    public void setActual(Number actual) {
        this.actual = actual;
    }

    public Number getTarget() {
        return target;
    }

    public void setTarget(Number target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "ResponseInventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actual=" + actual +
                ", target=" + target +
                '}';
    }
}