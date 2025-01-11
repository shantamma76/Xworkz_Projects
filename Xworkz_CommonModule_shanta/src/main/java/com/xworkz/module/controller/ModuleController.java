package com.xworkz.module.controller;

import com.xworkz.module.constant.LocationEnum;
import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService service;

    private List<LocationEnum> listoflocation = new ArrayList<>(Arrays.asList(LocationEnum.values()));

    ModuleController() {
        System.out.println("Running no-arg constructor in ModuleController");
    }

    @GetMapping("/sup")
    public String onSignup(Model model) {
        listoflocation.forEach(n -> System.out.println(n));
        model.addAttribute("listoflocation", listoflocation);
        return "SignUp";
    }

    @GetMapping("/update")
    public String onUpdate(@RequestParam(required = false) String name, Model model) {
        listoflocation.forEach(n -> System.out.println(n));
        model.addAttribute("listoflocation", listoflocation);
        model.addAttribute("userName", name);
        return "UpdateProfile";
    }

    @PostMapping("/signup")
    public String onPrinted(ModuleDTO dto, Model model) {
        System.out.println("Running onPrinted in controller");
        System.out.println(dto);

        Set<ConstraintViolation<ModuleDTO>> constraintViolations = service.onCommon(dto);
        if (constraintViolations.isEmpty()) {
            model.addAttribute("msg", "SignUp Success");
            return "Success";
        } else {
            model.addAttribute("error", constraintViolations);
            return "SignUp";
        }
    }

    @PostMapping("/signIn")
    public String onDisplay(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println(email + " " + password);
        ModuleEntity entity = service.getEmail(email, password);

        if (entity != null) {
            int loginCount = entity.getResetStatus();
            String userName = entity.getName();

            if (loginCount == -1) {
                model.addAttribute("userName", userName);
                return "resetPassword";
            } else {
                model.addAttribute("userName", userName);
                model.addAttribute("filePath", entity.getFilePath());
                return "Success";
            }
        }
        return "SignIn";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam String oldPassword,
                                @RequestParam String newPassword, @RequestParam String confirmPassword) {
        log.info("Email is: " + email);
        log.info("Old password: " + oldPassword);
        log.info("New password: " + newPassword);
        log.info("Confirm password: " + confirmPassword);

        String msg = service.resetPassword(email, oldPassword, newPassword, confirmPassword);

        if ("password updated successfully".equals(msg)) {
            return "Success";
        } else {
            return "SignIn";
        }
    }

    @PostMapping("/update")
    public String newUpdated(@RequestParam String name, ModuleDTO dto, @RequestParam("picture") MultipartFile multipartFile, Model model)throws  Exception {
        //System.out.println(name);
        if(multipartFile.isEmpty()) {
            Set<ConstraintViolation<ModuleDTO>> set = service.updateDetails(name, dto,null);
            set.forEach((n) -> System.out.println(n));
            if (set.isEmpty()) {
                model.addAttribute("userName", name);
                return "Success";
            }
        }
        else{
            System.out.println("multipartFile="+multipartFile);
            System.out.println("multipartFile OriginalFileName=="+multipartFile.getOriginalFilename());
            System.out.println("multipartFile=="+multipartFile.getContentType());

            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get("C:\\fileUpload\\" + name + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            String filePath = path.getFileName().toString();
            System.err.println("filePath=====" + filePath);

            Set<ConstraintViolation<ModuleDTO>> set = service.updateDetails(name, dto,filePath);
            if(set.isEmpty()){
                return "Success";
            }
        }
        return "UpdateProfile";
    }

    @GetMapping("/download")
    public void display(HttpServletResponse response, @RequestParam String filePath) throws  Exception {
        System.out.println("this is image:" +filePath);
        response.setContentType("Image/jpg");
        File file = new File("C:\\fileUpload\\" +filePath);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        response.flushBuffer();
    }

    @PostMapping("/forget")
    public String forgetPassowrd(@RequestParam String email, @RequestParam String newPassword, @RequestParam String confirmPassword){
        System.out.println("recieve request for reseting password:");
        System.out.println("Email in ForgetPassword:"+email);
        System.out.println("NewPassword in formgetPassword method:"+newPassword);
        System.out.println("Confirm Password:"+confirmPassword);

        String response = service.resetPasswordByEmail(email,newPassword,confirmPassword);

        if("password updated successfully".equals(response)) {
            return "resetPassword";

        }else {
            return "forgetPassword";
        }


    }
}



