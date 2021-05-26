package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Bean
    public PasswordEncoder passwordEncoder() {
        //BCryptアルゴリズムを使用してパスワードのハッシュ化を行う
        return new BCryptPasswordEncoder(); // BCryptアルゴリズムを使用
    }

    @Override
	     public void configure(WebSecurity web) throws Exception {
	         web
	                 .ignoring()
	                 .antMatchers("/resources/**","/js/**/","/static/**", "/css/**","/images/**","/fonts/**","/node_modules/**","/sass/**");
	     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 認可の設定
        http.exceptionHandling()
                .accessDeniedPage("/accessDeniedPage")  // アクセス拒否された時に遷移するパス
            .and()
            .authorizeRequests()
                .antMatchers("/login","/search","/","/entry","/resources/**","/js/**","/login?","/resources/**","/js/**/","/static/**", "/css/**","/images/**","/fonts/**","/node_modules/**","/sass/**").permitAll()  // /loginFormは、全ユーザからのアクセスを許可
                .anyRequest().authenticated();          //  上記以外は、認証を求める
                // .and()
                // .sessionManagement();

        // ログイン設定
        http.formLogin()                                // フォーム認証の有効化
                .loginPage("/login")                // ログインフォームを表示するパス
                .loginProcessingUrl("/login")    // フォーム認証処理のパス
                .usernameParameter("Email")          // ユーザ名のリクエストパラメータ名
                .passwordParameter("password")          // パスワードのリクエストパラメータ名
                .defaultSuccessUrl("/mypage")             // 認証成功時に遷移するデフォルトのパス
                .failureUrl("/login?");   // 認証失敗時に遷移するパス

        // ログアウト設定
        http.logout()
                .logoutSuccessUrl("/")         // ログアウト成功時に遷移するパス
                .permitAll();  // 全ユーザに対してアクセスを許可

        http.csrf().disable();  //disableの呼び出し無効化。認証が必要なAPIなどがあるときには安易に使ってはいけない。
    }

}
