package examptit.test.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id = java.util.UUID.randomUUID().toString();

    @Indexed(unique = true)
    private String username;

    private String password;
    
    private String email;

    private String type;

    
}
