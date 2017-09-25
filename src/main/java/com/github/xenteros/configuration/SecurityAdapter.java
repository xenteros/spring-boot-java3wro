package com.github.xenteros.configuration;

import com.github.xenteros.enums.Authority;
import com.github.xenteros.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by agurgul on 25.09.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api/users").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/hello").permitAll()
                .antMatchers("/hello-user").authenticated()
                .antMatchers("/admin.html").hasAuthority(Authority.ADMIN.getAuthority())
                .antMatchers("/user.html").hasAuthority(Authority.USER.getAuthority())
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();
        http.httpBasic();

        http
                .formLogin()
                .loginPage("/api/login")
                .failureHandler((request, response, exception) -> response.sendError(HttpStatus.BAD_REQUEST.value(), "Username or password invalid"))
                .usernameParameter("user")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello").permitAll();

        http
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/hello");
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN")
//                .and()
//                .withUser("user").password("user").roles("USER");
//    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }


}
