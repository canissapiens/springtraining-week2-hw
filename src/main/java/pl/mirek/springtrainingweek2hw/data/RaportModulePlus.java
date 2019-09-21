package pl.mirek.springtrainingweek2hw.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.mirek.springtrainingweek2hw.ApplicationConfig;
import pl.mirek.springtrainingweek2hw.component.MyMethods;
import pl.mirek.springtrainingweek2hw.model.Item;

import java.math.BigDecimal;
import java.util.Locale;

@Component
@Profile("PLUS")
public class RaportModulePlus implements RaportModule {

    private MessageSource messageSource;
    private ApplicationConfig config;
    private MyMethods myMethods;

    @Autowired
    public RaportModulePlus(MessageSource messageSource,
                            ApplicationConfig config,
                            MyMethods myMethods) {
        this.messageSource = messageSource;
        this.config = config;
        this.myMethods = myMethods;
    }

    @Override
    public String showItemInfo(Item item) {
        BigDecimal total = myMethods.getTotalPrice(item.getPrice(), item.getQuantity());
        BigDecimal brutto = myMethods.getBruttoPrice(total, config.getVat());
        String output = messageSource.getMessage(
                "item-to-string-z-vat", new Object[]{
                        item.getName(),
                        String.valueOf(item.getQuantity()),
                        String.valueOf(item.getPrice()),
                        String.valueOf(total),
                        String.valueOf(brutto)},
                Locale.forLanguageTag("pl"));
        return output;
    }
}
