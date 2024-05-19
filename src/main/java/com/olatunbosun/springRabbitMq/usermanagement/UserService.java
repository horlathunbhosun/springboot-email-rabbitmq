package com.olatunbosun.springRabbitMq.usermanagement;

import com.olatunbosun.springRabbitMq.usermanagement.dto.CreateUserDTO;
import com.olatunbosun.springRabbitMq.usermanagement.dto.GenericResponseDTO;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 12:51
 */
public interface UserService {
    GenericResponseDTO saveUser(CreateUserDTO createUserDTO);

}
