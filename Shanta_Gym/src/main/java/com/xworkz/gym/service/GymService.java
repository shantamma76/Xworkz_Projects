package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;


import java.util.List;
import java.util.Set;

public interface GymService {

    boolean getNameByEmail(String email, String password);  //read opration
    boolean saveEnquiry(EnquiryDto enquiryDto);

    Long countEmail(String email); //admin ajax validation
    Long countPassword(String password);

    Long countName(String name);
    Long countArea(String area);
    Long countPhone(long phone);
    Long countDistance(int distance);
    Long countAge(int age);

    Long countNameBy(String name); //for register ajax validation
    Long countByEmail(String email);
    Long countByTrainer(String trainer);
    Long countByPhone(long phone);
    Long countByGymName(String gymName);


    List<EnquiryEntity> getEnquiries();
    List<EnquiryEntity> getEnquiriesByStatus(String status);
    boolean updateStatusAndReason(String name,String status, String reason);

    boolean saveRegister(RegisterDto registerDto);

    boolean updateRegister(RegisterDto registerDto,String name,long phone);

    boolean sendEmail(String email, String password);



}
