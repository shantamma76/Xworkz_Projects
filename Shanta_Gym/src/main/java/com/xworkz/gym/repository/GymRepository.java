package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.GymEntity;
import com.xworkz.gym.Entity.FollowEntity;

public interface GymRepository {

    boolean saveData(GymEntity gymEntity);

    boolean saveEnquiry(EnquiryEntity enquiryEntity);

//    boolean saveFollow(FollowEntity followEntity);

}
