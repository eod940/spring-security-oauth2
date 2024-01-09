package com.example.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  // 싱글톤 아니니까 2개가 생성되는걸 확인
  @Bean
  public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
    http.authorizeRequests(request -> request
            .anyRequest()
            .authenticated())
        .formLogin();
//        .apply(new CustomSecurityConfigurer().setFlag(false));

    return http.build();
  }

  @Bean
  public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
    http.authorizeRequests(request -> request
            .anyRequest()
            .authenticated())
//        .formLogin()
        .httpBasic();

    return http.build();
  }

}
