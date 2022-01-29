package RenderFarmPrototype.services;

import RenderFarmPrototype.model.RenderStatus;
import RenderFarmPrototype.model.Task;
import RenderFarmPrototype.repositories.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UserService userService;

    public void addTask(){
        Task task = new Task();
        task.setCreateTime(new Date());
        task.setRenderStatus(RenderStatus.RENDERING);
        task.setUser(userService.getAuthUser());
        tasksRepository.save(task);
    }

    public List<Task> getAllUserTask () {
        return tasksRepository.findByUserId(userService.getAuthUser().getId());
    }
}
