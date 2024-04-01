package examptit.test.Repository;
import examptit.test.Model.StudentAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentAnswerRepo extends MongoRepository<StudentAnswer, String>{
    List<StudentAnswer> findByIdExamAndIdStudent(String idExam, String idStudent);
}
