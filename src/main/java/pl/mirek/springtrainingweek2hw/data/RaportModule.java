package pl.mirek.springtrainingweek2hw.data;

import org.springframework.context.MessageSource;
import pl.mirek.springtrainingweek2hw.model.Item;

public interface RaportModule {

    String showItemInfo(Item item);
}
