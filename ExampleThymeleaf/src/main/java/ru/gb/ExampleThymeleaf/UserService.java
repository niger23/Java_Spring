package ru.gb.ExampleThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        userRepository.save(new User(null, "John", "12@12"));
        userRepository.save(new User(null, "John2", "122@12"));
        userRepository.save(new User(null, "John3", "142@12"));
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
