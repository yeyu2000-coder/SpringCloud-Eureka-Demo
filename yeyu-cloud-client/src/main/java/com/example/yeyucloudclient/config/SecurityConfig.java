package com.example.yeyucloudclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf防护
        http.csrf().disable();


        //登录
        http.formLogin()
                .loginPage("/toLogin")//用户未登录时，访问其他资源都会跳转至该页面
                .loginProcessingUrl("/toLogin")//登录表单form中action的地址，也就是处理认证请求的路径
                .usernameParameter("name")//登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("pwd")//登录表单form中密码输入框input的name名，不修改的话默认是password
//                .successForwardUrl("/welcome")//登录成功后跳转至该页面,controller有特殊情况时会报错，需要重定向redirect:/，不建议使用
                .defaultSuccessUrl("/welcome",true)//登录认证成功后跳转至请求的url界面，如果该界面不存在则返回/welcome
                .permitAll()

                .and().authorizeRequests()//请求授权

                .antMatchers("/welcome").permitAll()//放行/welcome请求,不需要认证
                .antMatchers("/druid/**").permitAll()//放行druid监控，不需要认证

//                 hasAuthority和hasRole用法相同，区别在于hasRole，框架会自动加上前缀“ROLE_”
//                .antMatchers("/welcome").hasAuthority("adimin")//基于单权限
//                .antMatchers("/welcome").hasAnyAuthority("adimin","vip1","vip2","...")//基于多权限

//                .antMatchers("/welcome").hasRole("A")//基于单角色，自动加上 “ROLE_”
//                .antMatchers("/welcome").hasAnyRole("A","B","...")//基于多角色

//                .antMatchers("/welcome").hasIpAddress("192.168.0.0")//基于IP地址

//                .antMatchers("/css/**","/js/**","/images/**").permitAll()//放行静态资源
//                .antMatchers("/**/*.png").permitAll()//放行后缀.png

//                .regexMatchers(".+[.]png").permitAll()//正则表达式，放行后缀.png

                .anyRequest().authenticated()//任何请求都必须认证才能访问，必须登录
                .and();

    }
}
