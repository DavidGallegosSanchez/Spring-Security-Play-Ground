package com.gallegos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    /*
    * By Default, Sprint Security secure all the Rest calls, so we will define the calls to secure
    * Secure -> myAccount, myBalance, myLoans, myCards
    * No Secure -> contact, notices
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> {
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)
                    requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards"))
                    .authenticated();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)
                    requests.requestMatchers("/notices", "/contact"))
                    .permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();

        // We can deny all the requests coming towards our web application APIs, Paths using Spring Security framework
        /*http.authorizeHttpRequests(requests ->
            requests.anyRequest().denyAll()
        );
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();*/

        // We can permit all the request coming towards our web applications APIs, Path using Spring Security framework
        /*.authorizeHttpRequests(requests ->
                requests.anyRequest().permitAll()
        );
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();*/
    }
}
