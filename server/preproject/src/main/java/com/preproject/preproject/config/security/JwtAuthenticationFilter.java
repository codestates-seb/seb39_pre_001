package com.preproject.preproject.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider provider) {
        jwtTokenProvider = provider;
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        // 헤더에서 JWT 를 받아온다.
//        String token = jwtTokenProvider.resolveToken(request);
//
//        //유효한 토큰인지 확인
//        if (token != null && jwtTokenProvider.validateToken(token)) {
//            //토큰이 유효하면 토큰으로부터 유저 정보를 받아옴.
//            Authentication authentication = jwtTokenProvider.getAuthentication(token);
//            // SecurityContext 에 Authentication 객체를 저장
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        filterChain.doFilter(request, response);
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 헤더에서 JWT 를 받아온다.
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
//        System.out.println(token);

        // 받아온 토큰이 null 이거나 Bearer 로 시작하지 않으면 필터 실행
//        if (token == null || !token.startsWith("Bearer")) {
//            chain.doFilter(request, response);
//            return;
//        }

        // 받아온 토큰이 Bearer 로 시작하면 replace 하여 복호화
//        String jwt = token.replace("Bearer  ", "");
//        System.out.println(jwt);

        // 유효한 토큰인지 확인
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // 토큰이 유효하면 토큰으로부터 유저 정보를 받아온다.
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // SecurityContext 에 Authentication 객체를 저장.
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        chain.doFilter(request, response);

    }
}
