package com.ai.service;

import com.ai.model.entity.BlogPostTag;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface BlogPostTagService extends IService<BlogPostTag> {

    boolean addPostTag(Long postId, Long tagId);

    boolean removeByPostId(Long postId);

    boolean removeByTagId(Long tagId);

    boolean removePostTag(Long postId, Long tagId);

    List<Long> getTagIdsByPostId(Long postId);

    List<Long> getPostIdsByTagId(Long tagId);

    boolean existsPostTag(Long postId, Long tagId);
}
