package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService { // UserDetailsServiceインターフェースを実装しています

    @Autowired // Springが自動的にUserRepositoryの実装を注入します
    private UserRepository userRepository;

    @Autowired // Springが自動的にPasswordEncoderの実装を注入します
    private PasswordEncoder passwordEncoder;

    @Override // UserDetailsServiceインターフェースのメソッドを上書きします
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // ユーザー名でユーザーを検索します
        if (user == null) {
            throw new UsernameNotFoundException("User not found"); // ユーザーが見つからない場合、例外をスローします
        }
        return new UserPrincipal(user); // ユーザーが見つかった場合、UserPrincipalを作成し返します
    }

    //新たにメソッドを追加します
    public User findByUsername(String username) {
        return userRepository.findByUsername(username); // ユーザー名でユーザーを検索し返します
    }

    public void save(UserRequest userRequest) {
        // UserRequestからUserへの変換
        User user = new User();
        user.setUsername(userRequest.getUsername());
        // パスワードをハッシュ化してから保存
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());

        // データベースへの保存
        userRepository.save(user); // UserRepositoryを使ってユーザーをデータベースに保存します
    }
}
