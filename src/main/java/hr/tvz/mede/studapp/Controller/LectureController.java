package hr.tvz.mede.studapp.Controller;

import hr.tvz.mede.studapp.Dto.LectureDTO;
import hr.tvz.mede.studapp.Service.CourseService;
import hr.tvz.mede.studapp.Service.LectureService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lecture")
@CrossOrigin(origins = "http://localhost:4200")
public class LectureController {
    private LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<LectureDTO> findAll() {
        return lectureService.findAll();
    }
}
