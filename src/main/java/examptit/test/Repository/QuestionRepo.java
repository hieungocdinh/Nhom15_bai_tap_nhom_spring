package examptit.test.Repository;
import examptit.test.Model.Question;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<Question, String>{
    List<Question> findByIdExam(String idExam);
}
