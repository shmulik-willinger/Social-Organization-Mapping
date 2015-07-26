package core.services;

import core.dao.PersonsDao;
import core.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonsBusinessService {
    @Autowired
    private PersonsDao personsDao;

    @Transactional
    public Person getById(Integer id) {
        return personsDao.read(Person.class, id);
    }

    @Transactional
    public void saveUser(Person user) throws Exception
    {
        if (ValidateUniqeUserName(user))
            personsDao.create(user);
        else
            throw new Exception("Person already exist");
    }

    private boolean ValidateUniqeUserName(Person user)
    {
        Person userWithSameName = personsDao.GetUserByName(user.getFirstName());
        return userWithSameName == null;
    }

    @Transactional
    public void update(Person user) {
        personsDao.update(user);
    }
}
