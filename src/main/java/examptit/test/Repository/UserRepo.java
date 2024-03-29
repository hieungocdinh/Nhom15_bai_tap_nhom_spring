package examptit.test.Repository; 
import examptit.test.Model.User; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String>{

}
