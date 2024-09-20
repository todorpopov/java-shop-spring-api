package shop.project.exceptions;

public class NoShopNameFound extends RuntimeException {
    public NoShopNameFound() {
        super("No shop name found in the request body!");
    }   
}
