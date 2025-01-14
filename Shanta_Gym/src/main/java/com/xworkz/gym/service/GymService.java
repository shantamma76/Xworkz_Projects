package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.FollowDto;
import com.xworkz.gym.DTO.GymDto;
import com.xworkz.gym.Entity.FollowEntity;

public interface GymService {

    boolean savedData(GymDto gymDto);

    boolean saveEnquiry(EnquiryDto enquiryDto);

//    boolean saveFollow(FollowDto followDto);

}
