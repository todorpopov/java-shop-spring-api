package shop.project.person;

public class Mapper {
    public static PersonDTO toDTO(Person person) {
        PersonDTO peronDTO = new PersonDTO(person.getId(), person.getName());
        return peronDTO;
    }

    public static Person toPerson(PersonDTO personDTO) {
        Person person = new Person(personDTO.getName());
        return person;
    }
}
