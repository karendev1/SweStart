package swestart.authenticator.album.data.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.web.bind.annotation.*;
import swestart.authenticator.album.data.models.User;
import swestart.authenticator.album.data.repositories.UserRepository;

@RestController
@RequestMapping("/swe-starter/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + id));
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
