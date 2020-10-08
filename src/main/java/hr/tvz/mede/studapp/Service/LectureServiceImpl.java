package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Domain.Course;
import hr.tvz.mede.studapp.Domain.Lecture;
import hr.tvz.mede.studapp.Dto.CourseDTO;
import hr.tvz.mede.studapp.Dto.LectureDTO;
import hr.tvz.mede.studapp.Repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public List<LectureDTO> findAll() {
        return lectureRepository.findAll().stream().map(this::mapLectureToDTO).collect(Collectors.toList());
    }

    private LectureDTO mapLectureToDTO(final Lecture lecture){
        return new LectureDTO(lecture.getIme(), lecture.getPrezime());
    }

}
