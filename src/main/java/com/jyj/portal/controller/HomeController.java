package com.jyj.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiangyijie on 2018-04-15.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "homepage";
    }
}
