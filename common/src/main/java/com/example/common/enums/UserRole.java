package com.example.common.enums;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
public enum UserRole {

    ADMIN ("ADMIN"),
    USER ("USER");

    public String value = "";

    UserRole(String value) { this.value = value; }
}
