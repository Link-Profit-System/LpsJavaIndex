package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * ユーザー認証 リクエストデータ
 */
@Data
public class UserRequest {

    /**
     * ユーザー名称
     */
    @NotEmpty
    private String username;

    /**
     * パスワード
     */
    @NotEmpty
    private String password;

    /**
     * メールアドレス
     */
    @NotEmpty
    private String email;
}
