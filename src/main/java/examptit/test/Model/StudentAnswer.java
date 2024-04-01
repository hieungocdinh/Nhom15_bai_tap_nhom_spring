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
public class StudentAnswer {
    @Id
    private String id = java.util.UUID.randomUUID().toString();
    private String idExam;
    private String idStudent;
    private String idQuestion;
    private String answer;
}
