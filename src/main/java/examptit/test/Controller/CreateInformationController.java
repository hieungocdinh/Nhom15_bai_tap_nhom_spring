package examptit.test.Controller;

import org.springframework.web.bind.annotation.RestController;

import examptit.test.Model.Student;
import examptit.test.Model.Teacher;
import examptit.test.Model.Exam;
import examptit.test.Model.Question;

import examptit.test.Repository.StudentRepo;
import examptit.test.Repository.TeacherRepo;
import examptit.test.Repository.ExamRepo;
import examptit.test.Repository.QuestionRepo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CreateInformationController {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private ExamRepo examRepo;
    @Autowired
    private QuestionRepo questionRepo;

    @PostMapping("/createinf/student")
    public String createStudent(@RequestBody Student student) {
        Student studentSaved = studentRepo.save(student);
        return studentSaved.getId();
    }

    @PostMapping("/createinf/teacher")
    public String createTeacher(@RequestBody Teacher teacher) {
        Teacher teacherSaved = teacherRepo.save(teacher);
        return teacherSaved.getId();
    }
    
    @PostMapping("/createinf/exam")
    public String createExam(@RequestBody Exam exam) {
        Exam examSaved = examRepo.save(exam);
        return examSaved.getId();
    }

    @PostMapping("/createinf/question")
    public String createQuestion(@RequestBody Question question) {
        Question questionSaved = questionRepo.save(question);
        return questionSaved.getId();
    }
    
}
