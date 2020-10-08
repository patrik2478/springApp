package hr.tvz.mede.studapp.Service;

import hr.tvz.mede.studapp.Domain.Authority;
import hr.tvz.mede.studapp.Domain.Student;
import hr.tvz.mede.studapp.Domain.User;
import hr.tvz.mede.studapp.Dto.StudentDTO;
import hr.tvz.mede.studapp.Dto.UserDTO;
import hr.tvz.mede.studapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> findOneByUsername(String username) {
        return Optional.ofNullable(userRepository.findOneByUsername(username).map(this::mapUserToDTO).orElse(null));
    }

    public UserDTO mapUserToDTO(final User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName((user.getFirstName()));
        userDTO.setLastName(user.getLastName());
        userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));

        return userDTO;
    }
}
