package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;


import java.util.List;
import java.util.Set;

public interface GymService {

    boolean getNameByEmail(String email, String password);  //read opration
    boolean saveEnquiry(EnquiryDto enquiryDto);

    Long countName(String name);
//    Long countByEmail(String email);
//    Long countByPassword(String password);
    Long countArea(String area);
    Long countPhone(long phone);
    Long countDistance(int distance);
    Long countAge(int age);

    List<EnquiryEntity> getEnquiries();
    List<EnquiryEntity> getEnquiriesByStatus(String status);
    boolean updateStatusAndReason(String name,String status, String reason);

    boolean saveRegister(RegisterDto registerDto);

    boolean updateRegister(RegisterDto registerDto,String name,long phone);
    boolean sendEmail(String email, String password);



}
