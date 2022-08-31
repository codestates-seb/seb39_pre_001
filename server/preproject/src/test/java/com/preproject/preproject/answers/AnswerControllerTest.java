package com.preproject.preproject.answers;

import com.google.gson.Gson;
import com.preproject.preproject.answers.controller.AnswerController;
import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswerPostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static com.preproject.preproject.ApiDocumentUtils.getRequestPreProcessor;
import static com.preproject.preproject.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnswerController.class)
@AutoConfigureRestDocs
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    @DisplayName("답변등록 테스트")
    public void postAnswerTest() throws Exception {

        //given
        AnswerPostDto post = AnswerPostDto.builder()
                .content("답변내용").build();

        String content = gson.toJson(post);


        //when
        ResultActions actions =
                mockMvc.perform(post("/questions/{question-id}/answer", 1)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));


        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.content").value("답변내용"))
                .andDo(document("post-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("질문 번호")
                        ),
                        requestFields(
                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용")
                        ),
                        responseFields(
                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용")
                        )));
    }

    @Test
    @DisplayName("답변 수정 테스트")
    public void patchAnswerTest() throws Exception {

        //given
        long answer_id = 1L;

        AnswerPatchDto patch = AnswerPatchDto.builder()
                .answerId(answer_id)
                .content("답변 수정").build();

        String content = gson.toJson(patch);

        //when
        ResultActions actions =
                mockMvc.perform(patch("/questions/{question-id}/answer/{answer-id}", 1, answer_id)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.answer_id").value(patch.getAnswerId()))
                .andExpect(jsonPath("$.content").value("답변 수정"))
                .andDo(document("patch-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("answer-id").description("답변 번호"),
                                parameterWithName("question-id").description("질문 번호")
                        ),
                        requestFields(
                                fieldWithPath("answer_id").type(JsonFieldType.NUMBER).description("답변 번호"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변 수정")
                        ),
                        responseFields(
                                fieldWithPath("answer_id").type(JsonFieldType.NUMBER).description("답변 번호"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변 수정")
                        )));

    }

    @Test
    @DisplayName("답변 삭제 테스트")
    public void deleteAnswerTest() throws Exception {

        //given
        doNothing();

        //when
        ResultActions actions = mockMvc.perform(delete("/questions/{question-id}/answer/{answer-id}", 1, 1));

        //then
        MvcResult result = actions.andExpect(status().isNoContent())
                .andDo(document("delete-answer",
                        pathParameters(
                                parameterWithName("question-id").description("질문 번호"),
                                parameterWithName("answer-id").description("답변 번호")
                        )))
                .andReturn();
    }
}
