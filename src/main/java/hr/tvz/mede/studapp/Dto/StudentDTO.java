package hr.tvz.mede.studapp.Dto;

import hr.tvz.mede.studapp.Domain.Authority;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class StudentDTO {

    private String firstName;
    private String lastName;
    private String jmbag;
    private Integer numberOfEcts;
    private Boolean tuitionShouldBePaid;

    public StudentDTO(String firstName , String lastName ,String jmbag, Integer numberOfEcts, Boolean tuitionShouldBePaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.numberOfEcts = numberOfEcts;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    public StudentDTO() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public Integer getNumberOfEcts() {
        return numberOfEcts;
    }

    public void setNumberOfECTS(Integer numberOfEcts) {
        this.numberOfEcts = numberOfEcts;
    }

    public Boolean getTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

    public void setTuitionShouldBePaid(Boolean tuitionShouldBePaid) {
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "jmbag='" + jmbag + '\'' +
                ", numberOfECTS=" + numberOfEcts +
                ", tuitionShouldBePaid=" + tuitionShouldBePaid +
                '}';
    }
}