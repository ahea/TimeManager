package Services;

import models.User;

/**
 * Created by aleksei on 21.01.17.
 */
public interface UserService {

    Iterable<User> getAllUsers();

    User getUserById(Integer id);

    User getUserByEmail(String email);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void deleteUser(User user);

    void deleteAllUsers();

    boolean emailExists(String email);
}
