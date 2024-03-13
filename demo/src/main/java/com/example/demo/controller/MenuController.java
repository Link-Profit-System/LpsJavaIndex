package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UserInformation;
import com.example.demo.service.UserInformationService;

@Controller
public class MenuController {

    @Autowired
    private UserInformationService userInformationService;
    
    @GetMapping("/menu")
    public String menu(Model model) {

        UserInformation userInformation = userInformationService.findByUsername();
        model.addAttribute("title", "索引");
        if(userInformation == null){
            return "menu/menuonlyuserinformation";
        } else {
            return "menu/menu";
        }   
    }
}
