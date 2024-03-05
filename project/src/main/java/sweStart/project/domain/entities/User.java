package sweStart.project.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import sweStart.project.domain.dtos.IUserDTO;

@NoArgsConstructor
public class User {
    private ObjectId id;
    private String name;
    private String nickName;
    private String email;
    private String password;
    private String profession;
    private String age;
    public User(IUserDTO userDto) {
        this.name = userDto.getName();
        this.nickName = userDto.getNickName();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.profession = userDto.getProfession();
        this.age = userDto.getAge();
    }
}
