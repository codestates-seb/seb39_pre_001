package com.preproject.preproject.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private String secretKey = "chickenmilktea";

    private long tokenValidTime = 60 * 60 * 1000L;  //유효시간 30분

    @Autowired
    private final UserDetailsService userDetailsService;


    // 객체 초기화, secretKey 를 Base64 로 인코딩
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성
    public String createToken(String userPk, List<String> roles, String displayName) {
        Claims claims = Jwts.claims().setSubject(userPk);   // JWT payload 에 저장되는 정보 단위
        claims.put("roles", roles); // 정보는 key / value 쌍으로 저장
        claims.put("displayName", displayName);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)  // 정보 저장
                .setIssuedAt(now)   // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime))    // set ExpireTime
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 사용항 암호화 알고리즘, 시그니쳐에 들어갈 secret 값 세팅
                .compact();
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Request 의 Header 에서 token 값을 가져옴. "X-AUTH-TOKEN" : "TOKEN 값"
    public String resolveToken(HttpServletRequest request) {
//        String token = null;
//        Cookie cookie = WebUtils.getCookie(request, "X-AUTH-TOKEN");
//        if(cookie != null) token = cookie.getValue();
//        return token;
        return request.getHeader("X-AUTH-TOKEN");
    }

    // 토큰 유효성, 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
