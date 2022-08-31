package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;

public interface TagService {

    Tag findOrCreateTag(String name);
}
