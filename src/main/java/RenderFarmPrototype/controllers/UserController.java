package RenderFarmPrototype.controllers;

import RenderFarmPrototype.model.User;
import RenderFarmPrototype.security.details.UserDetailsServiceImpl;
import RenderFarmPrototype.services.TaskService;
import RenderFarmPrototype.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/user_page")
    public String getUserPage(Model model) {
        model.addAttribute("user", userService.getAuthUser());
        model.addAttribute("taskList", taskService.getAllUserTask());
        return "user_page";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName,
                          @RequestParam String email, @RequestParam String password) {
        userService.addUser(firstName, lastName, email, password);
        return "redirect:/";
    }
}
