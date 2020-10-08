package hr.tvz.mede.studapp.Repository;

import hr.tvz.mede.studapp.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findOneByUsername(String username);
}
