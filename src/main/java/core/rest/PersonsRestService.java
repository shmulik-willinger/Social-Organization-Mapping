package core.rest;

import core.model.Company;
import core.model.Job;
import core.model.Person;
import core.repositories.PersonRepository;
import core.services.PersonsBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
@Path("/persons")
@Produces("application/json")
public class PersonsRestService {

    @Autowired
    private PersonsBusinessService personsBusinessService;

    @Autowired
    private PersonRepository personRepository;

    @POST
    public boolean addPerson(Person user) throws Exception
    {
        personsBusinessService.saveUser(user);

        makeSomePersons();

        return true;
    }

    public Collection<Person> makeSomePersons()
    {
        Collection<Person> persons = new ArrayList<Person>();

        persons.add(createPerson("Shmulik1", "Willinger1"));
        persons.add(createPerson("Shmulik2", "Willinger2"));

        //Create Person
        Person personWithJob = createPerson("Shmulik3", "Willinger3");
        //Create Job
        Job personJob = createJob(1);
        //Create the Relashenship
        personWithJob.setJob(personJob);

        //Save the Entities
        personRepository.save(personWithJob);
        persons.add(personWithJob);

        return persons;
    }

    public Person createPerson(String firstName, String lastName)
    {
        Person newPerson = new Person();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);

        return personRepository.save(newPerson);
    }
    public Job createJob(int companyId)
    {
        Job newJob = new Job();
        newJob.setStartDate(new Date(2010, 1, 30));
        newJob.setEndDate(new Date(2013, 6, 20));
        newJob.setCompanyId(companyId);

        return newJob;
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
