package com.example.demo.enums;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 15.
 */
public enum OauthFields {

    NAVER("naver", "id");

    public String registrationId = "";
    public String userAttributesName = "";

    OauthFields(String registrationId, String userAttributesName) {
        this.registrationId = registrationId;
        this.userAttributesName = userAttributesName;
    }
}
