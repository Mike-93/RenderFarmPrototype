package RenderFarmPrototype.controllers;

import RenderFarmPrototype.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public String addUser (@RequestParam String firstName, @RequestParam String lastName,
                           @RequestParam String email, @RequestParam String password){
        userService.addUser(firstName, lastName, email, password);
        return "redirect:/";
    }
}
