package com.xworkz.gym.repository;
import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.RegisterEntity;

import java.util.List;

public interface GymRepository {

    boolean getNameByEmail(String email, String password); //admin login
    boolean saveEnquiry(EnquiryEntity enquiryEntity);//for enquiry form

    Long countEmail(String email);
    Long countPassword(String password);

    Long countName(String name);   //for Enquiry ajax validation
    Long countArea(String area);
    Long countPhone(long phone);
    Long countDistance(int distance);
    Long countAge(int age);

    Long countNameBy(String name); //for register ajax validation
    Long countByEmail(String email);
    Long countByTrainer(String trainer);
    Long countByPhone(long phone);
    Long countByGymName(String gymName);
//    Long countByPaid(int paid);
//    Long countInstallmentDemo(double installment);



    List<EnquiryEntity> findAll();
    List<EnquiryEntity> findByStatus(String status);
    boolean updateStatusAndReason(String name, String status, String reason);

    boolean saveRegister(RegisterEntity registerEntity);

//    boolean updateDetails(String name,RegisterDto registerDto);

    public RegisterEntity updateRegister(String name, long phone);


}
