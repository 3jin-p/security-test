package com.example.demo.view;

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

    @GetMapping("/page/login")
    public String login() {
        return "login";
    }
}
