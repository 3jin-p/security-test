package com.example.auth.rest.dto;

import com.example.common.enums.UserRole;
import lombok.*;

import java.time.LocalDateTime;
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

    private UserDTO() {}
}
