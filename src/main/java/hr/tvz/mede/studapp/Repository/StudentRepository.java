package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.Student;
import hr.tvz.mede.studapp.Command.StudentCommand;
import hr.tvz.mede.studapp.Dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();

    Optional<Student> findByJMBAG(String jmbag);

    Optional<Student> save(Student student);

    void delete(String jmbag);

    Optional<Student> update(String jmbag, Student student);

}