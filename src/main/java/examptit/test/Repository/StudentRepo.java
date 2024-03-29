package examptit.test.Repository;
import examptit.test.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String>{

}
