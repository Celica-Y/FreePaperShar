package com.example.service;

import java.util.Collection;

import com.example.entity.userData;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails{

	private final userData myUser;

    public AccountUserDetails(userData myUser) {
        this.myUser = myUser;
    }
    
    public userData getUser() { 
        return myUser;
    }

    public String getName() { 
        return this.myUser.getEmail();
    }

    private Collection<GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // ユーザに与えられている権限リストを返却するメソッド
        return authorities;
    }

    @Override
    public String getPassword() { 
        return this.myUser.getPassword();
    }

    @Override
    public String getUsername() { 
        return this.myUser.getEmail();
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
