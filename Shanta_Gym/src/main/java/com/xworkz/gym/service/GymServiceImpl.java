package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.RegisterEntity;
import com.xworkz.gym.constants.StatusEnum;
import com.xworkz.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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

    @Override
    public boolean saveRegister(RegisterDto registerDto) {
        System.out.println("saveRegister in GymServiceImpl");

        RegisterEntity entity = new RegisterEntity();
        entity.setName(registerDto.getName());
        entity.setEmail(registerDto.getEmail());
        entity.setPassword(registerDto.getPassword());
        entity.setPackages(registerDto.getPackages());
        entity.setTrainer(registerDto.getTrainer());
        entity.setPhone(registerDto.getPhone());
        entity.setAmount(registerDto.getAmount());
        entity.setDiscount(registerDto.getDiscount());
        entity.setGymName(registerDto.getGymName());
        entity.setPaid(registerDto.getPaid());
        entity.setBalance(registerDto.getBalance());
        entity.setInstallment(registerDto.getInstallment());

        boolean saves = repository.saveRegister(entity);
        if(saves){
            System.out.println("register data is saved");
            return true;
        }
        System.out.println("register data is not saved");
        return false;
    }

    @Override
    public boolean updateRegister(RegisterDto registerDto, String name, long phone) {
        System.out.println("updateRegister in serviceImpl");

        RegisterEntity entity = repository.updateRegister(name,phone);
        if(entity != null) {
            entity.setPackages(registerDto.getPackages());
            entity.setTrainer(registerDto.getTrainer());
            entity.setAmount(registerDto.getAmount());
            entity.setBalance(registerDto.getBalance());

            repository.saveRegister(entity);
            return true;
        }
        return false;
    }

//    @Override
//    public boolean updateDetails(String name, RegisterDto registerDto) {
//        System.out.println("In Service layer - UpdateDetails: " + registerDto);
////        registerDto.setName(name);
//        return repository.updateDetails(name,registerDto);
//    }

}
