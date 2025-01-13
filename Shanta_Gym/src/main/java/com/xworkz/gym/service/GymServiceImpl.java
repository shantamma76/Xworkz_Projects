package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.GymDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.GymEntity;
import com.xworkz.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymServiceImpl implements GymService{

    @Autowired
    GymRepository repository;

    @Override
    public boolean savedData(GymDto gymDto) {
        System.out.println("Running savedData in GymServiceImpl");

        GymEntity entity = new GymEntity();
        entity.setName(gymDto.getName());
        entity.setEmail(gymDto.getEmail());
        entity.setPassword(gymDto.getPassword());

        boolean saved = repository.saveData(entity);
        if(saved){
            System.out.println("Data is Saved to Database");
            return true;
        }
        System.out.println("Data is not saved");
        return false;
    }

    @Override
    public boolean saveEnquiry(EnquiryDto enquiryDto) {
        System.out.println("saveEnquiry in GymServiceImpl");

        EnquiryEntity entity = new EnquiryEntity();
        entity.setName(enquiryDto.getName());
        entity.setArea(enquiryDto.getArea());
        entity.setPhone(enquiryDto.getPhone());
        entity.setDistance(enquiryDto.getDistance());
        entity.setAge(enquiryDto.getAge());

        boolean enquiry = repository.saveEnquiry(entity);
        if(enquiry){
            System.out.println("Enquiry Data is saved");
            return true;
        }
        System.out.println("Enquiry data is not saved");
        return false;
    }


}
