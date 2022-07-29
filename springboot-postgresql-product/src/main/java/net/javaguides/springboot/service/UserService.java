package net.javaguides.springboot.service;


import net.javaguides.springboot.Exception.ResourceNotFoundException;
import net.javaguides.springboot.dao.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();



    ResponseEntity<User> findById(@PathVariable(value = "id") long userId)
            throws ResourceNotFoundException;

    User save(User user);


    Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException;
}
