package m426.todoapp.todoappbe.task;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import m426.todoapp.todoappbe.state.StateType;
import m426.todoapp.todoappbe.todo.TodoList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    int taskId;
    @Column(name = "name", length = 20)
    String name;
    @Column(name = "description", length = 100)
    String description;
    @Enumerated(EnumType.STRING)
    StateType state;
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_todo_list", referencedColumnName = "todo_list_id", nullable = false)
    @JsonBackReference
    TodoList todoList;
}
