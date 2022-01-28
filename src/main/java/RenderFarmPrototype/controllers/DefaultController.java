package RenderFarmPrototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String getSignUpPage() {
        return "signIn_page";
    }

    @GetMapping("/signUp_page")
    public String getSignInPage() {
        return "signUp_page";
    }

    @PostMapping("/signIn")
    public String signIn () {
        return "user_page";
    }
}
