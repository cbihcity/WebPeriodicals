package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.interfaces.Identified;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by HeroDishonest on 07.04.2017.
 */
@Entity
@Table(name = "users_type")
public class UserT implements Identified, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "userT")
    private Set<User> users;

    public UserT() {
    }

    public UserT(String type, Set<User> users) {
        this.type = type;
        this.users = users;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserT userT = (UserT) o;
        return Objects.equals(id, userT.id) &&
                Objects.equals(type, userT.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
