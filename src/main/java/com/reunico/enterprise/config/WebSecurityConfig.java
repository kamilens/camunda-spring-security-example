package com.reunico.enterprise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.ldap.userIdAttribute}")
    private String userIdAttribute;
    @Value("${spring.ldap.groupSearchFilter}")
    private String groupSearchFilter;
    @Value("${spring.ldap.userSearchBase}")
    private String userSearchBase;
    @Value("${spring.ldap.groupSearchBase}")
    private String groupSearchBase;
    @Value("${spring.ldap.urls}")
    private String url;
    @Value("${spring.ldap.base}")
    private String base;
    @Value("${spring.ldap.username}")
    private String managerDn;
    @Value("${spring.ldap.password}")
    private String managerPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().ignoringAntMatchers("/camunda/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .ldapAuthentication()
                    .userSearchFilter("(" + userIdAttribute + "={0})")
                    .userSearchBase(userSearchBase + "," + base)
                    .groupSearchBase(groupSearchBase + "," + base)
                    .groupSearchFilter(groupSearchFilter)
                    .contextSource()
                        .url(url)
                        .managerDn(managerDn)
                        .managerPassword(managerPassword);
    }
}
