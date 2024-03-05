package sweStart.project.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class IUserDTO {
    @Size(min=3, max = 150, message = "The name cannot be less than 3 characters and more than 150 characters")
    @NotBlank(message = "The name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The name must contain only letters.")
    private String name;
    @Size(min = 3, max = 20, message = "The nickName cannot be less than 3 characters and more than 20 characters")
    @NotBlank
    @Field("userNickName")
    private String nickName;
    @NotBlank(message = "The email cannot be empty")
    @Field("userEmail")
    @Email(message = "Email doesn't meet the requirements")
    private String email;
    @Size(min = 8, max = 8, message = "The password must be 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$",
            message = "The password must contain at least one letter, one number, and one special character.")
    private String password;
    @NotBlank
    private String profession;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$", message = "The field must contain only numbers.")
    private String age;
}
