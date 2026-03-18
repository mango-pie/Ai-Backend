package com.ai.service;

import com.ai.exception.ErrorCode;
import com.ai.model.dto.app.AppAddRequest;
import com.ai.model.dto.app.AppQueryRequest;
import com.ai.model.dto.app.AppUpdateRequest;
import com.ai.model.entity.App;
import com.ai.model.entity.User;
import com.ai.model.vo.AppVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 *
 */
public interface AppService extends IService<App> {

    /**
     * 创建应用
     *
     * @param appAddRequest 应用创建请求
     * @param userId 用户id
     * @return 应用id
     */
    Long addApp(AppAddRequest appAddRequest, Long userId);

    /**
     * 删除应用
     *
     * @param id 应用id
     * @param userId 用户id
     * @param isAdmin 是否是管理员
     * @return 是否删除成功
     */
    boolean deleteApp(Long id, Long userId, boolean isAdmin);

    /**
     * 更新应用
     *
     * @param appUpdateRequest 应用更新请求
     * @param userId 用户id
     * @param isAdmin 是否是管理员
     * @return 是否更新成功
     */
    boolean updateApp(AppUpdateRequest appUpdateRequest, Long userId, boolean isAdmin);

    /**
     * 根据id获取应用详情
     *
     * @param id 应用id
     * @param userId 用户id
     * @param isAdmin 是否是管理员
     * @return 应用详情
     */
    AppVO getAppById(Long id, Long userId, boolean isAdmin);

    /**
     * 分页查询用户自己的应用列表
     *
     * @param appQueryRequest 查询条件
     * @param userId 用户id
     * @return 分页结果
     */
    Page<AppVO> listMyAppByPage(AppQueryRequest appQueryRequest, Long userId);

    /**
     * 分页查询精选应用列表
     *
     * @param appQueryRequest 查询条件
     * @return 分页结果
     */
    Page<AppVO> listFeaturedAppByPage(AppQueryRequest appQueryRequest);

    /**
     * 管理员分页查询应用列表
     *
     * @param appQueryRequest 查询条件
     * @return 分页结果
     */
    Page<AppVO> listAppByPageForAdmin(AppQueryRequest appQueryRequest);

    /**
     * 获取应用VO对象
     *
     * @param app 应用实体
     * @return 应用VO
     */
    AppVO getAppVO(App app);

    /**
     * 批量获取应用VO对象
     *
     * @param appList 应用实体列表
     * @return 应用VO列表
     */
    List<AppVO> getAppVO(List<App> appList);


    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);
}