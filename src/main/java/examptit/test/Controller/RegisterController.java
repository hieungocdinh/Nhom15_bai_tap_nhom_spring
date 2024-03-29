package examptit.test.Controller;

import examptit.test.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import examptit.test.Repository.UserRepo;

@RestController
public class RegisterController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User userSaved = userRepo.save(user);
        return userSaved.getId();
    }
}
