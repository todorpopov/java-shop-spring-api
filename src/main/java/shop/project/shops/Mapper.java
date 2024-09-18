package shop.project.shops;

public class Mapper {
    public static ShopDTO toDTO(Shop Shop) {
        ShopDTO shopDTO = new ShopDTO(Shop.getId(), Shop.getName());
        return shopDTO;
    }

    public static Shop toShop(ShopDTO ShopDTO) {
        Shop Shop = new Shop(ShopDTO.getName());
        return Shop;
    }
}
