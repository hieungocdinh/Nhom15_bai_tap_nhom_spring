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
public class Result {
    @Id
    private String id = java.util.UUID.randomUUID().toString();
    private String idStudent;
    private String idExam;
    private float score;
}
