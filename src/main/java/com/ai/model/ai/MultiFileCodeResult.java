package com.ai.model.ai;


import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

@Data
@Description("生成的多文件代码结果")
public class MultiFileCodeResult {

    @Description("HTML 代码")
    private String htmlCode;
    @Description("CSS 代码")
    private String cssCode;

    @Description("JS 代码")
    private String jsCode;
    @Description("生成的代码描述")
    private String description;
}
