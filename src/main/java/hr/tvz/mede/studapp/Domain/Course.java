package hr.tvz.mede.studapp.Domain;

import hr.tvz.mede.studapp.Enum.SemesterType;

import javax.persistence.*;
import java.util.List;


@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer numberOfEcts;
    @Enumerated(EnumType.ORDINAL)
    private SemesterType semester;

    @ManyToMany(targetEntity = Student.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id")},
            inverseJoinColumns = { @JoinColumn(name = "course_id")}
    )
    private List<Student> students;

    public Course() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfEcts() {
        return numberOfEcts;
    }

    public void setNumberOfEcts(Integer numberOfECTS) {
        this.numberOfEcts = numberOfECTS;
    }

    public SemesterType getSemester() {
        return semester;
    }

    public void setSemester(SemesterType semester) {
        this.semester = semester;
    }

    public List<Student> getStudents() { return students; }

    public void setStudents(List<Student> students) { this.students = students; }
}
