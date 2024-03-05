package sweStart.project.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sweStart.project.domain.ValidationErrorResponse;
import sweStart.project.domain.dtos.IUserDTO;
import sweStart.project.domain.entities.User;
import sweStart.project.repositories.UserRepository;
import sweStart.project.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


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

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody @Valid IUserDTO userDto, BindingResult bindingResult) {
        return userService.saveUser(userDto, bindingResult);
    }

    @DeleteMapping("/{nickname}")
    public ResponseEntity<?> deleteByNickName(@PathVariable String nickname){
        return userService.deleteUserByNickName(nickname);
    }

}
