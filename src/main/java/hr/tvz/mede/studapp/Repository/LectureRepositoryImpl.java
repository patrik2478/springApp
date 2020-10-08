package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.Lecture;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class LectureRepositoryImpl implements LectureRepository {

    private List<Lecture> MOCKED_LECTURE = new ArrayList<>(Arrays.asList(
             new Lecture((long) 1,"Patrik", "Mede", "0951908585"),
            new Lecture((long) 2,"Ivanko", "Maric", "0951908585")
    ));

    @Override
    public List<Lecture> findAll() {
        return MOCKED_LECTURE;
    }

}