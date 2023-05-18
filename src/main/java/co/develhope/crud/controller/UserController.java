package co.develhope.crud.controller;

import co.develhope.crud.entity.User;
import co.develhope.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping
    public @ResponseBody User createUser(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }

    @GetMapping
    public @ResponseBody List<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody User getAUser(@PathVariable long id){
        Optional<User> user =  userRepository.findById(id);
        return user.orElse(null);
    }

    @PutMapping("/{id}")
    public @ResponseBody User uploadEta (@PathVariable long id, @RequestParam("eta") int eta){
        User user = userRepository.findById(id).orElseThrow();
        user.setEta(eta);
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        userRepository.deleteById(id);
    }

}
