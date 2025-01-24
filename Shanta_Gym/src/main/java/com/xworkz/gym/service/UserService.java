package com.xworkz.gym.service;

import com.xworkz.gym.Entity.RegisterEntity;

public interface UserService {

    RegisterEntity getName(String email, String password);

    RegisterEntity getEmail(String email, String password);

}
