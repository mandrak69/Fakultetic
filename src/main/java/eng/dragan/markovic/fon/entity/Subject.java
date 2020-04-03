package eng.dragan.markovic.fon.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	private String semester;

	private short yearOfStudy;

	@OneToMany(mappedBy="subject")
	private List<SubjectProfessor> subjectProfessors;

	public Subject() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public short getYearOfStudy() {
		return this.yearOfStudy;
	}

	public void setYearOfStudy(short yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public List<SubjectProfessor> getSubjectProfessors() {
		return this.subjectProfessors;
	}

	public void setSubjectProfessors(List<SubjectProfessor> subjectProfessors) {
		this.subjectProfessors = subjectProfessors;
	}

	public SubjectProfessor addSubjectProfessor(SubjectProfessor subjectProfessor) {
		getSubjectProfessors().add(subjectProfessor);
		subjectProfessor.setSubject(this);

		return subjectProfessor;
	}

	public SubjectProfessor removeSubjectProfessor(SubjectProfessor subjectProfessor) {
		getSubjectProfessors().remove(subjectProfessor);
		subjectProfessor.setSubject(null);

		return subjectProfessor;
	}

}