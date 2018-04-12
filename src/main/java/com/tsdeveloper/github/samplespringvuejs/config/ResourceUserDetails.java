package com.tsdeveloper.github.samplespringvuejs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceUserDetails extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.headers().frameOptions().disable().and()
                .authorizeRequests()
                .antMatchers("/","/home","/register","/login").permitAll()
                .antMatchers("/private/**").authenticated();
    }

}
