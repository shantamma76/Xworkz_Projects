package com.xworkz.gym.Controller;

import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    GymService service;

    @PostMapping("/register")
    public String onRegister(RegisterDto dto, Model model) {
        System.out.println("onRegister in RegisterController");
        boolean saveData = service.saveRegister(dto);
        if (saveData) {
            model.addAttribute("msg", "saved");
            model.addAttribute("name",dto.getName());
            return "Success";
        } else {
            model.addAttribute("error", "Not Saved");
            return "Registration";
        }
    }

//    @PostMapping("/update")
//    public String updateDetails(@RequestParam String name, RegisterDto dto, Model model) {
//        System.out.println("updateDetails in controller " +dto);
//        boolean result = service.updateDetails(name,dto);
//        if (result) {
//            model.addAttribute("msg", "Update successful!");
//            return "Success";
//        } else {
//            model.addAttribute("error", "Update failed. User not found or no changes made.");
//            return "Update";
//        }
//    }

//        @GetMapping("/updates")
//        public String onUpdate(@RequestParam(required = false) String name, Model model) {
//            model.addAttribute("name", name);
//            return "Update";
//        }

    @PostMapping("/update")
    public String updateRegisteration(RegisterDto registerDto,String name,long phone){
        System.out.println("updateRegisteration in RegisterController");
        boolean updated = service.updateRegister(registerDto,name,phone);
        if(updated){
            System.out.println("it is updated");
            return "Success";
        }
        System.out.println("it is not updated");
        return "Update";
    }



    }







