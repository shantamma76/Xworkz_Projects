package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.GymEntity;

public interface GymRepository {

    boolean saveData(GymEntity gymEntity);

    boolean saveEnquiry(EnquiryEntity enquiryEntity);

}
