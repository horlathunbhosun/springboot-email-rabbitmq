package com.olatunbosun.springRabbitMq.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 13:06
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GenericResponseDTO {

    private String message;
    private String status;
    @JsonProperty("status_code")
    private int statusCode;
    private Object data;
    @JsonProperty("error_data")
    private Object errorData;
    @JsonProperty("error_message")
    private Map<String, String> errorMessage;
}