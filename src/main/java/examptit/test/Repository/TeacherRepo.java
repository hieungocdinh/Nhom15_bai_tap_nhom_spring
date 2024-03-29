package examptit.test.Repository;
import examptit.test.Model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepo extends MongoRepository<Teacher, String>{

}
