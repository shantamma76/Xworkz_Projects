package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.RegisterEntity;
import com.xworkz.gym.Entity.ViewEntity;

import java.util.List;

public interface GymRepository {

    boolean getNameByEmail(String email, String password); //admin login
    boolean saveEnquiry(EnquiryEntity enquiryEntity);//for enquiry form

    //For admin ajax validation
    Long countEmail(String email);
    Long countPassword(String password);

    //For enquiry ajax validation
    Long countName(String name);   //for Enquiry ajax validation
    Long countArea(String area);
    Long countPhone(long phone);
    Long countDistance(int distance);
    Long countAge(int age);

    // For Register ajax validation
    Long countNameBy(String name); //for register ajax validation
    Long countByEmail(String email);
    Long countByTrainer(String trainer);
    Long countByPhone(long phone);
    Long countByGymName(String gymName);

    //followUp
    List<EnquiryEntity> findAll();
    List<EnquiryEntity> findByStatus(String status);
    boolean updateStatusAndReason(String name, String status, String reasons);

    //Registration
    boolean saveRegister(RegisterEntity registerEntity);
    public RegisterEntity updateRegister(String name, long phone);

    //viewpage
    EnquiryEntity getEnquiryEntityByName(String name);
    boolean saveView(ViewEntity viewEntity);
    List<ViewEntity> getAllData(int id); //viewDetails

//-------------------------user login-----------------------------------
    RegisterEntity userSave(String email);
    void updateCount(String email, int count);
    boolean resetCount(String email, int count);
    String updatePasswordByEmail(String email, String newPassword);
    String updateLockedAccountTimeByEmail(String email);

}

