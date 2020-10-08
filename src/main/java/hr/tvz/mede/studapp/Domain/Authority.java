package hr.tvz.mede.studapp.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Authority {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "authority_id")}
    )
    private List<User> users;

    public Authority() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
