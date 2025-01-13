package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.GymDto;

public interface GymService {

    boolean savedData(GymDto gymDto);

    boolean saveEnquiry(EnquiryDto enquiryDto);
}
