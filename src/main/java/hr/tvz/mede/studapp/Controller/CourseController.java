package hr.tvz.mede.studapp.Controller;


import hr.tvz.mede.studapp.Domain.Course;
import hr.tvz.mede.studapp.Domain.Student;
import hr.tvz.mede.studapp.Service.CourseService;
import hr.tvz.mede.studapp.Dto.CourseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping(value = "", produces = "application/json")
    public List<CourseDTO> getAll() {
        return courseService.getAll();
    }

    @GetMapping(value = "/{jmbag}", produces = "application/json")
    public List<CourseDTO> getByStudentJMBAG(@PathVariable String jmbag) {
        return courseService.getByStudentJMBAG(jmbag);
    }

}