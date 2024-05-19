package com.olatunbosun.springRabbitMq.email;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 12:52
 */
@Data
@Builder
public class EmailDetailDTO {
    private String to;
    private String subject;
    private Map<String, Object> dynamicValue;
    private String templateName;
}