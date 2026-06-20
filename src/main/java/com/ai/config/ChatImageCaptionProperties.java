package com.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "chat.image-caption")
public class ChatImageCaptionProperties {

    private boolean enabled = true;

    private String baseUrl = "https://open.bigmodel.cn/api/paas/v4";

    private String apiKey = "";

    private String modelName = "glm-4v-flash";

    private String prompt = "请用中文详细描述这张图片：包括画面主体、场景、颜色、文字内容（如有）、人物动作与情绪。只输出描述，不要提问。";

    private int timeoutSeconds = 30;
}
