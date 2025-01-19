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
            return "Success";
        } else {
            model.addAttribute("error", "Not Saved");
            return "Registration";
        }
    }

    @GetMapping("/update")
    public String updateDetails(@RequestParam String name, RegisterDto dto, Model model) {
        System.out.println("updateDetails in RegisterController");
        boolean result = service.updateDetails(name, dto);
        if (result) {
            model.addAttribute("msg", "Update successful!");
            return "Success"; // success view
        } else {
            model.addAttribute("error", "Update failed. User not found or no changes made.");
            return "Update"; // update form view
        }
    }
}
