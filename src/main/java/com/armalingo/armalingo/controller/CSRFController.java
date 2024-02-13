package com.armalingo.armalingo.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSRFController {

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(CsrfToken csrfToken) {
        return csrfToken;
    }


}
