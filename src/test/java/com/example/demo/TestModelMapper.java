package com.example.demo;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@SpringBootTest
public class TestModelMapper {

    @Autowired
    ModelMapper defaultModelMapper;

    @Test
    public void testDefaultModelMapper() {
        User user = User.builder()
                .email("email")
                .password("password")
                .roles(Collections.singletonList(UserRole.USER))
                .build();

        UserDTO.Info userDTO_Info = defaultModelMapper.map(user, UserDTO.Info.class);
        UserDTO.FullInfo userDTO_full_Info = defaultModelMapper.map(user, UserDTO.FullInfo.class);

        assert userDTO_Info.getEmail().equals("email");
        assert userDTO_Info.getRoles().get(0) == UserRole.USER;

        assert userDTO_full_Info.getEmail().equals("email");
        assert userDTO_full_Info.getRoles().get(0) == UserRole.USER;
        assert userDTO_full_Info.getPassword().equals("password");
    }
}
