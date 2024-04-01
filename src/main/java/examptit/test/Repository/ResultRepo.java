package examptit.test.Repository;
import examptit.test.Model.Result;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepo extends MongoRepository<Result, String>{
    Result findByIdExamAndIdStudent(String idExam, String idStudent);
}