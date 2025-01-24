package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.RegisterEntity;

import java.util.List;

public interface UserRepository {

    RegisterEntity getName(String email,String password);

    //List<RegisterEntity> getAll(String email, String password);

    RegisterEntity getEmail(String email);

    void updateCount(String email, int count);

    boolean loginCount(String email, int count);

    String updateLockedAccountTimeByEmail(String email);


}
