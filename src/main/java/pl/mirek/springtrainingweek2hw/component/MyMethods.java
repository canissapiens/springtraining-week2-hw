package pl.mirek.springtrainingweek2hw.component;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class MyMethods {

    Random generator;

    public MyMethods() {
        this.generator = new Random();
    }

    public int getRandomPrice() {
        return generator.nextInt(251) + 50;
    }

    public int getBatonPrice() {
        return generator.nextInt(5) + 5;
    }

    public BigDecimal getTotalPrice (BigDecimal price, int quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getBruttoPrice(BigDecimal total, int vat) {
        return total.add(total.multiply(BigDecimal.valueOf(vat)).divide(BigDecimal.valueOf(100)));
    }

    public BigDecimal getNicePrice(BigDecimal brutto, int discount) {
        return brutto.multiply(BigDecimal.valueOf(100 - discount)).divide(BigDecimal.valueOf(100));
    }
}
