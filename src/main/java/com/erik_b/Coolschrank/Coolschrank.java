package com.erik_b.Coolschrank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coolschrank {
    private String id;
    private String[] inventory;

    public Coolschrank() {

    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
