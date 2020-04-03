package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="subject_professor")
@NamedQuery(name="SubjectProfessor.findAll", query="SELECT s FROM SubjectProfessor s")
public class SubjectProfessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date examdate;

	@OneToMany(mappedBy="subjectProfessor")
	private List<StudentExam> studentExams;

	@ManyToOne
	private Professor professor;

	@ManyToOne
	private Subject subject;

	public SubjectProfessor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExamdate() {
		return this.examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	public List<StudentExam> getStudentExams() {
		return this.studentExams;
	}

	public void setStudentExams(List<StudentExam> studentExams) {
		this.studentExams = studentExams;
	}

	public StudentExam addStudentExam(StudentExam studentExam) {
		getStudentExams().add(studentExam);
		studentExam.setSubjectProfessor(this);

		return studentExam;
	}

	public StudentExam removeStudentExam(StudentExam studentExam) {
		getStudentExams().remove(studentExam);
		studentExam.setSubjectProfessor(null);

		return studentExam;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}