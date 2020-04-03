package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String activ;

	private String date;

	private String email;

	private String password;

	@ManyToOne
	@JoinColumn(name="roles_id")
	private Role role;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActiv() {
		return this.activ;
	}

	public void setActiv(String activ) {
		this.activ = activ;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}