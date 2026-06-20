package com.ai.service;

import com.ai.model.dto.blog.BlogCategoryAddRequest;
import com.ai.model.dto.blog.BlogCategoryQueryRequest;
import com.ai.model.dto.blog.BlogCategoryUpdateRequest;
import com.ai.model.entity.BlogCategory;
import com.ai.model.vo.blog.BlogCategoryVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;

public interface BlogCategoryService extends IService<BlogCategory> {

    long addCategory(BlogCategoryAddRequest blogCategoryAddRequest);

    boolean updateCategory(BlogCategoryUpdateRequest blogCategoryUpdateRequest);

    boolean deleteCategory(Long id);

    BlogCategoryVO getCategoryVO(Long id);

    Page<BlogCategoryVO> queryCategoryPage(BlogCategoryQueryRequest blogCategoryQueryRequest);

    QueryWrapper getQueryWrapper(BlogCategoryQueryRequest blogCategoryQueryRequest);
}
