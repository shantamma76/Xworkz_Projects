package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.EnquiryEntity;


import java.util.List;

public interface GymRepository {

    boolean getNameByEmail(String email, String password); //admin login

    boolean saveEnquiry(EnquiryEntity enquiryEntity); //for enquiry form

//    boolean saveFollow(FollowEntity followEntity);

//    List<EnquiryEntity> getEnquiriesByStatus(String status);
    //List<EnquiryEntity> getEnquiries();

//    List<EnquiryEntity> getAll(); //-------------

    List<EnquiryEntity> findAll();
    List<EnquiryEntity> findByStatus(String status);

    boolean updateStatusAndReason(String name, String status, String reason);

//    boolean savedData(EnquiryEntity enquiryEntity);
}
