package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.Course;
import hr.tvz.mede.studapp.Dto.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAll();

    List<Course> findByStudentsJmbag(String jmbag);

    List<Course  > findByNumberOfEcts(int numberOfEcts);
}
