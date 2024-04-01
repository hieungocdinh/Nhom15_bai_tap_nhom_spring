package examptit.test.Controller;

import org.springframework.web.bind.annotation.RestController;

import examptit.test.Model.Student;
import examptit.test.Model.Teacher;
import examptit.test.Model.Exam;
import examptit.test.Model.Question;
import examptit.test.Model.StudentAnswer;
import examptit.test.Model.Result;

import examptit.test.Repository.StudentRepo;
import examptit.test.Repository.TeacherRepo;
import examptit.test.Repository.ExamRepo;
import examptit.test.Repository.QuestionRepo;
import examptit.test.Repository.StudentAnswerRepo;
import examptit.test.Repository.ResultRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    @Autowired
    private StudentAnswerRepo studentAnswerRepo;
    @Autowired
    private ResultRepo resultRepo;

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
    public String createQuestion(@RequestBody List<Question> questions) {
        for(Question question : questions) {
            Question questionSaved = questionRepo.save(question);
        }
        return "Success";
    }

    @PostMapping("/createinf/answer")
    public String createStudentAnswer(@RequestBody List<StudentAnswer> studentAnswers) {
        // Your code here
        for(StudentAnswer studentAnswer : studentAnswers) {
            StudentAnswer studentAnswerSaved = studentAnswerRepo.save(studentAnswer);
            // update result
            if(resultRepo.findByIdExamAndIdStudent(studentAnswer.getIdExam(), studentAnswer.getIdStudent()) == null) {
                Result result = new Result();
                result.setIdExam(studentAnswerSaved.getIdExam());
                result.setIdStudent(studentAnswerSaved.getIdStudent());
                // calculate score
                float score = 0;
                Question question = questionRepo.findById(studentAnswerSaved.getIdQuestion()).get();
                int totalQuestion = questionRepo.findByIdExam(studentAnswerSaved.getIdExam()).size();
                if(studentAnswerSaved.getAnswer().equals(question.getAnsCorrect())) {
                    score = 10/totalQuestion;
                }
                result.setScore(score);
                resultRepo.save(result);
            }
            else {
                Result result = resultRepo.findByIdExamAndIdStudent(studentAnswerSaved.getIdExam(), studentAnswerSaved.getIdStudent());
                // calculate score
                float score = result.getScore();
                Question question = questionRepo.findById(studentAnswerSaved.getIdQuestion()).get();
                int totalQuestion = questionRepo.findByIdExam(studentAnswerSaved.getIdExam()).size();
                if(studentAnswerSaved.getAnswer().equals(question.getAnsCorrect())) {
                    score += 10/totalQuestion;
                }
                result.setScore(score);
                resultRepo.save(result);
                
            }
        }
        return Float.toString(resultRepo.findByIdExamAndIdStudent(studentAnswers.get(0).getIdExam(), studentAnswers.get(0).getIdStudent()).getScore());
    }
        

    
    
    
}
