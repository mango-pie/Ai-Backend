package com.ai.service;

import com.ai.model.dto.blog.BlogImageQueryRequest;
import com.ai.model.entity.BlogImage;
import com.ai.model.vo.blog.BlogImageVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;

public interface BlogImageService extends IService<BlogImage> {

    long uploadImage(BlogImage blogImage);

    boolean deleteImage(Long id, Long userId);

    boolean updateImageStatus(Long id, Integer status, Long userId);

    boolean bindImageToPost(Long imageId, Long postId, Long userId);

    BlogImageVO getImageVO(Long id);

    Page<BlogImageVO> queryImagePage(BlogImageQueryRequest blogImageQueryRequest);

    QueryWrapper getQueryWrapper(BlogImageQueryRequest blogImageQueryRequest);

    java.util.List<BlogImage> getImagesByPostId(Long postId);
}
