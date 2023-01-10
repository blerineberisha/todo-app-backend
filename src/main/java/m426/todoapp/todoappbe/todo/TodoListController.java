package m426.todoapp.todoappbe.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/todolist"})
public class TodoListController {

  @Autowired
  private TodoListService listService;

  @GetMapping("/")
  public ResponseEntity findAllTodoLists() {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(listService.getAllToDoLists());
    } catch (NullPointerException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }
}
