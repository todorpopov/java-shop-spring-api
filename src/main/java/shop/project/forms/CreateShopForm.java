package shop.project.forms;

public class CreateShopForm {
    private String name;

    public CreateShopForm(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
