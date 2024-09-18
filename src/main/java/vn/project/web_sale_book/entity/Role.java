package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeRole;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "code_role"),
            inverseJoinColumns = @JoinColumn(name = "code_user")
    )
    List<User> userList;
}
