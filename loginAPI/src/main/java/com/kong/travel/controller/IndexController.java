package com.kong.travel.controller;

import com.kong.travel.entities.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(){

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        System.out.println(user.getEmail())
        ;

        return "redirect:/haha";
    }

    @RequestMapping("callback")
    public String callback() {
        System.out.println("######################working##############");

        return "redirect:/";
    }

}
