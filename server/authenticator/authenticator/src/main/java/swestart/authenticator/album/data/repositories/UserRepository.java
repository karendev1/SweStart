package swestart.authenticator.album.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import swestart.authenticator.album.data.models.User;

public interface UserRepository extends MongoRepository<User, Long> {}