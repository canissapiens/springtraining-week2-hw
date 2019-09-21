package pl.mirek.springtrainingweek2hw.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.mirek.springtrainingweek2hw.component.MyMethods;
import pl.mirek.springtrainingweek2hw.model.Item;

import java.math.BigDecimal;
import java.util.Locale;

@Component
@Profile("START")
public class RaportModuleStart implements RaportModule {

    private MessageSource messageSource;
    private MyMethods myMethods;

    @Autowired
    public RaportModuleStart(MessageSource messageSource,
                             MyMethods myMethods) {
        this.messageSource = messageSource;
        this.myMethods = myMethods;
    }

    @Override
    public String showItemInfo(Item item) {
        BigDecimal total = myMethods.getTotalPrice(item.getPrice(), item.getQuantity());
        String output = messageSource.getMessage(
                "item-to-string", new Object[]{
                        item.getName(),
                        String.valueOf(item.getQuantity()),
                        String.valueOf(item.getPrice()),
                        String.valueOf(total)},
                Locale.forLanguageTag("pl"));
        return output;
    }
}
