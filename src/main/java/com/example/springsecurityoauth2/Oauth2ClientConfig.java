package com.example.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class Oauth2ClientConfig {

  @Bean
  public ClientRegistrationRepository clientRegistrationRepository() {
    return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
  }

  private ClientRegistration keycloakClientRegistration() {

    return ClientRegistrations.fromIssuerLocation("http://localhost:8080/realms/oauth2")
        .registrationId("keycloak")
        .clientId("oauth2-client-app")
        .clientSecret("GqzroMtUlZyEW9aI5PWEMJwDBcp1BKiE")
        .build();
  }
}
