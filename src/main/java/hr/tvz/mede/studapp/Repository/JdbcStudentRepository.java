package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
class StudentRepositoryImpl implements StudentRepository {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert studentInserter;

    public StudentRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.studentInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("student").usingGeneratedKeyColumns("id");
    }

    @Override
    public Optional<Student> update(String jmbag, Student student) {
        String updateQuery = "update student set first_name = ?, last_name= ?, jmbag = ?, number_of_ects= ? where jmbag = ?";
        jdbc.update(updateQuery, student.getFirstName(), student.getLastName(), student.getJmbag(), student.getNumberOfEcts(), jmbag);

        return Optional.ofNullable(student);
    }

    @Override
    public List<Student> findAll() {
        return jdbc.query("select first_name, last_name, birth_date, jmbag, number_of_ects from student",
                this::mapRowToStudent);
    }

    @Override
    public Optional<Student> findByJMBAG(String jmbag) {
        return Optional.ofNullable(jdbc.queryForObject("select id, first_name, last_name, birth_date, jmbag, number_of_ects from student where jmbag=?",
                this::mapRowToStudent, jmbag));
    }

    @Override
    public Optional<Student> save(Student student) {
        student.setId(saveStudentDetails(student));
        return Optional.of(student);
    }

    public Long saveStudentDetails(Student student) {
        student.setBirthDate(LocalDate.now().minusYears(27));

        Map<String, Object> values = new HashMap<>();
        values.put("first_name", student.getFirstName());
        values.put("last_name", student.getLastName());
        values.put("birth_date", student.getBirthDate());
        values.put("jmbag", student.getJmbag());
        values.put("number_of_ects", student.getNumberOfEcts());

        return studentInserter.executeAndReturnKey(values).longValue();
    }

    @Override
    public void delete(String jmbag) {
        jdbc.update("DELETE FROM student WHERE jmbag = ?", jmbag);
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setBirthDate(rs.getDate("birth_date").toLocalDate());
        student.setJmbag(rs.getString("jmbag"));
        student.setNumberOfEcts(rs.getInt("number_of_ects"));
        return student;
    }

}