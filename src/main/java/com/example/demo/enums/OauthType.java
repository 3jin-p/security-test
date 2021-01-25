package com.example.demo.enums;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 25.
 */
public enum OauthType {

    GOOGLE("google"),
    KAKAO("kakao"),
    NAVER("naver");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    OauthType(String name) { this.name = name; }
    public String getRoleType() {
        return ROLE_PREFIX + name.toUpperCase();
    }
    public String getValue() {
        return name;
    }
    public boolean isEquals(String authority) {
        return this.getRoleType().equals(authority);
    }


}
