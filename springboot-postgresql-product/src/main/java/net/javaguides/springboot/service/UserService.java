package net.javaguides.springboot.service;

import net.javaguides.springboot.Exception.ResourceNotFoundException;
import net.javaguides.springboot.dao.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAllUsers();

    User getUserById(long userId) throws ResourceNotFoundException;

    User updateUser(User user, long userId) throws ResourceNotFoundException;

    void deleteUserById(long userId) throws ResourceNotFoundException;
}
