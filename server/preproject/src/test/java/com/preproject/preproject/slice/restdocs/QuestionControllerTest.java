package com.preproject.preproject.slice.restdocs;

import com.google.gson.Gson;
import com.preproject.preproject.helper.QuestionControllerHelper;
import com.preproject.preproject.helper.RestDocumentationHelper;
import com.preproject.preproject.questions.controller.QuestionController;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.mapper.QuestionMapper;
import com.preproject.preproject.questions.service.QuestionService;
import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.users.dto.UsersResponseDto;
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

import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(QuestionController.class)
@AutoConfigureRestDocs
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper questionMapper;

    @DisplayName("QuestionController.getQuestion")
    @Test
    public void givenQuestionId_whenGetRequested_thenQuestionReturned() throws Exception {

        //given
        long questionId = 1L;

        UsersResponseDto usersResponseDto =
                UsersResponseDto.builder()
                        .displayName("homer simpson")
                        .userId(1L)
                        .build();

        List<TagResponseDto> tagResponseDtos = List.of(
                TagResponseDto.builder().tagId(1L).name("java").build(),
                TagResponseDto.builder().tagId(2L).name("spring").build(),
                TagResponseDto.builder().tagId(3L).name("jpa").build()
        );

        QuestionResponseDto responseDto =
                QuestionResponseDto.builder()
                        .questionId(questionId)
                        .title("question 1")
                        .description("this is question 1")
                        .tags(tagResponseDtos)
                        .user(usersResponseDto)
                        .build();

        given(questionService.getQuestion(Mockito.anyLong())).willReturn(Mockito.mock(Question.class));
        given(questionMapper.dtoFrom(Mockito.any(Question.class))).willReturn(responseDto);

        //when
        ResultActions resultActions = mockMvc.perform(
            get(QuestionControllerHelper.URL+"/{questionId}", questionId)
                    .contentType(MediaType.APPLICATION_JSON)
        );


        //then
        verify(questionService).getQuestion(Mockito.anyLong());

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.questionId").value(responseDto.getQuestionId()))
                .andExpect(jsonPath("$.data.title").value(responseDto.getTitle()))
                .andExpect(jsonPath("$.data.description").value(responseDto.getDescription()))
                .andExpect(jsonPath("$.data.user.userId").value(responseDto.getUser().getUserId()))
                .andExpect(jsonPath("$.data.user.displayName").value(responseDto.getUser().getDisplayName()))
                .andExpect(jsonPath("$.data.tags").isArray())
                .andDo(
                        document(
                                "get-question",
                                RestDocumentationHelper.prettyPrintRequest(),
                                RestDocumentationHelper.prettyPrintResponse(),
                                pathParameters(
                                        parameterWithName("questionId").description("게시글 식별자")
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("게시글 식별자").ignored(),
                                                fieldWithPath("data.title").type(JsonFieldType.STRING).description("게시글 제목"),
                                                fieldWithPath("data.description").type(JsonFieldType.STRING).description("게시글 내용"),
                                                fieldWithPath("data.user").type(JsonFieldType.OBJECT).description("작성자"),
                                                fieldWithPath("data.user.userId").type(JsonFieldType.NUMBER).description("작성자 식별자"),
                                                fieldWithPath("data.user.displayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
                                                fieldWithPath("data.tags[]").type(JsonFieldType.ARRAY).description("관련 태그"),
                                                fieldWithPath("data.tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
                                                fieldWithPath("data.tags[].name").type(JsonFieldType.STRING).description("태그 이름")
                                        )
                                )
                        )
                );
    }


    @DisplayName("QuestionController.postQuestion")
    @Test
    public void givenPostDto_whenPostRequested_thenQuestionReturned() throws Exception {

        //given
        QuestionPostDto requestDto =
                QuestionPostDto.builder()
                        .title("question 1")
                        .description("this is question 1")
                        .build();

        String requestBody = gson.toJson(requestDto);

        QuestionResponseDto responseDto =
                QuestionResponseDto.builder()
                        .questionId(1L)
                        .title(requestDto.getTitle())
                        .description(requestDto.getDescription())
                        .build();

        given(questionMapper.entityFromDto(Mockito.any(QuestionPostDto.class))).willReturn(Mockito.mock(Question.class));
        given(questionService.postQuestion(Mockito.any(Question.class))).willReturn(Mockito.mock(Question.class));
        given(questionMapper.dtoFrom(Mockito.any(Question.class))).willReturn(responseDto);

        //when
        ResultActions resultActions =
                mockMvc
                        .perform(
                                post(QuestionControllerHelper.URL + "/ask")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .accept(MediaType.APPLICATION_JSON)
                                        .content(requestBody)
        );

        //then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.questionId").value(responseDto.getQuestionId()))
                .andExpect(jsonPath("$.data.title").value(responseDto.getTitle()))
                .andExpect(jsonPath("$.data.description").value(responseDto.getDescription()));

        //doc
        resultActions
                .andDo(
                        document(
                                "post-question",
                                RestDocumentationHelper.prettyPrintRequest(),
                                RestDocumentationHelper.prettyPrintResponse(),
                                requestFields(
                                        List.of(
                                                fieldWithPath("title").type(JsonFieldType.STRING).description("게시글 제목"),
                                                fieldWithPath("description").type(JsonFieldType.STRING).description("게시글 내용")
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("게시글 식별자"),
                                                fieldWithPath("data.title").type(JsonFieldType.STRING).description("게시글 제목"),
                                                fieldWithPath("data.description").type(JsonFieldType.STRING).description("게시글 내용")
                                        )
                                )
                        )
                );
    }
}
