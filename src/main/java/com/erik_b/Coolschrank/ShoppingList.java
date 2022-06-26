package com.erik_b.Coolschrank;

import java.util.ArrayList;

public class ShoppingList {

    private static ArrayList<ShoppingListItem> shoppinglist = new ArrayList<ShoppingListItem>();

    public void addItem(ShoppingListItem shoppingListItem) {
            shoppinglist.add(shoppingListItem);
    }

    public ShoppingListItem findItem(String name) {
        for (ShoppingListItem p : shoppinglist) {
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public boolean ItemExist(String name) {
        for( ShoppingListItem p : shoppinglist) {
            if(p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void deleteItem(String name) {
        if(ItemExist(name)) {
            shoppinglist.remove(findItem(name));
        }
    }

    public void deleteAll() {
        shoppinglist.clear();
    }

    public void output(){
        for (ShoppingListItem p : shoppinglist) {
            System.out.println(p.getName());
            System.out.println(p.getTarget());
        }
    }

   /* public void addEmptyCoolschrankItem(Inventory product) {
        for( Inventory i : inventory) {
            int value = (int) i.getActual();

            if (value == 0) {
                addItem(inventory);
            }
        }
    }*/
}
