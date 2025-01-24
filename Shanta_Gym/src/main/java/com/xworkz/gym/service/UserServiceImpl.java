package com.xworkz.gym.service;

import com.xworkz.gym.Entity.RegisterEntity;
import com.xworkz.gym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterEntity getName(String email, String password) {
        return userRepository.getName(email, password);
    }

    @Override
    public RegisterEntity getEmail(String email, String password) {
        RegisterEntity entity = userRepository.getEmail(email);
        if (entity != null) {
            // Check if loginCount is null
            Integer loginCount = entity.getLoginCount();
            if (loginCount == null) {
                loginCount = 0; // Set default value if null
                entity.setLoginCount(loginCount);
            }

            if (password.equals(entity.getPassword())) {
                if (loginCount >= 3) {
                    if (entity.getAccountLockedTime() == null) {
                        userRepository.updateLockedAccountTimeByEmail(email);
                    }
                    return null; // Account is locked
                } else {
                    // Update count if login failed
                    userRepository.updateCount(email, loginCount);
                    return entity;
                }
            } else {
                if (loginCount < 3) {
                    userRepository.updateCount(email, loginCount);
                    return null; // Incorrect password
                }
            }
        }
        return null; // User not found or other issues
    }
}


