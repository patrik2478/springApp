package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Command.StudentCommand;
import hr.tvz.mede.studapp.Dto.LectureDTO;
import hr.tvz.mede.studapp.Dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface LectureService {
    List<LectureDTO> findAll();
}