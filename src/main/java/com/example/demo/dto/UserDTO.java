package com.example.demo.dto;

import com.example.demo.enums.UserRole;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
public class UserDTO {

    @Getter
    @Builder
    @AllArgsConstructor @NoArgsConstructor
    public static class Info {
        private String email;
        private List<UserRole> roles;
        private LocalDateTime createdDate;
    }

    @Getter
    @NoArgsConstructor
    public static class FullInfo extends Info {
        private String password;
        public FullInfo(String email, List<UserRole> roles, String password, LocalDateTime createdDate) {
            super(email, roles, createdDate);
            this.password = password;
        }
    }

    private UserDTO() {}
}
