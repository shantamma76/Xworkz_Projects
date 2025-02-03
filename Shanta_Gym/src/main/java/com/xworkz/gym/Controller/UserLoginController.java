package com.xworkz.gym.Controller;

import com.xworkz.gym.Entity.RegisterEntity;
import com.xworkz.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserLoginController {

    @Autowired
    private GymService service;

    @PostMapping("/signIn")
    public String onUserLogin(@RequestParam String email, @RequestParam String password, Model model) {
        log.info("======onUserLogin in UserController=============:");
        RegisterEntity entity = service.getEmail(email, password);
        System.out.println("to know the which value returning from service..."+entity);
        int loginCount;
        if (entity != null) {
             loginCount = entity.getLoginCount();
            log.info("Login Count:" + loginCount);
            if (loginCount == -1) {
                System.out.println("Redirecting to UpdatePassword page.");
                String userName = entity.getName();
                model.addAttribute("userName", userName);
                System.out.println(userName);
                model.addAttribute("msg", "UserSuccess");
                return "resetPassword";
            } else {
                System.out.println("Redirecting to Success page.");
                String userName = entity.getName();
                model.addAttribute("userName", userName);
                // model.addAttribute("filePath", entity.getFilePath());
                return "Success";
            }
        }else {
            System.out.println("User entity is null. Redirecting to SignIn.");
            model.addAttribute("msg", "User not Success");
            return "UserLogin";
        }
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam String oldPassword,
                                @RequestParam String newPassword, @RequestParam String confirmPassword) {
        log.info("Email is: {}", email);
        log.info("Old password: {}", oldPassword);
        log.info("New password: {}", newPassword);
        log.info("Confirm password: {}", confirmPassword);
        System.out.println("===================reset password========================");
        String msg = service.resetPassword(email, oldPassword, newPassword, confirmPassword);
        if ("password updated successfully".equals(msg)) {
            return "Success";
        } else {
            return "resetPassword";
        }
    }
}



