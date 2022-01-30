package RenderFarmPrototype.controllers;

import RenderFarmPrototype.model.Task;
import RenderFarmPrototype.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/showHistory/{id}")
    public String showChangeStatusHistory(@PathVariable int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "taskHistory";
    }

    @PostMapping("/addTask")
    public String addTask() {
        taskService.addTask();
        return "redirect:/user_page";
    }
}
