package Services;

import models.User;
import repositories.UserRepository;

/**
 * Created by aleksei on 21.01.17.
 */
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    User getUserById(Integer id) {
        return userRepository.getOne(id)
    }

    User getUserByEmail(String email);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void deleteUser(User user);

    void deleteAllUsers(){
        userRepository.deleteAll();
    }

    boolean emailExists(String email){
        if (getUserByEmail(email) == null)
            return false;
        return true;
    }
}
