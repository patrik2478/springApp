package hr.tvz.mede.studapp.Dto;

import hr.tvz.mede.studapp.Enum.SemesterType;

public class CourseDTO {

    private String name;
    private Integer numberOfEcts;

    public CourseDTO(String name, Integer numberOfEcts) {
        this.name = name;
        this.numberOfEcts = numberOfEcts;
    }

    public CourseDTO() {
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

    public void setNumberOfEcts(Integer numberOfEcts) {
        this.numberOfEcts = numberOfEcts;
    }
}
