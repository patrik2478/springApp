package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Domain.Student;
import hr.tvz.mede.studapp.Dto.StudentDTO;
import hr.tvz.mede.studapp.Command.StudentCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    List<StudentDTO> getAll();

    Optional<StudentDTO> getByJMBAG(String jmbag);

    Optional<StudentDTO> save(StudentCommand studentCommand);

    Optional<StudentDTO> update(String jmbag, StudentCommand command);

    void delete(String jmbag);
}