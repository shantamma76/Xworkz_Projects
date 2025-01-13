package com.xworkz.gym.Controller;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.GymDto;
import com.xworkz.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GymController {

    @Autowired
    GymService service;

    GymController(){
        System.out.println("No-arg Const in GymController");
    }

    @PostMapping("/signIn")
    public String onSave(GymDto dto, Model model){
        System.out.println("Running onSaved method in GymController");
        boolean isSaved = service.savedData(dto);
        if(isSaved){
            model.addAttribute("msg","admin login is Succussfully done");
            return "Enquiry";
        } else {
            model.addAttribute("error", "login is failure");
            return "Admin";
        }
    }

    @PostMapping("/enquiry")
    public String onEnquiry(EnquiryDto dto,Model model){
        System.out.println("onEnquiry in GymController");
        boolean isEnquiry = service.saveEnquiry(dto);
        if(isEnquiry) {
            model.addAttribute("msg","enquiry success");
            return "follow";
        } else {
            model.addAttribute("error","Enquiry failed");
            return "Enquiry";
        }
    }

}
