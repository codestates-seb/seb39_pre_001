package com.preproject.preproject.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    //암호화에 필요한 PasswordEncoder 를 Bean 에 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // authenticationManager 를 Bean 에 등록
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()  // rest api 고려하여 기본 설정 해제
//                .cors().and()
                .csrf().disable()   // csrf 보안 토큰 해제
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 해제
                .and()
                .authorizeRequests()
                .antMatchers("/questions/ask").hasRole("USER")
                .antMatchers("/**").permitAll()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
                // JwtAuthenticationFilter 를 UsernamePasswordAuthenticationFilter 전에 넣는다.
    }
}
