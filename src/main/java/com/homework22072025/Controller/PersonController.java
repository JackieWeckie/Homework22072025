package com.homework22072025.Controller;

import com.homework22072025.Model.Person;
import com.homework22072025.Repository.PersonRepository;
import com.homework22072025.Type.WorkerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/home")
    public String home(Model model){
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "person/index";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        personRepository.deleteAll();
        return "redirect:/person/home";
    }

    private void addPeople() {
        if (personRepository.count() == 0) {
            List<Person> list = List.of(
                    new Person("Nikita", "Morozov", (byte) 43),
                    new Person("Ivan", "Ivanov", (byte) 25),
                    new Person("Dmitry", "Ivanov", (byte) 56),
                    new Person("Alexey", "Stepanov", (byte) 19)
            );
            personRepository.saveAll(list);
        }
    }

    @GetMapping("/addPeople")
    public String addPeople(Model model) {
        addPeople();
        return "redirect:/person/home";
    }

    @GetMapping("/sort/{columIndex}")
    public String home(Model model, @PathVariable Long columIndex, String sort) {
        List<Person> list = personRepository.findAll();
        //sort
        model.addAttribute("people", list);
        model.addAttribute("title", "Home page");
        return "person/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(Model model,@PathVariable Long id){
        personRepository.deleteById(id);
        return "redirect:/person/home";
    }

    @GetMapping("/edit/{id}")
    public String editById(Model model,@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);
        model.addAttribute("person",person.get());
        model.addAttribute("options", Arrays.stream(WorkerType.values()).map(Enum::name));
        return "/person/edit";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("person",new Person());
        model.addAttribute("options", Arrays.stream(WorkerType.values()).map(Enum::name));
        return "/person/create";
    }

    @PostMapping("/create")
    public String create(Person person){
        personRepository.save(person);
        return "redirect:/person/home";
    }
}
