package shop.project.shops;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.project.exceptions.NoShopNameFound;
import shop.project.forms.CreateShopForm;

@RestController
@RequestMapping("api/shops")
public class ShopController {
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/new-shop")
    public ResponseEntity<String> createShop(@RequestBody Map<String, CreateShopForm> body) throws NoShopNameFound {
        CreateShopForm shopForm = body.get("name");
        
        if(shopForm.getName() == "") {
            throw new NoShopNameFound("No shop name found in the request body!");
        }

        System.out.println(shopForm.getName());

        this.shopService.createShop(shopForm.getName());
        return ResponseEntity.ok("New shop created successfully!");
    }

    @GetMapping("/get/all")
    public ArrayList<ShopDTO> getAllShops() {
        return this.shopService.getAll();
    }
}
