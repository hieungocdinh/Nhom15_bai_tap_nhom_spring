package examptit.test.Repository;
import examptit.test.Model.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepo extends MongoRepository<Exam, String>{

}
