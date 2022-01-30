package RenderFarmPrototype.services;

import RenderFarmPrototype.model.RenderStatus;
import RenderFarmPrototype.model.Task;
import RenderFarmPrototype.repositories.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UserService userService;

    public void addTask() {
        Task task = new Task();
        task.setCreateTime(new Date());
        task.setRenderStatus(RenderStatus.RENDERING);
        task.setUser(userService.getAuthUser());
        tasksRepository.save(task);
        new Thread(() -> updateStatus(task)).start();
    }

    public List<Task> getCurrentTaskList() {
        List<Task> taskList = new ArrayList<>();
        for (Task task : getAllUserTask()) {
            if (task.getRenderStatus() != RenderStatus.COMPLETE) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    public Task getTaskById(int id) {
        return tasksRepository.findById(id);
    }

    public List<Task> getAllUserTask() {
        return tasksRepository.findByUserId(userService.getAuthUser().getId());
    }

    private void updateStatus(Task task) {
        try {
            Thread.sleep(5000 + (int) (Math.random() * 15000));
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        task.setRenderStatus(RenderStatus.COMPLETE);
        task.setCompleteTime(new Date());
        tasksRepository.save(task);
    }
}
