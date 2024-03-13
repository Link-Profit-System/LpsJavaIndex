package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, String> {

    // ユーザー名でユーザーを探すメソッド。ユーザー名をパラメータとして渡すと、そのユーザー名を持つユーザーをデータベースから探して返します。
	UserInformation findByUsername(String username);

}
