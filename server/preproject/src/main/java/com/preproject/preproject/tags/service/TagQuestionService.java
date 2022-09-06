package com.preproject.preproject.tags.service;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.tags.repository.TagQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagQuestionService {

    private final TagQuestionRepository tagQuestionRepository;
    private final TagService tagService;

    public void mapTagQuestionToQuestion(Question entity, List<TagQuestion> tagQuestionList) {
        tagQuestionList.forEach(
                tagQuestion -> {
                    TagQuestion tagQuestionEntity =
                            tagQuestionRepository
                                    .findByTagName(
                                            tagQuestion
                                                    .getTag().getName(), entity.getQuestionId()
                                    )
                                    .orElseGet(
                                            () -> {
                                                Tag tag = tagService.findOrCreateTag(tagQuestion.getTag().getName());
                                                return TagQuestion.of(entity, tag);
                                            }
                                    );

                    tagQuestionRepository.save(tagQuestionEntity);
                }
        );
    }
}
