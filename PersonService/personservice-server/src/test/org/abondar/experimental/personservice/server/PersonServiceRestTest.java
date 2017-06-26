package org.abondar.experimental.personservice.server;


import org.abondar.experimental.personservice.model.Person;
import org.abondar.experimental.personservice.model.PersonService;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonServiceRestTest {
    private static final String PERSONSERVICE_TESTURL = "http://localhost:8282/person";
    private static Server server;

    @BeforeClass
    public static void startServer(){
        PersonService personService = new PersonServiceImpl();

        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setAddress(PERSONSERVICE_TESTURL);
        factory.setServiceBean(personService);
        server =factory.create();
        server.start();
    }


    @Test
    public void testInterface(){
        PersonService personService = JAXRSClientFactory.create(PERSONSERVICE_TESTURL, PersonService.class);
        Person person = new Person("1022","Vasya Pupkin");
        personService.updatePerson(person.getId(),person);

        Person person1 = personService.getPerson(person.getId());
        assertCorrectPerson(person1);
    }

    @Test
    public void testWebClient(){
        WebClient client = WebClient.create(PERSONSERVICE_TESTURL+"/1024");
        putPerson(client);
        Person person = client.get(Person.class);
        assertCorrectPerson(person);
    }

    @AfterClass
    public static void stopServer(){
        server.stop();
    }

    private void putPerson(WebClient client) {
        InputStream is = this.getClass().getResourceAsStream("/person1.xml");
        Response res = client.put(is);
        System.out.println(res);
    }

    private void assertCorrectPerson(Person person) {
        assertNotNull(person);
        assertEquals("Vasya Pupkin",person.getName());
    }
}
