package shop.project.person;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "id", nullable = false)  
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Person() {}
    public Person(String name) {
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
