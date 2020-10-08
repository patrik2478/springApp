package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAll();
    List<CourseDTO> getByStudentJMBAG(String jmbag);
    List<CourseDTO> findByNumberOfEcts(int numberOfEcts);
}
