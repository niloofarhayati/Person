package com.embl.ebi.person;

import com.embl.ebi.person.exeption.PersonDoesNotExistException;
import com.embl.ebi.person.model.Person;
import com.embl.ebi.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/")
@EnableWebMvc
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/persons")
    List<Person> findAll() {
        List<Person> s =repository.findAll();
        return s;
    }

    @PostMapping(value = "/savePerson", produces = {"application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    Person create(@Valid @RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/persons/{id}")
    Person findPerson(@PathVariable @Min(1) Long id) throws PersonDoesNotExistException {
        return repository.findById(id)
                .orElseThrow(() -> new PersonDoesNotExistException(1l));
    }

    @PutMapping("/persons/{id}")
    Person UpdatePerson(@RequestBody Person person,@PathVariable Long id) throws PersonDoesNotExistException {
        return repository.findById(id)
                .map(personFound -> {
                    personFound.setFirstName(person.getFirstName());
                    personFound.setLastName(person.getLastName());
                    personFound.setAge(person.getAge());
                    personFound.setFavoriteColour(person.getFavoriteColour());
                    personFound.setHobby(person.getHobby());
                    return repository.save(personFound);
                })
                .orElseGet(() -> {
                    person.setId(person.getId());
                    return repository.save(person);
                });
    }


    @DeleteMapping("/persons/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
