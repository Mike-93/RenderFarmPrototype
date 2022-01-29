package RenderFarmPrototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String getSignInPage() {
        return "redirect:/signIn";
    }

    @GetMapping("/signUp_page")
    public String getSignUpPage() {
        return "signUp_page";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "signIn_page";
    }

    @PostMapping("/signIn")
    public String authentication() {
        return "redirect:/user_page";
    }
}
