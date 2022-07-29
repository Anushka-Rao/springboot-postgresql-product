package net.javaguides.springboot.service;

import net.javaguides.springboot.dao.entity.User;
import net.javaguides.springboot.Exception.ResourceNotFoundException;

import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    private ResponseEntity<User> user;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> findById(@PathVariable(value = "id") long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ID :: " + userId));

        return ResponseEntity.ok().body(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ID :: " + userId));
        this.userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

    }


}
