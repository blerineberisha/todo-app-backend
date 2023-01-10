package m426.todoapp.todoappbe.role;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import m426.todoapp.todoappbe.authority.Authority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    int roleId;
    @Column(name = "role_name", length = 20, unique = true)
    String roleName;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "role_authority",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
    )
    Set<Authority> authorities = new HashSet<>();
}
