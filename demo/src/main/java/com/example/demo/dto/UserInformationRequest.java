package com.example.demo.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserInformationRequest {

    /**
     * 社員番号
     */
    @NotEmpty
    private String employeeNum;

    /**
     * 姓
     */
    @NotEmpty
    private String familyName;

    /**
     * 名
     */
    @NotEmpty
    private String firstName;

    /**
     * 姓(カナ)
     */
    @NotEmpty
    private String familyNameKana;

    /**
     * 名(カナ)
     */
    @NotEmpty
    private String firstNameKana;

    /**
     * 生年月日
     */
    @NotEmpty
    private Date birthday;

    /**
     * 電話番号
     */
    @NotEmpty
    private String phoneNumber;

    /**
     * メールアドレス
     */
    @NotEmpty
    private String mailAddress;

    /**
     * 郵便番号
     */
    @NotEmpty
    private String postCode;

    /**
     * 住所（都道府県）
     */
    @NotEmpty
    private String addressRegion;

    /**
     * 住所（市町村）
     */
    @NotEmpty
    private String addressCity;

    /**
     * 住所（町域以下住所）
     */
    @NotEmpty
    private String addressStreet;

    /**
     * 緊急連絡先（姓名）
     */
    @NotEmpty
    private String emergencyContactName;

    /**
     * 緊急連絡先（姓名カナ）
     */
    @NotEmpty
    private String emergencyContactNameKana;

    /**
     * 緊急連絡先（電話番号）
     */
    @NotEmpty
    private String emergencyContactPhoneNumber;

    /**
     * 緊急連絡先（続柄）
     */
    @NotEmpty
    private String emergencyContactRelationship;
}
