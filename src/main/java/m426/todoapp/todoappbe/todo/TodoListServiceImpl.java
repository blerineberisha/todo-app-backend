package m426.todoapp.todoappbe.todo;

import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TodoListServiceImpl implements TodoListService{

  @Autowired
  private TodoListRepository todoListRepository;

  @Override
  public List<TodoList> getAllToDoLists() throws NullPointerException {
  List<TodoList> toDoLists = todoListRepository.findAll();
    if (toDoLists.isEmpty()) {
      throw new NullPointerException("Todo List not found");
    } else
      return toDoLists;
  }
}
