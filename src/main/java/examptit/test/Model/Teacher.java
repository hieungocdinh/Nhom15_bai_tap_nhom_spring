package examptit.test.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    private String id = java.util.UUID.randomUUID().toString();
    private String name;
    private String teacherNum;  
    private String idUser;
}
