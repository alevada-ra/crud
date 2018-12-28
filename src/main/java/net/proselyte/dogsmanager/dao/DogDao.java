package net.proselyte.dogsmanager.dao;

import net.proselyte.dogsmanager.model.Dog;

import java.util.List;

/**
 * Created by alevada on 10/25/18.
 */
public interface DogDao {
    void addDog(Dog dog);
    void updateDog(Dog dog);
    void removeDogById(int id);
    Dog getDogById(int id);
    List<Dog> listDogs();
}
