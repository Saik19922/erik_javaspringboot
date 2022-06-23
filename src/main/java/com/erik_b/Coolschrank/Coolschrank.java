package com.erik_b.Coolschrank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.annotation.processing.Generated;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coolschrank { //evtl als Interface?
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

class Inventory {
    static int counter = 1;
    private int id; // ToDo: Autoincrement
    private String name;
    private Number actual; // der Wert der aktuell im Kühlschrank vorhanden ist
    private Number target; // >=0 Stellt dar wie viel im Kühlschrank sein sollen

    public Inventory() {
        this.id = counter++;
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
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actual=" + actual +
                ", target=" + target +
                '}';
    }
}