package com.xworkz.gym.repository;
import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.RegisterEntity;

import java.util.List;

public interface GymRepository {

    boolean getNameByEmail(String email, String password); //admin login
    boolean saveEnquiry(EnquiryEntity enquiryEntity);//for enquiry form

    Long countName(String name);   //for ajax validation
    //Long countByEmail(String email);
    //Long countByPassword(String password);
    Long countArea(String area);
    Long countPhone(long phone);
    Long countDistance(int distance);
    Long countAge(int age);

    List<EnquiryEntity> findAll();
    List<EnquiryEntity> findByStatus(String status);
    boolean updateStatusAndReason(String name, String status, String reason);

    boolean saveRegister(RegisterEntity registerEntity);

//    boolean updateDetails(String name,RegisterDto registerDto);

    public RegisterEntity updateRegister(String name, long phone);


}
