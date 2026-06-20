package com.ai.controller;

import com.ai.common.BaseResponse;
import com.ai.exception.BusinessException;
import com.ai.exception.ErrorCode;
import com.ai.model.dto.ImageUploadResponse;
import com.ai.model.entity.User;
import com.ai.service.ImageUploadService;
import com.ai.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传控制器
 */
@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @Resource
    private UserService userService;

    @Resource
    private ImageUploadService imageUploadService;

    /**
     * 上传图片
     */
    @PostMapping("/image")
    public BaseResponse<ImageUploadResponse> uploadImage(@RequestParam("file") MultipartFile file,
                                                         HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "未登录，无法上传图片");
        }

        ImageUploadResponse response = imageUploadService.uploadImage(file, loginUser.getId());
        return BaseResponse.success(response);
    }

    /**
     * 上传通用图片（用于博客、聊天等场景，不更新用户头像）
     */
    @PostMapping("/common")
    public BaseResponse<String> uploadCommonImage(@RequestParam("file") MultipartFile file,
                                                 HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "未登录，无法上传图片");
        }
        String url = imageUploadService.uploadCommonImage(file, loginUser.getId());
        return BaseResponse.success(url);
    }

    /**
     * 删除图片
     */
    @DeleteMapping("/image")
    public BaseResponse<Boolean> deleteImage(@RequestParam String filename,
                                             HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "未登录，无法删除图片");
        }

        boolean result = imageUploadService.deleteImage(filename, loginUser.getId());
        if (result) {
            return BaseResponse.success(true);
        } else {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "删除图片失败");
        }
    }
}