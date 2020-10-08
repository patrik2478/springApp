package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Command.StudentCommand;
import hr.tvz.mede.studapp.Domain.Lecture;
import hr.tvz.mede.studapp.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface LectureRepository {
    List<Lecture> findAll();
}
