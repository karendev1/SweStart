package sweStart.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import sweStart.project.domain.entities.User;

public interface UserRepository extends MongoRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByNickName(String nickName);

    User findByNickName(String nickName);


}
