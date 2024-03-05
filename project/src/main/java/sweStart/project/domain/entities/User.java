package sweStart.project.domain.entities;

import sweStart.project.domain.dtos.IUserDTO;

public class User {
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
