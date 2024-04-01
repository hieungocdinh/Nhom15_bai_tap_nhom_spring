package examptit.test.Controller;

import examptit.test.Model.LoginRequest;
import examptit.test.Model.User;

import examptit.test.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// No changes needed, removing the unused import statement
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class LoginController {

    @Autowired
    private UserRepo userRepo;
    
    @PostMapping("login")
    public String postMethodName(@RequestBody User loginRequest) {
        User user = userRepo.findByUsername(loginRequest.getUsername());
        if (user == null) {
            return "User not found";
        }
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return user.getType();
        }
        return "Incorrect password";
    }
    
}
