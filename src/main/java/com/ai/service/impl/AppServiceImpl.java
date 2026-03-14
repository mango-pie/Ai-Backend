package com.ai.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ai.model.entity.App;
import com.ai.mapper.AppMapper;
import com.ai.service.AppService;
import org.springframework.stereotype.Service;

/**
 * 应用 服务层实现。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App>  implements AppService{

}
