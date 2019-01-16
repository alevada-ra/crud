package dogsmanager.service;

import dogsmanager.dao.DogDao;
import dogsmanager.model.Dog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DogServiceImplemantation implements DogService {
    private DogDao dogDao;

    public void setDogDao(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    @Override
    @Transactional
    public void addDog(Dog dog) {
        this.dogDao.addDog(dog);
    }

    @Override
    @Transactional
    public void updateDog(Dog dog) {
        this.dogDao.updateDog(dog);
    }

    @Override
    @Transactional
    public void removeDogById(int id) {
        this.dogDao.removeDogById(id);
    }

    @Override
    @Transactional
    public Dog getDogById(int id) {
        return this.dogDao.getDogById(id);
    }

    @Override
    @Transactional
    public List<Dog> listDogs() {
        return this.dogDao.listDogs();
    }
}
