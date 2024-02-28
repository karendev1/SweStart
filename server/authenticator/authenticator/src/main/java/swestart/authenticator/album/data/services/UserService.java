package swestart.authenticator.album.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swestart.authenticator.album.data.models.User;
import swestart.authenticator.album.data.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}