package org.abondar.experimental.personservice.model;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public interface PersonService {
    @GET
    @Path("/")
    public Person[] getAll();

    @GET
    @Path("/{id}")
    public Person getPerson(@PathParam("id") String id);

    @PUT
    @Path("/{id}")
    public Person updatePerson(@PathParam("id") String id,Person person);

    @POST
    @Path("/")
    public void addPerson(Person person);

}
