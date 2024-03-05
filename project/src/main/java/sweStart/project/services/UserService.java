package sweStart.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweStart.project.repositories.UserRepository;

@Service
 public class UserService {

    @Autowired
    private UserRepository userRepository;
    public boolean isValidEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean isValidNickName(String nickName) {
        return userRepository.existsByNickName(nickName);
    }
}
