package com.ai.service;

import com.ai.model.dto.blog.BlogTagAddRequest;
import com.ai.model.dto.blog.BlogTagQueryRequest;
import com.ai.model.dto.blog.BlogTagUpdateRequest;
import com.ai.model.entity.BlogTag;
import com.ai.model.vo.blog.BlogTagVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface BlogTagService extends IService<BlogTag> {

    long addTag(BlogTagAddRequest blogTagAddRequest);

    boolean updateTag(BlogTagUpdateRequest blogTagUpdateRequest);

    boolean deleteTag(Long id);

    BlogTagVO getTagVO(Long id);

    Page<BlogTagVO> queryTagPage(BlogTagQueryRequest blogTagQueryRequest);

    QueryWrapper getQueryWrapper(BlogTagQueryRequest blogTagQueryRequest);

    List<BlogTag> getTagsByPostId(Long postId);

    boolean incrementCount(Long tagId);

    boolean decrementCount(Long tagId);
}
