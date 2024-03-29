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
public class Question {
    @Id
    private String id = java.util.UUID.randomUUID().toString();
    private String idExam;
    private String main;
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;
    private String ansCorrect;
}
