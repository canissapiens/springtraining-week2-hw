package pl.mirek.springtrainingweek2hw.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mirek.springtrainingweek2hw.model.Basket;
import pl.mirek.springtrainingweek2hw.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BasketService {

    private BasketRepository basketRepository;
    private RaportModule raportModulel;

    @Autowired
    public BasketService(BasketRepository basketRepository,
                         RaportModule raportModule) {
        this.basketRepository = basketRepository;
        this.raportModulel = raportModule;
    }

    public String getNewBasket() {
        Basket basket = new Basket();
        basketRepository.addBasket(basket);
        return basket.getUuid();
    }

    public void addItemToBasket(String basketUuid, Item item) {
        basketRepository.getBasketByUuid(basketUuid).addItem(item);
    }

    public List<Item> getItemList(String basketUuid) {
        List<Item> output = new ArrayList<>();
        if (basketRepository.getBasketByUuid(basketUuid).getBasketContent().size() > 0) {
            for (Item item : basketRepository.getBasketByUuid(basketUuid).getBasketContent()) {
                String stop1 = "";
                output.add(item);
                String stop2 = "";
            }
        }
        return output;
    }

    public String getLineToPrint (Item item) {
        return raportModulel.showItemInfo(item);
    }
}
