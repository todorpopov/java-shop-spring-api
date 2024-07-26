package shop.project.person;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(String name) {
        Person person = new Person(name);
        this.personRepository.save(person);
    }

    public PersonDTO getOnePerson(Long id) {
        Person person = this.personRepository.findById(id).orElse(null);
        PersonDTO personDTO = Mapper.toDTO(person);
        return personDTO;
    }

    public ArrayList<PersonDTO> getAll() {
        Iterable<Person>  allPersonEntities= this.personRepository.findAll();
        ArrayList<PersonDTO> personDTOList = new ArrayList<>();
        allPersonEntities.forEach(person -> {
            PersonDTO personDTO = Mapper.toDTO(person);
            personDTOList.add(personDTO);
        });
        return personDTOList;
    }

    public Long getPersonCount() {
        return personRepository.count();
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
