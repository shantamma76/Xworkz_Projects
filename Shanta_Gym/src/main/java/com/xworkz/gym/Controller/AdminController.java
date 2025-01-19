 package com.xworkz.gym.Controller;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.constants.StatusEnum;
import com.xworkz.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    GymService service;

    AdminController() {
        System.out.println("No-arg Const in GymController");
    }

    @GetMapping("/signIn")
    public String onSignIn(String email,String password, Model model){
        System.out.println("Running  onSignIn in GymController");
        boolean read = service.getNameByEmail(email,password);
        if (read){
            model.addAttribute("msg","login successfully");
            return "Success";
        }
        model.addAttribute("error", "Login failure");
        return "Admin";
    }


 }




