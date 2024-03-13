package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.dto.UserInformationRequest;
import com.example.demo.entity.UserInformation;
import com.example.demo.service.UserInformationService;

@Controller
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;

    /**
     * ユーザー情報画面を表示
     * @param model Model
     * @return ユーザー情報画面 or ユーザー情報登録画面
     */
    @GetMapping("/userinformation")
    public String display(Model model) {

        UserInformation userInformation = userInformationService.findByUsername();
        if(userInformation == null){
            model.addAttribute("title", "ユーザー情報登録");
            model.addAttribute("userInformationRequest", new UserInformationRequest());
            return "userInformation/userinformationregister";
        } else {
            UserInformationRequest userInformationRequest = new UserInformationRequest();
            userInformationRequest.setEmployeeNum(userInformation.getEmployeeNum());
            userInformationRequest.setFamilyName(userInformation.getFamilyName());
            userInformationRequest.setFirstName(userInformation.getFirstName());
            userInformationRequest.setFamilyNameKana(userInformation.getFamilyNameKana());
            userInformationRequest.setFirstNameKana(userInformation.getFirstNameKana());
            userInformationRequest.setBirthday(userInformation.getBirthday());
            userInformationRequest.setPhoneNumber(userInformation.getPhoneNumber());
            userInformationRequest.setMailAddress(userInformation.getMailAddress());
            userInformationRequest.setPostCode(userInformation.getPostCode());
            userInformationRequest.setAddressRegion(userInformation.getAddressRegion());
            userInformationRequest.setAddressCity(userInformation.getAddressCity());
            userInformationRequest.setAddressStreet(userInformation.getAddressStreet());
            userInformationRequest.setEmergencyContactName(userInformation.getEmergencyContactName());
            userInformationRequest.setEmergencyContactNameKana(userInformation.getEmergencyContactNameKana());
            userInformationRequest.setEmergencyContactPhoneNumber(userInformation.getEmergencyContactPhoneNumber());
            userInformationRequest.setEmergencyContactRelationship(userInformation.getEmergencyContactRelationship());

            model.addAttribute("title", "ユーザー情報");
            model.addAttribute("userInformationRequest", userInformationRequest);
            return "userInformation/userinformation";
        }
    }

    /**
     * ユーザー情報更新
     * @param attendanceContactRequest 勤怠連絡リクエストデータ
     * @return ユーザー情報画面
     */
    @PutMapping("/userinformation/update")
    public String update(@ModelAttribute UserInformationRequest userInformationRequest) {
        userInformationService.update(userInformationRequest);
        return "redirect:/userinformation";
    }

    /**
     * ユーザー情報登録
     * @param attendanceContactRequest 勤怠連絡リクエストデータ
     * @return ユーザー情報画面
     */
    @PostMapping("/userinformation/register")
    public String create(@ModelAttribute UserInformationRequest userInformationRequest) {
        userInformationService.save(userInformationRequest);
        return "redirect:/userinformation";
    }
}
