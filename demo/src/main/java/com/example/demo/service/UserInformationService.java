package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserInformationRequest;
import com.example.demo.entity.UserInformation;
import com.example.demo.repository.UserInformationRepository;

@Service
public class UserInformationService {

    @Autowired
    private UserInformationRepository userInformationRepository;

    public UserInformation findByUsername() {

        // SecurityContextHolderからAuthenticationオブジェクトを取得
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return userInformationRepository.findByUsername(authentication.getName());
    }

    public void save(UserInformationRequest userInformationRequest) {

        // SecurityContextHolderからAuthenticationオブジェクトを取得
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(authentication.getName());
        userInformation.setEmployeeNum(userInformationRequest.getEmployeeNum());
        userInformation.setFamilyName(userInformationRequest.getFamilyName());
        userInformation.setFirstName(userInformationRequest.getFirstName());
        userInformation.setFamilyNameKana(userInformationRequest.getFamilyNameKana());
        userInformation.setFirstNameKana(userInformationRequest.getFirstNameKana());
        userInformation.setBirthday(userInformationRequest.getBirthday());
        userInformation.setPhoneNumber(userInformationRequest.getPhoneNumber());
        userInformation.setMailAddress(userInformationRequest.getMailAddress());
        userInformation.setPostCode(userInformationRequest.getPostCode());
        userInformation.setAddressRegion(userInformationRequest.getAddressRegion());
        userInformation.setAddressCity(userInformationRequest.getAddressCity());
        userInformation.setAddressStreet(userInformationRequest.getAddressStreet());
        userInformation.setEmergencyContactName(userInformationRequest.getEmergencyContactName());
        userInformation.setEmergencyContactNameKana(userInformationRequest.getEmergencyContactNameKana());
        userInformation.setEmergencyContactPhoneNumber(userInformationRequest.getEmergencyContactPhoneNumber());
        userInformation.setEmergencyContactRelationship(userInformationRequest.getEmergencyContactRelationship());
        userInformation.setCreatedBy(userInformationRequest.getFamilyName() + " " + userInformationRequest.getFirstName());
        userInformation.setUpdatedBy(userInformationRequest.getFamilyName() + " " + userInformationRequest.getFirstName());

        // データベースへの保存
        userInformationRepository.save(userInformation);
    }

    public void update(UserInformationRequest userInformationRequest) {

        // 更新データ取得
        UserInformation userInformation = findByUsername();

        // 上書き
        userInformation.setEmployeeNum(userInformationRequest.getEmployeeNum());
        userInformation.setFamilyName(userInformationRequest.getFamilyName());
        userInformation.setFirstName(userInformationRequest.getFirstName());
        userInformation.setFamilyNameKana(userInformationRequest.getFamilyNameKana());
        userInformation.setFirstNameKana(userInformationRequest.getFirstNameKana());
        userInformation.setBirthday(userInformationRequest.getBirthday());
        userInformation.setPhoneNumber(userInformationRequest.getPhoneNumber());
        userInformation.setMailAddress(userInformationRequest.getMailAddress());
        userInformation.setPostCode(userInformationRequest.getPostCode());
        userInformation.setAddressRegion(userInformationRequest.getAddressRegion());
        userInformation.setAddressCity(userInformationRequest.getAddressCity());
        userInformation.setAddressStreet(userInformationRequest.getAddressStreet());
        userInformation.setEmergencyContactName(userInformationRequest.getEmergencyContactName());
        userInformation.setEmergencyContactNameKana(userInformationRequest.getEmergencyContactNameKana());
        userInformation.setEmergencyContactPhoneNumber(userInformationRequest.getEmergencyContactPhoneNumber());
        userInformation.setEmergencyContactRelationship(userInformationRequest.getEmergencyContactRelationship());
        userInformation.setUpdatedBy(userInformationRequest.getFamilyName() + " " + userInformationRequest.getFirstName());

        // データベースへの保存
        userInformationRepository.save(userInformation);
    }
}
