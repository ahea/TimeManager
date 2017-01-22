package repositories;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aleksei on 21.01.17.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByEmail(String email);
}
