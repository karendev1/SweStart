package sweStart.project.domain.entities;

import sweStart.project.domain.dtos.IUserDTO;

public class User {
    private String userName;
    private String userNickName;
    private String userEmail;
    private String userPassword;
    private String userProfession;
    private String userAge;
    public User(IUserDTO userDto) {
        this.userName = userDto.getName();
        this.userNickName = userDto.getNickName();
        this.userEmail = userDto.getEmail();
        this.userPassword = userDto.getPassword();
        this.userProfession = userDto.getProfession();
        this.userAge = userDto.getAge();
    }
}
