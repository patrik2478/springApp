package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Domain.Student;
import hr.tvz.mede.studapp.Dto.StudentDTO;
import hr.tvz.mede.studapp.Repository.StudentRepository;
import hr.tvz.mede.studapp.Command.StudentCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> getByJMBAG(String jmbag) {
        return Optional.ofNullable(studentRepository.findByJMBAG(jmbag).map(this::mapStudentToDTO).orElse(null));
    }

    @Override
    public Optional<StudentDTO> save(StudentCommand command) {
        return studentRepository.save(mapStudentCommandToStudent(command)).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> update(String jmbag, StudentCommand command) {
        return studentRepository.update(jmbag, mapStudentCommandToStudent(command)).map(this::mapStudentToDTO);
    }

    @Override
    @Secured({"ROLE_ADMIN","DELETER"})
    public void delete(String jmbag) {
        studentRepository.delete(jmbag);
    }

    private StudentDTO mapStudentToDTO(final Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getJmbag(), student.getNumberOfEcts(), shouldTuitionBePayed(student.getBirthDate()));
    }

    private Boolean shouldTuitionBePayed(final LocalDate dateOfBirth) {
        return dateOfBirth.isBefore(LocalDate.now().minusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED));
    }

    private Student mapStudentCommandToStudent(final StudentCommand studentCommand) {
        Student student = new Student();
        BeanUtils.copyProperties(studentCommand, student);
        return student;
    }
}