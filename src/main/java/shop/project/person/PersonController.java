package shop.project.person;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/count")
    public Long getPersonCount() {
        return personService.getPersonCount();
    }

    @GetMapping("/get")
    @ResponseBody
    public PersonDTO getOnePerson(@RequestParam String id) {
        return personService.getOnePerson(Long.parseLong(id));
    }

    @PostMapping("/create")
    @ResponseBody
    public void createPerson(@RequestParam String name) {
        personService.createPerson(name);
    }

    @GetMapping("/all")
    public ArrayList<PersonDTO> getAll() {
        return personService.getAll();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void deletePerson(@RequestParam String id) {
        personService.deletePerson(Long.parseLong(id));
    }
}
