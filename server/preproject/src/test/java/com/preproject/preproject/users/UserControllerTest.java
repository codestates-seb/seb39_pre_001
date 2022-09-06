package com.preproject.preproject.users;

import com.google.gson.Gson;
import com.preproject.preproject.users.controller.UsersController;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.dto.UsersResponseDto;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.mapper.UserMapper;
import com.preproject.preproject.users.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.preproject.preproject.ApiDocumentUtils.getRequestPreProcessor;
import static com.preproject.preproject.ApiDocumentUtils.getResponsePreProcessor;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UsersController.class)
@AutoConfigureRestDocs
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("회원가입 테스트")
    public void postUserTest() throws Exception {

        //given
        UsersPostDto post = UsersPostDto.builder()
                .display_name("사용자이름")
                .email("email@gmail.com")
                .password("password")
                .build();

        UsersResponseDto responseDto =
                UsersResponseDto.builder()
                        .userId(1L)
                        .displayName("user1")
                        .build();

        String content = gson.toJson(post);

        given(userMapper.userPost(Mockito.any(UsersPostDto.class))).willReturn(Mockito.mock(Users.class));
        given(userService.createUser(Mockito.any(Users.class))).willReturn(Mockito.mock(Users.class));
        given(userMapper.userResponse(Mockito.any(Users.class))).willReturn(responseDto);

        //when
        ResultActions actions =
                mockMvc.perform(post("/users/join")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));


        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.displayName").value("user1"))
                .andDo(document("post-user",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                fieldWithPath("display_name").type(JsonFieldType.STRING).description("사용자이름"),
                                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("암호")
                        ),
                        responseFields(
                                fieldWithPath("data.userId").type(JsonFieldType.NUMBER).description("사용자 식별자"),
                                fieldWithPath("data.displayName").type(JsonFieldType.STRING).description("사용자이름")
                        )));
    }
}
