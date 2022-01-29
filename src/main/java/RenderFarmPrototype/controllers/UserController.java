package RenderFarmPrototype.controllers;

import RenderFarmPrototype.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user_page")
    public String getUserPage() {
        return "user_page";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName,
                          @RequestParam String email, @RequestParam String password) {
        userService.addUser(firstName, lastName, email, password);
        return "redirect:/";
    }
}
