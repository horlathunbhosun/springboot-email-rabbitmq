package com.olatunbosun.springRabbitMq.usermanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 12:50
 */

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Integer token;
}
