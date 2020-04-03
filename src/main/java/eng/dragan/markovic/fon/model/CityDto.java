package eng.dragan.markovic.fon.model;

import java.io.Serializable;

//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CityDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Morete uneti ptt broj")
	private Long id;
	private String number;
	//@NotEmpty(message = "Morate uneti ime")
	private String name;
	
	public CityDto() {
	}
	
	public CityDto(Long id, String name) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
	}

	

	public CityDto(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CityDto [id=" + id + ", number=" + number + ", name=" + name + "]";
	}

	

	
	
}
