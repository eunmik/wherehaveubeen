package com.kong.travel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 소셜 로그인, 일반 로그인 기능을 하는 컨트롤러
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(path="/login/oauth2")
public class LoginController {

    private final HttpSession httpSession;

    @GetMapping(path="/code/kakao")
    public String kakaoLogin(@RequestParam(value="code", required = false)String code) throws Exception{
        System.out.println("######"+code);
        return code;
    }

    @GetMapping(path="/code/google")
    public String googleLogin(@RequestParam(value="state", required = false)String state,
                            @RequestParam(value="scope", required = false) String scope,
                            @RequestParam(value="code", required =  false) String code,
                            @RequestParam(value="authuser", required = false) String authuser,
                            @RequestParam(value="prompt", required = false) String consent){
        System.out.println("############################");
        System.out.println(code);
        System.out.println("############################");
        return "hello";
    }

    @GetMapping(path="/")
    public void Login(String code){
        System.out.println("############################"+code);
    }









}
