package shop.project.shops;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.project.exceptions.NoShopNameFound;

@RestController
@RequestMapping("api/shops")
public class ShopController {
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/new-shop")
    public ResponseEntity<String> createShop(@RequestBody CreateShopDTO body) {
        try {
            this.shopService.createShop(body.getName());
            return ResponseEntity.ok("New shop created successfully!");
        } catch(NoShopNameFound exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/get/all")
    public ArrayList<ShopDTO> getAllShops() {
        return this.shopService.getAll();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        try {
            this.shopService.deleteAll();
            return ResponseEntity.ok().body("All shops deleted successfully");
        } catch(Exception exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
