package shop.project.person;

public class PersonDTO {
    private Long id;
    private String name;

    public PersonDTO() {}
    public PersonDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
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
