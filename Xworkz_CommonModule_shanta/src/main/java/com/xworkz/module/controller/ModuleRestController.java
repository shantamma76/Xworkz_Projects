package com.xworkz.module.controller;

import com.xworkz.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ModuleRestController {

    ModuleRestController() {
        System.out.println("No-Arg const in ModuleRestController");
    }

    @Autowired
    private ModuleService service;

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name) {
        System.out.println("name is =" + name);
        Long count = this.service.countName(name);
        if (count == 0) {
            System.out.println("name does not exist");
            return "does not exist";
        } else {
            System.out.println("name is exists");
            return "exist";
        }
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email) {
        System.out.println("email=" + email);
        Long count = this.service.countByEmail(email);
        if (count == 0) {
            System.out.println("Email does not exist");
            return "email does not exist";
        } else {
            System.out.println("Email exists");
            return "email is exist";
        }
    }

    @GetMapping(value = "/alterEmail/{alterEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAltEmail(@PathVariable String alterEmail) {
        System.out.println("alterEmail is=" + alterEmail);
        Long count = this.service.countByAltEmail(alterEmail);
        if (count == 0) {
            System.out.println("AltEmail is does not exist");
            return "AltEmail does not exist";
        } else {
            System.out.println("AltEmail is already exists");
            return "AltEmail already exist";
        }
    }

    @GetMapping(value = "/phone/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhone(@PathVariable long phone) {
        System.out.println("phone=" + phone);
        Long count = this.service.countByPhone(phone);
        if (count == 0) {
            System.out.println("Phone is does not exist");
            return "phone doesnot exist";
        } else {
            System.out.println("Phone is already exists");
            return "phone already exist";
        }

    }

    @GetMapping(value = "/alterPhone/{alterPhone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAltPhone(@PathVariable long alterPhone) {
        System.out.println("alterPhone=" + alterPhone);
        Long count = this.service.countByAltPhone(alterPhone);
        if (count == 0) {
            System.out.println("AltPhone is does not exist");
            return "altPhone doesnot exist";
        } else {
            System.out.println("AltPhone is already exists");
            return "altPhone already exist";
        }
    }

    @GetMapping(value = "/location/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onLocation(@PathVariable String location) {
        System.out.println("location=" + location);
        Long count = this.service.countByLocation(location);
        if (count == 0) {
            System.out.println("location is does not exist");
            return "location doesnot exist";

        } else {
            System.out.println("location is already exists");
            return "location exist";
        }

        
    }
}