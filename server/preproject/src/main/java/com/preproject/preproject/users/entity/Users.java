package com.preproject.preproject.users.entity;


import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionDislike;
import com.preproject.preproject.questions.entity.QuestionLike;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;



@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
public class Users implements UserDetails {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String displayName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, updatable = false, nullable = false)
    private String email;

    @Builder.Default
    private LocalDateTime regdate = LocalDateTime.now();

//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<String> roles = new HashSet<>();
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<String> roles = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Question> questions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<QuestionLike> questionLikes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<QuestionDislike> questionDislikes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

//    @Override
//    public String getPassword() {
//        return password;
//    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean alreadyAnswered(Question question) {
        return this.getAnswers().stream().anyMatch(answer -> Objects.equals(answer.getQuestion().getQuestionId(), question.getQuestionId()));
    }
}