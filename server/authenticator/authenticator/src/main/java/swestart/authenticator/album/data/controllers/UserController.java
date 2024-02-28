package swestart.authenticator.album.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import swestart.authenticator.album.data.models.User;
import swestart.authenticator.album.data.repositories.UserRepository;
import swestart.authenticator.album.data.services.UserService;

@RestController
@RequestMapping("/swe-starter/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping()
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new ErrorResponseException(HttpStatusCode.valueOf(500)));
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
