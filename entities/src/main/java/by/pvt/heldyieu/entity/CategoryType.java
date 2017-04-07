package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.interfaces.Identified;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by HeroDishonest on 07.04.2017.
 */
@Entity
@Table(name = "category_type")
public class CategoryType implements Identified, Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "type_name")
    private String type;

    @OneToMany(mappedBy = "categoryType")
    private Set<Magazine> magazines;

    public CategoryType() {
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

    public Set<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(Set<Magazine> magazines) {
        this.magazines = magazines;
    }

    public CategoryType(String type, Set<Magazine> magazines) {
        this.type = type;
        this.magazines = magazines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryType that = (CategoryType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return type;
    }
}
