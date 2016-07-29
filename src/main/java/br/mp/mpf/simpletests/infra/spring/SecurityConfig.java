package br.mp.mpf.simpletests.infra.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("joao").password("123456").roles("USER");
	auth.inMemoryAuthentication().withUser("maria").password("qwerty").roles("USER");
	auth.inMemoryAuthentication().withUser("jose").password("abcdef").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.authorizeRequests().antMatchers("/resources/**").permitAll();
	http.authorizeRequests().anyRequest().authenticated();
	http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/app/index.html");

	http.logout().logoutSuccessUrl("/login");
    }

}
