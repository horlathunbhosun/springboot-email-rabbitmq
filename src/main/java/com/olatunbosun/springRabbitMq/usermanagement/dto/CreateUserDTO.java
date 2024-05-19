package com.olatunbosun.springRabbitMq.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 13:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
