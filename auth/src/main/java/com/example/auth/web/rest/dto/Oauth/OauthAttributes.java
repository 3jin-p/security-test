package com.example.auth.web.rest.dto.Oauth;

import com.example.common.enums.OauthFields;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;


/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 15.
 */
@Getter
@Builder
@AllArgsConstructor
public class OauthAttributes {
    String name;
    String email;
    String profileImage;
    Map<String, Object> attributes;
    String nameAttributeKey;

    public static OauthAttributes of(
            String registrationId
            , String userNameAttributeName
            , Map<String, Object> attributes) {
        if(OauthFields.NAVER.registrationId.equals(registrationId)) {
            return ofNaver(OauthFields.NAVER.userAttributesName, attributes); // Naver 는 userNameAttributeName
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OauthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OauthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .profileImage((String) response.get("profileImage"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OauthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return null;
    }

}
