package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.interfaces.Identified;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="user")
public class User implements Identified, Serializable{
	
	private static final long serialVersionUID = -7237973696500040785L;

	    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
		private Integer id;

	    @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "password")
	    private String password;

<<<<<<< HEAD
	    @Column(name = "user_type_id", updatable = true)
        @Enumerated(EnumType.ORDINAL)
	    private UserType userType;
=======
	    @Column(name = "user_type_id", updatable = false)
	    private Integer userType;
>>>>>>> origin/master


	public User() {
	}

<<<<<<< HEAD
    public User(String firstName, String lastName, String email, String password, UserType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = type;
    }

    @Override
    public Integer getId() {
        return id;
    }
=======
	public User(String firstName, String lastName, String email, String password, Integer userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}

	/**
		 * @return the id
		 */
		@Override
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the userType
		 */
		public Integer getUserType() {
			return userType;
		}
		/**
		 * @param userType the userType to set
		 */
		public void setUserType(Integer userType) {
			this.userType = userType;
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(firstName, user.firstName) &&
				Objects.equals(lastName, user.lastName) &&
				Objects.equals(email, user.email) &&
				Objects.equals(password, user.password) &&
				userType == user.userType;
	}
>>>>>>> origin/master

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType type) {
        this.userType = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, userType);
    }
}
