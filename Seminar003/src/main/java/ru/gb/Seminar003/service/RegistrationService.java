package ru.gb.Seminar003.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.Seminar003.domain.User;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name,age,email);
        dataProcessingService.addUserToList(newUser);
        notificationService.notifyUser(newUser);
    }
}
