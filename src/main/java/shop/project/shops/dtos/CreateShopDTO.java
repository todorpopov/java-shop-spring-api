package shop.project.shops.dtos;

import java.util.Map;

public class CreateShopDTO {
    private String name;

    public CreateShopDTO(){}
    public CreateShopDTO(Map<String, String> requestBody) {
        this.name = requestBody.get("name");
    }

    public String getName() {
        return this.name;
    }
}
