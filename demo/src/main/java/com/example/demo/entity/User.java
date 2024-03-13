package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザー認証 Entity
 */
@Entity
@Data
@Table(name = "users")
public class User {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * ユーザー名称
     */
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * パスワード
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * メールアドレス
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}