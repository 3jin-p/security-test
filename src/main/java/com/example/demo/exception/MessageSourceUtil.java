package com.example.demo.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * <b>
 *   MessageSource에 접근하는 유틸리티
 *   Bean 으로 등록하여 사용
 * /b>
 *
 * @author sejinpark
 * @since 21. 1. 15.
 */
@Component
@RequiredArgsConstructor
public class MessageSourceUtil {

    private final MessageSource messageSource ;
    private final String EMPTY_MSG = "";

    public String getMessage(String key) {
        String msg = messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        if(!isValid(key, msg)) {
            return EMPTY_MSG;
        }
        return msg;
    }

    /**
     *  YamlMessageSource 의 문제.
     *  key가 없을때 Exception 이 아닌 key를 메시지로 반환하는 문제 때문에 검증과정을 거친다.
     *
     * @param key
     * @param msg
     * @return
     */
    private boolean isValid(String key, String msg) {
        if(msg.equals(key)) {
            return false;
        }
        return true;
    }
}
