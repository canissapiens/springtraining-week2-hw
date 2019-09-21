package pl.mirek.springtrainingweek2hw.model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {
    private String uuid;
    private List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void addItem (Item item) {
        this.items.add(item);
    }

    public List<Item> getBasketContent() {
        return this.items;
    }
}
