package dogsmanager.dao;

import dogsmanager.model.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogDaoImplementation implements DogDao {
    private static final org.jboss.logging.Logger logger = LoggerFactory.logger(DogDaoImplementation.class);

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
        Session session = this.sessionFactory.getCurrentSession();
        Dog dog = session.load(Dog.class, new Integer(id));

        if(dog != null) {
            session.delete(id);
            logger.info("Dog was sucesfully removed");
        }
    }

    @Override
    public Dog getDogById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dog dog = session.load(Dog.class, new Integer(id));
        logger.info("\"Dog was sucesfully loaded: " + dog);

        return dog;
    }

    @Override
    public List<Dog> listDogs() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Dog> dogsList = session.createQuery("list").list();

        for(Dog dog : dogsList) {
            logger.info("Dogs list: " + dogsList);
        }

        return dogsList;
    }
}
