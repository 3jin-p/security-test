package com.example.auth.web.rest.dto;

import com.example.common.enums.UserRole;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
        private Set<UserRole> roles;
        private LocalDateTime createdDate;
    }

    private UserDTO() {}
}
