package hr.tvz.mede.studapp.Controller;

import hr.tvz.mede.studapp.Dto.CourseDTO;
import hr.tvz.mede.studapp.Dto.StudentDTO;
import hr.tvz.mede.studapp.Command.StudentCommand;
import hr.tvz.mede.studapp.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
}

    @GetMapping(value = "", produces = "application/json")
    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{jmbag}", produces = "application/json")
    public ResponseEntity<StudentDTO> getByJMBAG(@PathVariable String jmbag) {
        return studentService.getByJMBAG(jmbag).map(
                studentDTO -> ResponseEntity.status(HttpStatus.FOUND).body(studentDTO)
        ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        );
    }


    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(command) .map(
                studentDTO -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(studentDTO)
        )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @PutMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> update(@PathVariable String JMBAG, @Valid @RequestBody final StudentCommand updateStudentCommand){
        return studentService.update(JMBAG, updateStudentCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{jmbag}")
    public void delete(@PathVariable String jmbag) {
        studentService.delete(jmbag);
    }
}