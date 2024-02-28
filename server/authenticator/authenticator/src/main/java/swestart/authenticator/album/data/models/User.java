package swestart.authenticator.album.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String user;
    private String email;
    private String password;
    private String profession;
    private String age;
    private String goal;

}