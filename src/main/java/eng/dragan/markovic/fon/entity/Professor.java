package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adress;

	private String email;

	private String firstname;

	private String lastname;

	private String phone;

	@Temporal(TemporalType.DATE)
	private Date reelectiondate;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "TITLE_ID")
	private Title title;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "CITY_ID")
	private City city;

	@OneToMany(mappedBy="professor")
	private List<SubjectProfessor> subjectProfessors;

	public Professor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReelectiondate() {
		return this.reelectiondate;
	}

	public void setReelectiondate(Date reelectiondate) {
		this.reelectiondate = reelectiondate;
	}

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<SubjectProfessor> getSubjectProfessors() {
		return this.subjectProfessors;
	}

	public void setSubjectProfessors(List<SubjectProfessor> subjectProfessors) {
		this.subjectProfessors = subjectProfessors;
	}

	public SubjectProfessor addSubjectProfessor(SubjectProfessor subjectProfessor) {
		getSubjectProfessors().add(subjectProfessor);
		subjectProfessor.setProfessor(this);

		return subjectProfessor;
	}

	public SubjectProfessor removeSubjectProfessor(SubjectProfessor subjectProfessor) {
		getSubjectProfessors().remove(subjectProfessor);
		subjectProfessor.setProfessor(null);

		return subjectProfessor;
	}

}