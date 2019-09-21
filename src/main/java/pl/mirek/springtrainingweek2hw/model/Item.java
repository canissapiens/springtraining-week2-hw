package pl.mirek.springtrainingweek2hw.model;

import java.math.BigDecimal;

public class Item {

    private String name;
    private int quantity;
    private BigDecimal price;

    public Item(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pozycja: {" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
