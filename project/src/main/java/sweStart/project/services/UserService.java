package sweStart.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import sweStart.project.domain.ValidationErrorResponse;
import sweStart.project.domain.dtos.IUserDTO;
import sweStart.project.domain.entities.User;
import sweStart.project.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
 public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isValidEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    public boolean isValidNickName(String nickName) {
        return !userRepository.existsByNickName(nickName);
    }

    public ResponseEntity<?> deleteUserByNickName(String nickName) {
        User user = userRepository.findByNickName(nickName);

        if (user != null) {
            userRepository.delete(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nickname not found");
        }
    }

    public ResponseEntity<?> saveUser(IUserDTO userDto, BindingResult bindingResult) {
        if (!isValidEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().body("email is already registered");
        }
        if (!isValidNickName(userDto.getNickName())) {
            return ResponseEntity.badRequest().body("nickName is already registered");
        }

        if (bindingResult.hasErrors()) {
            List<ValidationErrorResponse> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> new ValidationErrorResponse(
                            error.getField(),
                            error.getDefaultMessage()
                    ))
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(userDto.getPassword());

        userDto.setPassword(encryptedPassword);
        userRepository.save(new User(userDto));
        return ResponseEntity.status(201).body("User saved successfully");
    }
}
