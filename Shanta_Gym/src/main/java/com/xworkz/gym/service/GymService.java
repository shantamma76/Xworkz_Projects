package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.FollowDto;
import com.xworkz.gym.DTO.GymDto;
import com.xworkz.gym.Entity.EnquiryEntity;


import java.util.List;

public interface GymService {

//
    boolean getNameByEmail(String email, String password);  //read opration

    boolean saveEnquiry(EnquiryDto enquiryDto);

    //boolean saveFollow(FollowDto followDto);



    List<EnquiryEntity> getEnquiries();
    List<EnquiryEntity> getEnquiriesByStatus(String status);
    boolean updateStatusAndReason(String name,String status, String reason);

//    List<EnquiryDto> getAll();



//    boolean savedData(EnquiryDto enquiryDto); //updateForm pra
}
