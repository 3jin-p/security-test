package com.example.auth.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 25.
 */
@Controller
public class LoginController {

    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "/page/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/page/login";
    }

    @GetMapping({"/loginSuccess"})
    public String loginSuccess() {
        return "/page/success";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "/page/loginFailure";
    }
}
