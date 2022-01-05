
  package com.example.farmerservice.config;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import
  org.springframework.security.authentication.AuthenticationManager; import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter; import
  org.springframework.security.crypto.password.NoOpPasswordEncoder; import
  org.springframework.security.crypto.password.PasswordEncoder;
  
  import com.example.farmerservice.repo.FarmerRepo; import
  com.example.farmerservice.service.FarmerService;
  
  @Configuration
  @EnableWebSecurity public class SecurityConfig extends
  WebSecurityConfigurerAdapter {
  
  @Autowired 
  FarmerService farmerservice;
  

  
  @Override protected void configure(AuthenticationManagerBuilder auth) throws
  Exception {
  
  auth.userDetailsService(farmerservice); }
  
  @Override protected void configure(HttpSecurity http) throws Exception {
  
  http.csrf().disable().authorizeRequests().antMatchers("/farmer/addfarmers",
  "/farmer/addcrop","/farmer/allfarmers","/trader/viewallfarmers",
  "/farmer/buycrop/{id}","/farmer/deletefarmer/{id}","/farmer/rating/{ID}",
  "/farmer/update/{id}", "/farmer/security","/farmer/auth").permitAll()
  .anyRequest().authenticated().and().formLogin(); }
  
  @Bean public PasswordEncoder passwordEncoder() { return
  NoOpPasswordEncoder.getInstance();
  
  }
  
  @Override
  
  @Bean 
  public AuthenticationManager authenticationManagerBean() throws
  Exception { 
	  return super.authenticationManagerBean();
  
  }
  
  }
 