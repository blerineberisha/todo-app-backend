package m426.todoapp.todoappbe.task;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @PutMapping("/{id}")
    //@PreAuthorize("permitAll()")
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(task, id), HttpStatus.OK);
    }
}
