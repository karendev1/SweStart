package sweStart.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import sweStart.project.domain.entities.User;

public interface UserRepository extends MongoRepository<User, Long> {}
