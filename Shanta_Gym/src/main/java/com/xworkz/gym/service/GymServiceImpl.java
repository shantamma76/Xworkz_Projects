package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.GymDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.constants.StatusEnum;
import com.xworkz.gym.repository.GymRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    GymRepository repository;

    @Override
    public boolean getNameByEmail(String email, String password) {
        System.out.println("getNameByEmailAndPassword in GymServiceImpl");
        boolean getName = repository.getNameByEmail(email, password);
        return getName;
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
        entity.setStatus(String.valueOf(StatusEnum.Enquired));

        boolean enquiry = repository.saveEnquiry(entity);
        if (enquiry) {
            System.out.println("Enquiry Data is saved");
            return true;
        }
        System.out.println("Enquiry data is not saved");
        return false;
    }

    @Override
    public List<EnquiryEntity> getEnquiries() {
        return repository.findAll();
    }

    @Override
    public List<EnquiryEntity> getEnquiriesByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public boolean updateStatusAndReason(String name, String status, String reason) {
        System.out.println("updateStatusAndReason in GymServiceImpl");
        boolean saved = repository.updateStatusAndReason(name, status, reason);
        if (saved)
            return true;

        return false;
    }

//    @Override
//    public List<EnquiryEntity> getEnquiriesByStatus(String status) {
//        return repository.getEnquiriesByStatus(status);  // Call the repository method to fetch based on status.
//

//    @Override
//    public List<EnquiryDto> getAll() {
//        System.out.println("getAll in GymServiceImpl");
//        List<EnquiryEntity> allValues= repository.getAll();
//        System.out.println("//////////////from repo the values arer/.."+allValues);
//        ArrayList<EnquiryDto> value = new ArrayList<>();
//        allValues.forEach(y->{
//            EnquiryDto dto = new EnquiryDto();
//            BeanUtils.copyProperties(y,dto);
//            value.add(dto);
//        });
//        System.out.println("   in service method..     "+value);
//        return value;
//    }

//    @Override
//    public boolean savedData(EnquiryDto enquiryDto) {
//        System.out.println("savedData in GymServiceImpl");
//
//        EnquiryEntity entity = new EnquiryEntity();
//
//        entity.setName(enquiryDto.getName());
//        entity.setArea(enquiryDto.getArea());
//        entity.setPhone(enquiryDto.getPhone());
//        entity.setDistance(enquiryDto.getDistance());
//        entity.setAge(enquiryDto.getAge());
//        entity.setStatus(String.valueOf(StatusEnum.Enquired));
//
//        boolean enquiry = repository.savedData(entity);
//        if(enquiry){
//            System.out.println("data Data is updated");
//            return true;
//        }
//        System.out.println("Data not is updated");
//        return false;
//    }




}
