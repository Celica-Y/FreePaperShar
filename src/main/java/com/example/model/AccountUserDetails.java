package com.example.model;

import java.util.Collection;

import com.example.entity.userData;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails{
    private final userData user;

    public AccountUserDetails(userData user) {
        this.user = user;
    }
    
    public userData getUser() { 
        return user;
    }

    public String getEmail() { 
        return this.user.getEmail();
    }



    @Override
    public String getPassword() { 
        return this.user.getPassword();
    }

    @Override
    public String getUsername() { 
        return this.user.getUserName();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
}
