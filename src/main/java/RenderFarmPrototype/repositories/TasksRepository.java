package RenderFarmPrototype.repositories;

import RenderFarmPrototype.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Integer> {

    List<Task> findByUserId(int userId);

    Task findById(int id);
}
