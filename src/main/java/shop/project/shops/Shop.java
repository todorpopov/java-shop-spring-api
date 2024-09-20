package shop.project.shops;
import jakarta.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  
    @Column(name = "id", nullable = false)  
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Shop(){}
    public Shop(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "Person(id=%d, firstName='%s')", id, name);
    }
}
