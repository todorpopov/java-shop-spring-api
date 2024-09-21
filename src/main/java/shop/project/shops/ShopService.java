package shop.project.shops;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import shop.project.exceptions.NoShopNameFound;
import shop.project.shops.dtos.Mapper;
import shop.project.shops.dtos.ShopDTO;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void createShop(String name) throws RuntimeException {
        if(name == null || name == "") {
            throw new NoShopNameFound();
        } else {
            Shop shop = new Shop(name);
            this.shopRepository.save(shop);
        }
    }

    public Boolean exists(String name) throws RuntimeException {
        if(name == null || name == "") {
            throw new NoShopNameFound();
        } else {
            return this.shopRepository.existsByName(name);
        }
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
    
    public void deleteAll() {
        this.shopRepository.deleteAll();
    }
}
