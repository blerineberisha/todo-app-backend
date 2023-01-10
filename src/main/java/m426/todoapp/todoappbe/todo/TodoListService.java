package m426.todoapp.todoappbe.todo;

import java.util.List;
import java.util.Optional;

public interface TodoListService {
  List<TodoList> getAllToDoLists() throws NullPointerException;

}
