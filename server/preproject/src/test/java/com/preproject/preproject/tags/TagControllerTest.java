package com.preproject.preproject.tags;

import com.google.gson.Gson;
import com.preproject.preproject.tags.controller.TagController;
import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.mapper.mapstruct.TagMapper;
import com.preproject.preproject.tags.service.TagService;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TagController.class)
@AutoConfigureRestDocs
public class TagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private TagService tagService;

    @MockBean
    private TagMapper tagMapper;

    @Test
    @DisplayName("Tag 조회 테스트")
    public void getTagsTest() throws Exception {

        //given
//        List<Tags> tags = List.of(
//                new Tags(1, "JAVA"),
//                new Tags(2, "JAVA SCRIPT"),
//                new Tags(3, "REACT"),
//                new Tags(4, "SPRING BOOT")
//        );

        List<TagResponseDto> tags = List.of(new TagResponseDto(1L, "JAVA"));

        String content = gson.toJson(tags);


        given(tagService.findTags()).willReturn(List.of());
        given(tagMapper.listFromDto(Mockito.any(List.class))).willReturn(tags);

        //when
        ResultActions actions =
                mockMvc.perform(get("/tags")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));


        //then
        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.tags_id").value(1))
//                .andExpect(jsonPath("$.name").value("JAVA"))
//                .andExpect(jsonPath("$.tags_id").value(2))
//                .andExpect(jsonPath("$.name").value("JAVA SCRIPT"))
//                .andExpect(jsonPath("$.tags_id").value(3))
//                .andExpect(jsonPath("$.name").value("REACT"))
//                .andExpect(jsonPath("$.tags_id").value(4))
////                .andExpect(jsonPath("$.name").value("SPRING BOOT"))
                .andDo(document("get-tags",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        responseFields(
                                fieldWithPath("data[]").type(JsonFieldType.ARRAY).description("태그"),
                                fieldWithPath("data[].tagId").type(JsonFieldType.NUMBER).description("태그식별자"),
                                fieldWithPath("data[].name").type(JsonFieldType.STRING).description("태그 이름")
                        )));

    }
}
