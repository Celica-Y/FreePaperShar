package com.example.service;

import java.util.Collection;

import com.example.entity.userData;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails{
    private final userData userData;

    public AccountUserDetails(userData userData) {
        this.userData = userData;
    }
    
    public userData getUser() { 
        return userData;
    }

    public String getName() { 
        return this.userData.getEmail();
    }


    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() { // ユーザに与えられている権限リストを返却するメソッド
    //     return AuthorityUtils.createAuthorityList("ROLE_" + this.userData.getRoleName());
    // }

    @Override
    public String getPassword() { 
        return this.userData.getPassword();
    }

    @Override
    public String getUsername() { 
        return this.userData.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() { // アカウントの有効期限の状態を判定するメソッド
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // アカウントのロック状態を判定するメソッド
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 資格情報の有効期限の状態を判定するメソッド
        return true;
    }

    @Override
    public boolean isEnabled() { // 有効なユーザかを判定するメソッド
        return true;
    }

    
}
