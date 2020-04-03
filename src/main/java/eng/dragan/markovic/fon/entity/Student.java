package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private int currentYearOfStudy;

	private String email;

	private String firstname;

	private String indexnumber;

	private String lastname;

	private String phone;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "CITY_ID")
	private City city;

	@OneToMany(mappedBy="student")
	private List<StudentExam> studentExams;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCurrentYearOfStudy() {
		return this.currentYearOfStudy;
	}

	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
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

	public String getIndexnumber() {
		return this.indexnumber;
	}

	public void setIndexnumber(String indexnumber) {
		this.indexnumber = indexnumber;
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

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<StudentExam> getStudentExams() {
		return this.studentExams;
	}

	public void setStudentExams(List<StudentExam> studentExams) {
		this.studentExams = studentExams;
	}

	public StudentExam addStudentExam(StudentExam studentExam) {
		getStudentExams().add(studentExam);
		studentExam.setStudent(this);

		return studentExam;
	}

	public StudentExam removeStudentExam(StudentExam studentExam) {
		getStudentExams().remove(studentExam);
		studentExam.setStudent(null);

		return studentExam;
	}

}