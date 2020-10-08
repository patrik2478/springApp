package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Domain.Course;
import hr.tvz.mede.studapp.Dto.CourseDTO;
import hr.tvz.mede.studapp.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToCourse).collect(Collectors.toList());
    }
    @Override
    public List<CourseDTO> getByStudentJMBAG(String jmbag) {
        return courseRepository.findByStudentsJmbag(jmbag).stream().map(this::mapCourseToCourse).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByNumberOfEcts(int numberOfEcts) {
        return courseRepository.findByNumberOfEcts(numberOfEcts).stream().map(this::mapCourseToCourse).collect(Collectors.toList());
    }

    private CourseDTO mapCourseToCourse(final Course course){
        return new CourseDTO(course.getName(), course.getNumberOfEcts());
    }



}
