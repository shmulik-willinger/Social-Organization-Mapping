package core.repositories;

import core.model.Person;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.springframework.data.neo4j.repository.AbstractGraphRepository;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface PersonRepository extends GraphRepository<Person> {}


/*public class PersonRepository extends AbstractGraphRepository<Node,Person>
{

    public PersonRepository(Neo4jTemplate template, Class<Person> clazz) {
        super(template, clazz);
    }

    @Override
    protected Node getById(long l) {
        return null;
    }

    @Override
    public <N> Iterable<Person> findAllByTraversal(N n, TraversalDescription traversalDescription) {
        return null;
    }
}*/
/*
public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByName(String name);

    Iterable<Person> findByTeammatesName(String name);

}*/
