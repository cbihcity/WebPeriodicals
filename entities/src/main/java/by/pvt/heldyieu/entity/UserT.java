package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.interfaces.Identified;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by HeroDishonest on 07.04.2017.
 */
@Entity
@Table(name = "users_type")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class UserT implements Identified, Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "userT")
    private Set<User> users;
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserT)) return false;

        UserT userT = (UserT) o;

        if (getId() != null ? !getId().equals(userT.getId()) : userT.getId() != null) return false;
        if (getType() != null ? !getType().equals(userT.getType()) : userT.getType() != null) return false;
        return getUsers() != null ? getUsers().equals(userT.getUsers()) : userT.getUsers() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
