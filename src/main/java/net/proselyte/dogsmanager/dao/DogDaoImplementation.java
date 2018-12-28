package net.proselyte.dogsmanager.dao;

import net.proselyte.dogsmanager.model.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogDaoImplementation implements DogDao {
    private static final Logger logger = LoggerFactory.getLogger(DogDaoImplementation.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDog(Dog dog) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dog);

        logger.info("Dog was sucesfully added");
    }

    @Override
    public void updateDog(Dog dog) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dog);

        logger.info("Dog was sucesfully updated");
    }

    @Override
    public void removeDogById(int id) {
        Dog dog = new Dog();
        Session session = this.sessionFactory.getCurrentSession();
        dog.setId(id);

        if(dog != null) {
            session.delete(dog);
            logger.info("Dog was sucesfully removed");
        }
    }

    @Override
    public Dog getDogById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dog dog = session.load(Dog.class, new Integer(id));
        logger.info("Dog was sucesfully loaded: " + dog);

        return dog;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Dog> listDogs() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Dog> dogsList = session.createQuery("from Dog").list();

        for(Dog dog : dogsList) {
            logger.info("Dogs list: " + dog);
        }

        return dogsList;
    }
}
