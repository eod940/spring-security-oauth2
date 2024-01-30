package com.example.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  // formLogin(), httpBasic() 같이 해도 authenticationEntryPoint가 가장 우선순위임
  // formLogin(), httpBasic() 여기선 form 인증 방식의 요청이 우선순위임
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(request -> request
        .anyRequest()
        .authenticated());
    http.httpBasic().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    return http.build();
  }

}
