package dogsmanager.dao;

import dogsmanager.model.Dog;

import java.util.List;

public interface DogDao {
    void addDog(Dog dog);
    void updateDog(Dog dog);
    void removeDogById(int id);
    Dog getDogById(int id);
    List<Dog> listDogs();
}
