package com.kong.travel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
@EnableWebSecurity //웹보안 활성화를 위한 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http //인가정책
                .authorizeRequests() //요청에 대한 보안 검색을 하고
                .anyRequest().authenticated(); //어떤 인증에도 보안을 받도록 설정

        http //인증정책
                .formLogin() //formLogin방식으로 인증을 할 수 있도록 설정
                //.loginPage("/loginPage")
                .defaultSuccessUrl("/") //인증에 성공했을 때 이동되는 URL
                .failureUrl("/login") //인증에 실패 했을 때
                .usernameParameter("userId") //parameter 항목 필드 명을 변경, default 는 username
                .passwordParameter("pwd") //default는 password
                .loginProcessingUrl("/login_proc") //form태그의 action url, default는 login
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        //Authentication : 인증에 성공했을 때 최종적으로 인증한 결과 까지 담은 인증객체
                        System.out.println("authentication : " + authentication.getName()); //인증 성공한 사용자 이름을 출력
                        httpServletResponse.sendRedirect("/");
                    }
                }) //login에 성공 했을 때 successHandler를 호출, AuthenticationSuccessHandler 인터페이스를 구현한 구현체를 설정하면 된다.

                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        //AuthenticationException : 인증 예외의 객체를 파라미터로 넘겨 주고 있다.
                        System.out.println("exception : "+ e.getMessage());
                        httpServletResponse.sendRedirect("/login");
                    }
                })
                .permitAll() //loginPage로 접근하는 모든 사용자는 접근이 가능하도록
            .and()
                .rememberMe()
                .rememberMeParameter("remember") //remember parameter를 설정, default는 remember-me
                .tokenValiditySeconds(3600) //1시간
                .userDetailsService(userDetailsService)  //user계정을 rememberMe 설정시 처리하는 과정이 있는데 그 처리를 위해 필요한 클래스가 UserDetailsService
        ;

        http
                .logout()
                .logoutUrl("/logout") //default는 logout, Spring Security는 logout 처리를 할때 기본적으로 POST방식을 사용, GET방식으로 로그아웃을 구현하게 되면 오류를 발생
                .logoutSuccessUrl("/login")
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
                        HttpSession session = httpServletRequest.getSession();
                        session.invalidate(); //세션을 무효화
                    }
                }) //실제로 logout을 처리를 하는 logout handler가 있는데 다른 작업을 원할 때 직접 logouthandler interface를 구현할 수 있다.
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.sendRedirect("/login");
                    }
                }) //로그아웃이 성공하면 그 다음 수행할 작업, logoutSuccessUrl은 페이지만 이동하고 Handler는 다양한 더 많은 로직 구현 가능
                .deleteCookies("remember-me") //인증을 할때 서버에서 "remember-me" 쿠키를 발행한다. 로그아웃할 때 server에서 만든 쿠키를 삭제한다.
                ;
    }
}
