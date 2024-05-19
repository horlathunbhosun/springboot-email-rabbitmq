package com.olatunbosun.springRabbitMq.usermanagement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 12:50
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
