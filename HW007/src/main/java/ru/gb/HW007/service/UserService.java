package ru.gb.HW007.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getAdminText() {
        return "Admin message";
    }
    public String getUserText() {
        return "User message";
    }
    public String getAllText() {
        return "All message";
    }

}
