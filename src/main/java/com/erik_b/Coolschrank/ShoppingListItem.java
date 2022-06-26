package com.erik_b.Coolschrank;

public class ShoppingListItem { // ToDO: Problem beheben, dass Produkte die hinzugefügt werden, sich hochzählen und öfters in die Einkaufsliste geschrieben werden
    private String name;
    private Number target;

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

    public ShoppingListItem() {
        this.name = null;
        this.target = null;
    }
}
