package com.erik_b.Coolschrank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coolschrank {
    private String id;
    private Inventory[] inventory; //

    public Coolschrank() {

    }

    public Inventory[] getInventory() {
        return inventory;
    }

    public void setInventory(Inventory[] inventory) {
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Inventory extends Coolschrank {
    int id;
    String name;
    Number actual;
    Number target;

    public Inventory(int id, String name, Number actual, Number target) {
        this.id = id;
        this.name = name;
        this.actual = actual;
        this.target = target; // >=0
    }
}