package com.gallegos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    /*
    * By Default, Sprint Security secure all the Rest calls, so we will define the calls to secure
    * Secure -> myAccount, myBalance, myLoans, myCards
    * No Secure -> contact, notices
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(requests -> {
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)
                    requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards"))
                    .authenticated();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)
                    requests.requestMatchers("/notices", "/contact", "/register"))
                    .permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }

    /* Approach 1 where we use withDefaultPasswordEncoder() method while creating the user details
     * Instead of defining a single user inside application.properties, as a next step we can define multiple
     * users along with their authorities with the help of InMemoryUserDetailsManager
     */

    /*@Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }*/

    /* Approach 2 where we create a bean of PasswordEncoder separately
     * Instead of defining a single user inside application.properties, as a next step we can define multiple
     * users along with their authorities with the help of InMemoryUserDetailsManager
     */
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails user = User.withUsername("user")
                .password("12345")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }*/

    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /**
     * NoOpPasswordEncoder is not recommended for production usage.
     * Use only for non-prod.
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
