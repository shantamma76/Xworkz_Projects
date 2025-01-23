package com.xworkz.gym.service;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.RegisterEntity;
import com.xworkz.gym.constants.StatusEnum;
import com.xworkz.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.Random;


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
    public Long countEmail(String email) {
        return repository.countEmail(email);
    }

    @Override
    public Long countPassword(String password) {
        return repository.countPassword(password);
    }

    @Override
    public Long countName(String name) {
        return repository.countName(name);
    }

    @Override
    public Long countArea(String area) {
        return repository.countArea(area);
    }

    @Override
    public Long countPhone(long phone) {
        return repository.countPhone(phone);
    }

    @Override
    public Long countDistance(int distance) {
        return repository.countDistance(distance);
    }

    @Override
    public Long countAge(int age) {
        return repository.countAge(age);
    }

    @Override
    public Long countNameBy(String name) {
        return repository.countNameBy(name);
    }

    @Override
    public Long countByEmail(String email) {
        return repository.countByEmail(email);
    }

    @Override
    public Long countByTrainer(String trainer) {
        return repository.countByTrainer(trainer);
    }

    @Override
    public Long countByPhone(long phone) {
        return repository.countByPhone(phone);
    }

    @Override
    public Long countByGymName(String gymName) {
        return repository.countByGymName(gymName);
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
        //entity.setPassword(registerDto.getPassword());
        entity.setPackages(registerDto.getPackages());
        entity.setTrainer(registerDto.getTrainer());
        entity.setPhone(registerDto.getPhone());
        entity.setAmount(registerDto.getAmount());
        entity.setDiscount(registerDto.getDiscount());
        entity.setGymName(registerDto.getGymName());
        entity.setPaid(registerDto.getPaid());
        entity.setBalance(registerDto.getBalance());
        entity.setInstallment(registerDto.getInstallment());

        String randamPassword = generateRandomPassword();
        entity.setPassword(randamPassword);

        boolean isResponse = repository.saveRegister(entity);
        if (isResponse) {
            sendEmail(registerDto.getEmail(), randamPassword);
        }
        return isResponse;

//        boolean saves = repository.saveRegister(entity);
//        if(saves){
//            System.out.println("register data is saved");
//            return true;
//        }
//        System.out.println("register data is not saved");
//        return false;
    }

    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }

    //sending email to customer for password
    @Override
    public boolean sendEmail(String email, String password) {
        System.out.println("this email in serviceImpl ");
        final String username = "siraganshantamma@gmail.com";
        final String userPassword = "hhae fwza swyx wlyb";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, userPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Your password");
            message.setText("your password: " + password);

            Transport.send(message);

            System.out.println("Email sending is Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRegister(RegisterDto registerDto, String name, long phone) {
        System.out.println("updateRegister in serviceImpl");

        RegisterEntity entity = repository.updateRegister(name, phone);
        if (entity != null) {
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
