package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

 
@Entity
@Table(name="student_exams")
@NamedQuery(name="StudentExam.findAll", query="SELECT s FROM StudentExam s")
public class StudentExam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	private Student student;

	@ManyToOne
	@JoinColumn(name="subject_professor_id")
	private SubjectProfessor subjectProfessor;

	public StudentExam() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public SubjectProfessor getSubjectProfessor() {
		return this.subjectProfessor;
	}

	public void setSubjectProfessor(SubjectProfessor subjectProfessor) {
		this.subjectProfessor = subjectProfessor;
	}

}