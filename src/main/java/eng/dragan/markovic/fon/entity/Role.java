package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="roles")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}