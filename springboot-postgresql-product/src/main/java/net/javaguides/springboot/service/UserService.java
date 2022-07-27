package net.javaguides.springboot.service;


import net.javaguides.springboot.dao.entity.User;


import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    User save(User user);
    void delete(User id);
}
