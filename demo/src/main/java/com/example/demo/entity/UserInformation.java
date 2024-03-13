package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user_informations")
public class UserInformation extends AbstractEntity {

    /**
     * ユーザー名称
     */
    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * 社員番号
     */
    @Column(name = "employee_num", nullable = false, unique = true)
    private String employeeNum;

    /**
     * 姓
     */
    @Column(name = "family_name", nullable = false)
    private String familyName;

    /**
     * 名
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * 姓(カナ)
     */
    @Column(name = "family_name_kana", nullable = false)
    private String familyNameKana;

    /**
     * 名(カナ)
     */
    @Column(name = "first_name_kana", nullable = false)
    private String firstNameKana;

    /**
     * 生年月日
     */
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    /**
     * 電話番号
     */
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    /**
     * メールアドレス
     */
    @Column(name = "mail_address", nullable = false, unique = true)
    private String mailAddress;

    /**
     * 郵便番号
     */
    @Column(name = "post_code", nullable = false)
    private String postCode;

    /**
     * 住所（都道府県）
     */
    @Column(name = "address_region", nullable = false)
    private String addressRegion;

    /**
     * 住所（市町村）
     */
    @Column(name = "address_city", nullable = false)
    private String addressCity;

    /**
     * 住所（町域以下住所）
     */
    @Column(name = "address_street", nullable = false)
    private String addressStreet;

    /**
     * 緊急連絡先（姓名）
     */
    @Column(name = "emergency_contact_name", nullable = false)
    private String emergencyContactName;

    /**
     * 緊急連絡先（姓名カナ）
     */
    @Column(name = "emergency_contact_name_kana", nullable = false)
    private String emergencyContactNameKana;

    /**
     * 緊急連絡先（電話番号）
     */
    @Column(name = "emergency_contact_phone_number", nullable = false)
    private String emergencyContactPhoneNumber;

    /**
     * 緊急連絡先（続柄）
     */
    @Column(name = "emergency_contact_relationship", nullable = false)
    private String emergencyContactRelationship;

    /**
     * 登録者
     */
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    /**
     * 更新者
     */
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
}