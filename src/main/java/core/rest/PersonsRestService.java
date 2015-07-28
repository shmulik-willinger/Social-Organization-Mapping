package core.rest;

import core.model.Person;
import core.services.PersonsBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

@Service
@Path("/persons")
@Produces("application/json")
public class PersonsRestService {

    @Autowired
    private PersonsBusinessService personsBusinessService;

    @POST
    public boolean addPerson(Person user) throws Exception {

        personsBusinessService.saveUser(user);

        return true;
    }

    @GET
    @Path("/{id}")
    public Person GetById(@PathParam("id") Integer id) {

        return personsBusinessService.getById(id);
    }


    @PUT
    public Person updateEntity(Person entity) {

        personsBusinessService.update(entity);

        return personsBusinessService.getById(entity.getPerson_id());
    }
}
