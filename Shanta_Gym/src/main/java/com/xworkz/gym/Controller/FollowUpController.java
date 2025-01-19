package com.xworkz.gym.Controller;

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
public class FollowUpController {

    @Autowired
    GymService service;

    FollowUpController() {
        System.out.println("No-arg Const in FollowUpController");
    }

    @PostMapping("updateFollowUp")
    public String onFolloUpupdate(@RequestParam String name, @RequestParam String status, @RequestParam String reason, Model model) {
        System.out.println(name);

        boolean saved = service.updateStatusAndReason(name, status, reason);
        if (saved) {
            List<EnquiryEntity> enquiryList = service.getEnquiries();
            if (enquiryList != null) {
                enquiryList.forEach((n) -> System.out.println(n));
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
