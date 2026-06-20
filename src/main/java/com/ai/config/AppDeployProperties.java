package com.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AI 实验室代码生成/部署目录与对外访问域名（生产环境通过 application-prod.yml 覆盖）。
 */
@Data
@Component
@ConfigurationProperties(prefix = "app.deploy")
public class AppDeployProperties {

    /**
     * 部署后小站点 URL 前缀，如 https://example.com
     */
    private String host = "http://localhost";

    /**
     * 代码生成暂存目录；为空时使用 {user.dir}/tmp/code_output
     */
    private String codeOutputDir;

    /**
     * 部署输出目录；为空时使用 {user.dir}/tmp/code_deploy
     */
    private String codeDeployDir;

    public String resolveCodeOutputDir() {
        if (codeOutputDir != null && !codeOutputDir.isBlank()) {
            return codeOutputDir;
        }
        return System.getProperty("user.dir") + "/tmp/code_output";
    }

    public String resolveCodeDeployDir() {
        if (codeDeployDir != null && !codeDeployDir.isBlank()) {
            return codeDeployDir;
        }
        return System.getProperty("user.dir") + "/tmp/code_deploy";
    }
}
