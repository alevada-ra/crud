package dogsmanager.controller;

import dogsmanager.model.Dog;
import dogsmanager.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dogs")
public class DogController {
    private DogService dogService;

    @Autowired(required = true)
    @Qualifier(value = "service")
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addDog(@ModelAttribute("/dogs/add") Dog dog) {
        if (dog.getId() == 0) {
            this.dogService.addDog(dog);
        } else {
            this.dogService.updateDog(dog);
        }

        return "/redirect/dogs";
    }

    @PutMapping("edit/{id}")
    public String editDog(@PathVariable("id") int id, Model model) {
        model.addAttribute("dogs", this.dogService.getDogById(id));
        model.addAttribute("listDogs", this.dogService.listDogs());

        return "dogs";
    }

    @RequestMapping("/remove/{id}")
    public String removeDog(@PathVariable("id") int id) {
        this.dogService.removeDogById(id);

        return "redirect:/dogs";

    }
    @RequestMapping("/dogs/{id}")
    public String getDogById() {

        return null;
    }

    @GetMapping(value = "/dogs")
    public String getAllDogs(Model model) {
        model.addAttribute("dog", new Dog());
        model.addAttribute("listdogs", this.dogService.listDogs());

        return "dogs";
    }
}
