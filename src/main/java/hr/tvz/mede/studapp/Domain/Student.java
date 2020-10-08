package hr.tvz.mede.studapp.Domain;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String jmbag;
    private int numberOfEcts;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "course_student",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private List<Course> courses;

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public int getNumberOfEcts() {
        return numberOfEcts;
    }

    public void setNumberOfEcts(int numberOfECTS) {
        this.numberOfEcts = numberOfEcts;
    }

    public List<Course> getCourses() { return courses; }

    public void setCourses(List<Course> courses) { this.courses = courses; }


}