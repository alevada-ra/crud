package net.proselyte.dogsmanager.controller;

import net.proselyte.dogsmanager.model.Dog;
import net.proselyte.dogsmanager.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DogController {
    private DogService dogService;

    @Autowired(required = true)
    @Qualifier(value = "dogService")
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @RequestMapping(value = "/dogs/add", method = RequestMethod.POST)
    public String addDog(@ModelAttribute("dog") Dog dog, BindingResult bindingResult) {
        if (dog.getId() == 0) {
            this.dogService.addDog(dog);
        } else {
            this.dogService.updateDog(dog);
        }
        return "redirect:/dogs";
    }

    @RequestMapping("edit/{id}")
    public String modifyDog(@PathVariable("id") int id, Model model) {
        model.addAttribute("dog", this.dogService.getDogById(id));
        model.addAttribute("listDogs", this.dogService.listDogs());
        return "dogs";
    }

    @RequestMapping("/remove/{id}")
    public String removeDog(@PathVariable("id") int id) {
        this.dogService.removeDogById(id);
        return "redirect:/dogs";
    }

    @RequestMapping(value = "dogs", method = RequestMethod.GET)
    public String listOfDogs(Model model) {
        model.addAttribute("dog", new Dog());
        model.addAttribute("listDogs", this.dogService.listDogs());
        return "dogs";
    }
}
