package com.services;

import com.models.User;
import com.validation.EmailExistsException;

/**
 * Created by aleksei on 21.01.17.
 */
public interface UserService {

    Iterable<User> getAllUsers();

    User getUserById(Integer id);

    User getUserByEmail(String email);

    void saveUser(User user) throws EmailExistsException;

    void deleteUserById(Integer id);

    void deleteUser(User user);

    void deleteAllUsers();

    boolean emailExists(String email);
}
