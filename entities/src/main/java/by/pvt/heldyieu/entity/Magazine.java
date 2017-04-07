package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.interfaces.Identified;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "magazines")
public class Magazine implements Identified, Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

    @Column(name = "name")
	private String name;

    @Column(name = "price")
	private Double price;

    @ManyToOne
    @JoinColumn(name = "category_type")
    private CategoryType categoryType;
	/**
	 * 
	 */
	public Magazine() {
		super();
	}

    public Magazine(String name, Double price, CategoryType categoryType) {
        this.name = name;
        this.price = price;
        this.categoryType = categoryType;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(id, magazine.id) &&
                Objects.equals(name, magazine.name) &&
                Objects.equals(price, magazine.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
