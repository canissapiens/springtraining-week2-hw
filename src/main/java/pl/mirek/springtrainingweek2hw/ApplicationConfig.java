package pl.mirek.springtrainingweek2hw;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "basket-app")
public class ApplicationConfig {

    private int vat;
    private int discount;

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getVat() {
        return vat;
    }

    public int getDiscount() {
        return discount;
    }
}
