package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // ユーザー名でユーザーを探すメソッド。ユーザー名をパラメータとして渡すと、そのユーザー名を持つユーザーをデータベースから探して返します。
	User findByUsername(String username);

}
