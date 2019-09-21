package pl.mirek.springtrainingweek2hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.MessageSource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.mirek.springtrainingweek2hw.component.MyMethods;
import pl.mirek.springtrainingweek2hw.data.BasketService;
import pl.mirek.springtrainingweek2hw.model.Item;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class MainController {

    MyMethods myMethods;
    MessageSource messageSource;
    BasketService basketService;

    @Autowired
    public MainController(MyMethods myMethods,
                          MessageSource messageSource,
                          BasketService basketService) {
        this.myMethods = myMethods;
        this.messageSource = messageSource;
        this.basketService = basketService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doit() {
        String basket = basketService.getNewBasket();
        Item item1 = new Item("Rower", 1, BigDecimal.valueOf(myMethods.getRandomPrice()));
        basketService.addItemToBasket(basket, item1);
        basketService.addItemToBasket(basket, new Item("Kask", 1, BigDecimal.valueOf(myMethods.getRandomPrice())));
        basketService.addItemToBasket(basket, new Item("Koszulka", 3, BigDecimal.valueOf(myMethods.getRandomPrice())));
        basketService.addItemToBasket(basket, new Item("Latarka", 1, BigDecimal.valueOf(myMethods.getRandomPrice())));
        basketService.addItemToBasket(basket, new Item("Okulary", 1, BigDecimal.valueOf(myMethods.getRandomPrice())));
        basketService.addItemToBasket(basket, new Item("Baton Energetyczny", 5, BigDecimal.valueOf(myMethods.getBatonPrice())));

        List<Item> itemList = basketService.getItemList(basket);
        System.out.println();
        if (itemList != null) {
            for (Item it : itemList) {
                System.out.println(basketService.getLineToPrint(it));
            }
        }
    }
}
