package com.ericsson.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {

    @RequestMapping("/param")
    public String param(

            @RequestParam(defaultValue = "anonymous") String username,
            @RequestParam(defaultValue = "20")        int age,
            @RequestHeader("user-agent")              String userAgent

    ) {

        System.out.println(username);
        System.out.println(userAgent);

        if(checkAge(age)) {
            System.out.println(age);
        } else {
            System.out.println("bad age");
        }

        return "paramView";
    }

    private boolean checkAge(int age) {
        return age > 0 ? true : false;
    }

}
