package hr.tvz.mede.studapp.Command;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;


public class StudentCommand {

    private  String firstName;

    private  String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDate dateOfBirth;

    @NotBlank(message =  "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String jmbag;

    private int numberOfEcts;


    public StudentCommand(String firstName, String lastName, @NotBlank(message = "JMBAG must not be empty") @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}") String jmbag, int numberOfEcts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.numberOfEcts = numberOfEcts;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
