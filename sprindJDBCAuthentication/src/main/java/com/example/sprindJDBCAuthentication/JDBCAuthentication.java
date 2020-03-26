package com.example.sprindJDBCAuthentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class JDBCAuthentication extends WebSecurityConfigurerAdapter{

	 @Autowired
	    private DataSource dataSource;
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	                .jdbcAuthentication()
	                .dataSource(dataSource)
	                .passwordEncoder(new BCryptPasswordEncoder())
	                .usersByUsernameQuery(
	                        "SELECT username, password, enabled from users where username = ?")
	                .authoritiesByUsernameQuery(
	                    "SELECT u.username, a.authority " +
	                    "FROM user_authorities a, users u " +
	                    "WHERE u.username = ? " +
	                    "AND u.id = a.user_id"
	                );
	    }
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * //http.formLogin(); http .authorizeRequests() .antMatchers("/").permitAll()
	 * .antMatchers("/display").hasRole("boss")
	 * .antMatchers("/display1").hasAnyRole("boss","dev")
	 * .antMatchers("/").permitAll();
	 * 
	 * //
	 * http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin()
	 * ; }
	 */
	 
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
}
