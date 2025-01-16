 package com.xworkz.gym.Controller;

import com.xworkz.gym.DTO.EnquiryDto;
import com.xworkz.gym.DTO.FollowDto;
import com.xworkz.gym.DTO.GymDto;
import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.constants.StatusEnum;
import com.xworkz.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 @Controller

public class GymController {

    @Autowired
    GymService service;

    GymController() {
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

    @PostMapping("/enquiry")
    public String onEnquiry(EnquiryDto dto,Model model){
        System.out.println("onEnquiry in GymController");
        boolean isEnquiry = service.saveEnquiry(dto);
        if(isEnquiry) {
            model.addAttribute("msg","enquiry success");
            return "Success";
        } else {
            model.addAttribute("error","Enquiry failed");
            return "Enquiry";
        }
    }

//    @PostMapping("/update")
//    public String onUpdateForm(EnquiryDto dto){
//        System.out.println("onUpdateForm in GymController");
//        boolean updated = service.savedData(dto);
//
//        if (updated){
//            System.out.println("updated..........");
//            return "FollowUp";
//        }
//        System.out.println("not updated");
//        return "updateForm";
//    }
//
//    @PostMapping("/follow")
//    public String onFollow(FollowDto dto){
//        System.out.println("onFollow in GymController");
//
//       boolean isFollow  = service.saveFollow(dto);
//
//       if(isFollow){
//           System.out.println("follow is successfully");
//           return "Success";
//       }
//        return "follow";
//    }

//     @GetMapping("/FollowUp")
//     public String onFollow(Model model){
//        System.out.println("onFollow in GymController");
//       List<EnquiryDto> val = service.getAll();
//         System.out.println("=====================val"+val);
//       model.addAttribute("msg" ,val);
//         return "FollowUp";
//     }

     @PostMapping("updateFollowUp")
     public String onFolloUpupdate(@RequestParam String name,@RequestParam String status,@RequestParam String reason,Model model) {
         System.out.println(name);

         boolean saved = service.updateStatusAndReason(name, status, reason);
         if (saved) {
             List<EnquiryEntity> enquiryList = service.getEnquiries();
             if (enquiryList != null) {
                 enquiryList.forEach((n) -> System.out.println(n));
                 // session.setAttribute("enquiryList", enquiryList);
                 model.addAttribute("enquiryList", enquiryList);
                 model.addAttribute("statusOptions", Arrays.asList(StatusEnum.values()));

                 return "FollowUp";
             }

         }
         return "FollowUp";
     }

     @GetMapping("search")
     public String onFollow(@RequestParam(value = "status", required = false) String status, Model model) {
         List<EnquiryEntity> enquiryList;

         // Fetch filtered or all records
         System.out.println(status);
         if (status != null && !status.isEmpty()) {
             enquiryList = service.getEnquiriesByStatus(status); // Add method to filter by status
         } else {
             enquiryList = service.getEnquiries();
         }

         model.addAttribute("enquiryList", enquiryList);
         model.addAttribute("statusOptions", Arrays.asList(StatusEnum.values())); // Status options
         model.addAttribute("selectedStatus", status); // Preserve selected status in dropdown

         return "FollowUp";
     }

 }


