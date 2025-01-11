package com.xworkz.module.service;
import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ModuleServiceImpl implements ModuleService {
    // private static final int MAX_ATTEMPTS = 3;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModuleRepository repository;

    @Override
    public Long countName(String name) {
        return repository.countName(name);
    }

    @Override
    public Long countByEmail(String email) {
        return repository.countByEmail(email);
    }

    @Override
    public Long countByAltEmail(String alterEmail) {
        return repository.countByAltEmail(alterEmail);
    }

    @Override
    public Long countByPhone(long phone) {
        return repository.countByPhone(phone);
    }

    @Override
    public Long countByAltPhone(long alterPhone) {
        return repository.countByAltPhone(alterPhone);
    }

    @Override
    public Long countByLocation(String location) {
        return repository.countByLocation(location);
    }

    @Override
    public Set<ConstraintViolation<ModuleDTO>> onCommon(ModuleDTO dto) {
        System.out.println("Running onCommon in ModuleServiceImpl");

//        if (dto.getName() == null || dto.getPhone() == 0 || dto.getAlterPhone() == 0 || dto.getLocation() == null) {
//            return false;
//        }
//        String password = generateRandomPassword();
//        String encodedPassword = passwordEncoder.encode(password);

        String password = null;
        ModuleEntity entity = new ModuleEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAlterEmail(dto.getAlterEmail());
        entity.setPhone(dto.getPhone());
        entity.setAlterPhone(dto.getAlterPhone());
        entity.setLocation(dto.getLocation());

        entity.setCreatedBy(dto.getName());
        entity.setUpdatedBy(dto.getName());
        entity.getCreatedDate();
        entity.getUpdatedDate();


        int count = -1;
        if (entity.getEmail() != null) {
            password = generateRandomPassword();
            entity.setPassword(password);
            entity.setResetStatus(count);
        }

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<ModuleDTO>> set = validator.validate(dto);
        if (set.isEmpty()) {
            boolean saved = repository.onModule(entity);
            if (saved) {
                saveEmail(dto.getEmail(), password);
            }
        }
        return set;
    }

    @Override
    public ModuleEntity getName(String email, String password) {
        return repository.getName(email, password);
    }

    @Override
    public List<ModuleEntity> getAll(String email, String password) {
        List<ModuleEntity> list = repository.getAll(email, password);
        if (list != null) {
            return list;
        }
        return null;
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

    @Override
    public String resetPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
        String msg = null;
        ModuleEntity entity = repository.getByEmailPassword(email, oldPassword);
        if (entity != null) {
            if (newPassword.equals(confirmPassword)) {
                msg = repository.updatePasswordByEmail(newPassword, email);
                return msg;
            }
        }
        return null;
    }

    @Override
    public ModuleEntity getEmail(String email, String password) {
        ModuleEntity entity = repository.getEmail(email);
        if (entity != null) {
            System.out.println(entity.toString());
            if (password.equals(entity.getPassword()) && entity.getResetStatus() == -1) {
                System.out.println("matches");
                return entity;
            } else if (!(password.equals(entity.getPassword())) && (entity.getResetStatus() >= 0 && entity.getResetStatus() < 3)) {
                repository.updateCount(email, entity.getResetStatus());
                System.out.println("password entered is wrong");
                return null;
            } else if (!(password.equals(entity.getPassword())) && entity.getResetStatus() == 3) {
                System.out.println("locked");
                return null;
            } else if (password.equals(entity.getPassword()) && (entity.getResetStatus() < 3 && entity.getResetStatus() > -1)) {
                boolean reset = repository.resetCount(email, entity.getResetStatus());
                if (reset)
                    return entity;
                else
                    return null;
            }
        }
        return null;
    }

    //=========================email sending============================

    @Override
    public boolean saveEmail(String email, String password) {
        System.out.println("this email ");
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
    public Set<ConstraintViolation<ModuleDTO>> updateDetails(String userName, ModuleDTO moduleDTO,String filePath) {
        if (moduleDTO != null) {
            moduleDTO.setName(userName);
            System.out.println("service:"+moduleDTO.toString());
            ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
            Validator validator = vf.getValidator();
            Set<ConstraintViolation<ModuleDTO>> set = validator.validate(moduleDTO);

            if (set.isEmpty()) {
                System.out.println("------------------");
                boolean updated = repository.updateDetails(userName, moduleDTO,filePath);
            }
            return set;
        }
        return null;
    }

    @Override
    public String resetPasswordByEmail(String email, String newPassword, String confirmPassword) {
        System.out.println("reset password in service");
        if(newPassword.equals(confirmPassword)){

        }
        return "";
    }

}


//    @Override
//    public boolean updateprofile(ModuleDTO moduleDTO) {
//        ModuleEntity entity = repository.findByName(moduleDTO.getName());
//
//        if (entity != null) {
//            entity.setName(moduleDTO.getName());
//            entity.setEmail(moduleDTO.getEmail());
//            entity.setPhone(moduleDTO.getPhone());
//            entity.setAlterEmail(moduleDTO.getAlterEmail());
//            entity.setAlterPhone(moduleDTO.getAlterPhone());
//            entity.setLocation(moduleDTO.getLocation());
//            entity.setUpdatedBy(moduleDTO.getName());
//            entity.setUpdatedDate(LocalDateTime.now());
//            return repository.onModule(entity);
//        }
//
//        return false;
//    }









