package RenderFarmPrototype.controllers;

import RenderFarmPrototype.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public String addTask() {
        taskService.addTask();
        return "redirect:/user_page";
    }
}
