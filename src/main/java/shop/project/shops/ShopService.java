package shop.project.shops;

import java.util.ArrayList;

import org.springframework.stereotype.Service;;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void createShop(String name) {
        Shop shop = new Shop(name);
        this.shopRepository.save(shop);
    }

    public ArrayList<ShopDTO> getAll() {
        Iterable<Shop> shopEntities = this.shopRepository.findAll();
        ArrayList<ShopDTO> shopDtosList = new ArrayList<>();
        shopEntities.forEach(shop -> {
            ShopDTO shopDto = Mapper.toDTO(shop);
            shopDtosList.add(shopDto);
        });

        return shopDtosList;
    }
}
