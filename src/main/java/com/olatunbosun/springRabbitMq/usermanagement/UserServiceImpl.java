package com.olatunbosun.springRabbitMq.usermanagement;

import com.olatunbosun.springRabbitMq.email.EmailDetailDTO;
import com.olatunbosun.springRabbitMq.usermanagement.dto.CreateUserDTO;
import com.olatunbosun.springRabbitMq.usermanagement.dto.GenericResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author olulodeolatunbosun
 * @created 19/05/2024/05/2024 - 12:51
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ModelMapper modelMapper;

    @Value("${rabbitmq.exchange.email.name}")
    private String emailExchange;

    @Value("${rabbitmq.binding.email.name}")
    private String emailRoutingKey;

    @Override
    public GenericResponseDTO saveUser(CreateUserDTO createUserDTO) {
        User user = modelMapper.map(createUserDTO, User.class);
        GenericResponseDTO responseDTO = new GenericResponseDTO();
        Integer token = Integer.valueOf((int) (Math.random() * 10000));
        user.setToken(token);
        try {
            User savedUser = userRepository.save(user);
            sendEmail(user, token, "Email Verification");
            responseDTO.setMessage("User created successfully");
            responseDTO.setStatus("success");
            responseDTO.setStatusCode(HttpStatus.CREATED.value());
            responseDTO.setData(savedUser);
            return responseDTO;
        } catch (Exception e) {
            responseDTO.setMessage("An error occurred: " + e.getMessage());
            responseDTO.setStatus("error");
            responseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return responseDTO;
        }
    }

    private void sendEmail(User user, Integer token, String subject) {
        Map<String, Object> mailData = Map.of("token", token, "fullName", user.getName());

        rabbitTemplate.convertAndSend(emailExchange, emailRoutingKey, EmailDetailDTO.builder()
                .to(user.getEmail())
                .subject(subject)
                .dynamicValue(mailData)
                .templateName("verification")
                .build());
    }
}