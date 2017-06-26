package org.abondar.experimental.personservice.server;

import org.abondar.experimental.personservice.model.Person;
import org.abondar.experimental.personservice.model.PersonService;

import java.util.HashMap;
import java.util.Map;


public class PersonServiceImpl implements PersonService {

    private Map<String, Person> personMap;

    public PersonServiceImpl() {
        personMap = new HashMap<>();
        Person person = createExamplePerson();

        personMap.put(person.getId(), person);
    }

    private Person createExamplePerson() {

        return new Person("1", "Alex");
    }

    @Override
    public Person[] getAll() {
        return personMap.values().toArray(new Person[]{});
    }

    @Override
    public Person getPerson(String id) {
        return personMap.get(id);
    }

    @Override
    public Person updatePerson(String id, Person person) {
        person.setId(id);
        System.out.println("Update request received for " + person.getId() + " name:" + person.getName());
        personMap.put(id, person);
        return null;
    }

    @Override
    public void addPerson(Person person) {
        System.out.println("Add request received for " + person.getId() + " name:" + person.getName());
        personMap.put(person.getId(), person);
    }
}
