package pl.mirek.springtrainingweek2hw.data;

import org.springframework.stereotype.Repository;
import pl.mirek.springtrainingweek2hw.model.Basket;
import pl.mirek.springtrainingweek2hw.model.Item;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BasketRepository {
    private Map<String, Basket> baskets;

    public BasketRepository() {
        baskets = new HashMap<>();
    }

    public Basket getBasketByUuid(String uuid) {
        return baskets.get(uuid);
    }

    public void addBasket(Basket basket) {
        this.baskets.put(basket.getUuid(), basket);
    }

    public void addItemToBasket(String basketUuid, Item item) {
        this.baskets.get(basketUuid).addItem(item);
    }
}
