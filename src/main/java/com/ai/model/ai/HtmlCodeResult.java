package com.ai.model.ai;


import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

@Data
@Description("生成的HTML 代码结果")
public class HtmlCodeResult {

    @Description("HTML 代码")
    private String htmlCode;

    @Description("生成的代码描述")
    private String description;
}
