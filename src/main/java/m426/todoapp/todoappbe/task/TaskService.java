package m426.todoapp.todoappbe.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private final TaskRepository tRepo;

    public Task updateTask(Task task, int id){
        Task oldTask = tRepo.getReferenceById(id);
        oldTask.setName(task.getName());
        oldTask.setDescription(task.getDescription());
        oldTask.setState(task.getState());
        return tRepo.save(oldTask);
    }

}
