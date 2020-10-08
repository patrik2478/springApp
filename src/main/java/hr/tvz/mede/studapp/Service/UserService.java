package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Domain.User;
import hr.tvz.mede.studapp.Dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<UserDTO> findOneByUsername (String username);
}
