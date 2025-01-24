package com.xworkz.gym.Controller;

import com.xworkz.gym.Entity.RegisterEntity;
import com.xworkz.gym.service.GymService;
import com.xworkz.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signIn")
    public String userLogin(@RequestParam String email, @RequestParam String password, Model model){
        System.out.println(email + " " + password);
        RegisterEntity entity = userService.getEmail(email, password);

        if (entity != null) {
            int loginCount = entity.getLoginCount();
            String userName = entity.getName();

            if (loginCount == -1) {
                model.addAttribute("userName", userName);
                return "resetPassword";
            } else {
                model.addAttribute("userName", userName);
               // model.addAttribute("filePath", entity.getFilePath());
                return "Success";
            }
        }
        return "UserLogin";
    }

}
