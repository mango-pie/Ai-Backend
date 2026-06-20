package com.ai.service;

import com.ai.model.dto.blog.BlogPostAddRequest;
import com.ai.model.dto.blog.BlogPostQueryRequest;
import com.ai.model.dto.blog.BlogPostUpdateRequest;
import com.ai.model.entity.BlogPost;
import com.ai.model.vo.blog.BlogPostVO;
import com.mybatisflex.core.service.IService;
import com.mybatisflex.core.paginate.Page;

public interface BlogPostService extends IService<BlogPost> {

    long addBlogPost(BlogPostAddRequest blogPostAddRequest, Long userId);

    boolean updateBlogPost(BlogPostUpdateRequest blogPostUpdateRequest, Long userId);

    boolean deleteBlogPost(Long id, Long userId);

    boolean updateBlogPostStatus(Long id, Integer status, Long userId);

    boolean toggleTopStatus(Long id, Integer isTop, Long userId);

    boolean incrementViewCount(Long id);

    boolean incrementLikeCount(Long id);

    BlogPostVO getBlogPostVO(Long id);

    Page<BlogPostVO> queryBlogPostPage(BlogPostQueryRequest blogPostQueryRequest);

    Page<BlogPostVO> getBlogPostPageByCategory(Long categoryId, int pageNum, int pageSize);

    Page<BlogPostVO> getBlogPostPageByTag(Long tagId, int pageNum, int pageSize);

    Page<BlogPostVO> getPublishedBlogPostPage(int pageNum, int pageSize);

    com.mybatisflex.core.query.QueryWrapper getQueryWrapper(BlogPostQueryRequest blogPostQueryRequest);
}
