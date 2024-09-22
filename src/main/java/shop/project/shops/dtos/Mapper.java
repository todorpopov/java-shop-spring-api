package shop.project.shops.dtos;

import shop.project.shops.Shop;

public class Mapper {
    public static ShopDTO toDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO(shop.getId(), shop.getName());
        return shopDTO;
    }

    public static Shop toShop(ShopDTO ShopDTO) {
        Shop Shop = new Shop(ShopDTO.getName());
        return Shop;
    }
}
