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

    /* Example:

{
     "firstName":"Shmulik",
     "lastName":"Willinger",
     "mail":"shmulik83@gmail.com",
     "cibusNumber":"12345678",
     "phones":[
                 {"type":"MOBILE", "phoneNumber":"1234"},
                 {"type":"HOME"  , "phoneNumber":"5678"}],
     "addresses":[
                 {"city":"Tel Aviv", "street":"Pinkas", "streetNumber":"52"},
                 {"city":"Givat Shmuel", "street":"Yoni Netaniahu", "streetNumber":"32"}],
     "jobs":[
                 {"StartDate":"010313", "EndDate":"200815", "CompanyId":"1"},
                 {"StartDate":"010310", "EndDate":"010313", "CompanyId":"2"}]
}
     */
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
