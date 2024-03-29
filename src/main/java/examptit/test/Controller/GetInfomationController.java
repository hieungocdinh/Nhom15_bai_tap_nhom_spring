package examptit.test.Controller;

import examptit.test.Model.Student;
import examptit.test.Model.Teacher;
import examptit.test.Model.Exam;
import examptit.test.Model.Question;

import examptit.test.Repository.ExamRepo;
import examptit.test.Repository.QuestionRepo;
import examptit.test.Repository.StudentRepo;
import examptit.test.Repository.TeacherRepo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class GetInfomationController {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private ExamRepo examRepo;
    @Autowired
    private QuestionRepo questionRepo;

    // get all student
    @GetMapping("get/student")
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    // get all teacher
    @GetMapping("get/teacher")
    public List<Teacher> getMethodName() {
        return teacherRepo.findAll();
    }
    // get all exam
    @GetMapping("get/exam")
    public List<Exam> getExam() {
        return examRepo.findAll();
    }

    // get question by id exam
    @GetMapping("get/exam/{id}")
    public List<Question> getQuestionByIdExam(@PathVariable String id) {
        return questionRepo.findByIdExam(id);
    }
}
