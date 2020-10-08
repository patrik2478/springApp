package hr.tvz.mede.studapp.Controller;

import hr.tvz.mede.studapp.Dto.CourseDTO;
import hr.tvz.mede.studapp.Dto.UserDTO;
import hr.tvz.mede.studapp.Security.SecurityUtils;
import hr.tvz.mede.studapp.Service.StudentService;
import hr.tvz.mede.studapp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current-user")
    public ResponseEntity <UserDTO> getCurrentUser(){
        return SecurityUtils.getCurrentUserUsername()
                .map(
                        username -> userService.findOneByUsername(username)
                        .map(ResponseEntity::ok)
                        .orElseGet(
                                () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                        )
                )
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                );
    }
}
