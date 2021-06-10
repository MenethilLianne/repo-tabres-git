package com.test.spring.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
/*Creating Spring Security Java Configuration
 * This config creates a Servlet Filter, which is
 * responsible for all the app security
 * (protecting app URLs, validation submited username and passwords, 
 * redirecting to the login form)*/
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	PersistentTokenRepository tokenRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsService);
			authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
			auth.authenticationProvider(authenticationProvider());
		
	}
	/*Allows foreasily building in memory authentication,
	 *LDAP authentication, JDBC basedauthentication, adding UserDetailsService,
	 *and adding AuthenticationProvider's.*/
	
	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedService = new PersistentTokenBasedRememberMeServices("remember-me", userDetailsService, tokenRepository);
		return tokenBasedService;
	}
	/*There is a slight modification to the described approach, in that the username is notstored 
	 *as part of the cookie but obtained from the persistent store via animplementation of PersistentTokenRepository*/
	
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {	
		return new AuthenticationTrustResolverImpl();
	}
	/*Evaluates Authentication tokens
	 *Makes trust decisions based on whether the passed Authentication 
	 *is aninstance of a defined class. */
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/list")
                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
                .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
	/* �?/’ & �?/list’ : Accessible to everyone
	 * �?/newuser’ & �?/delete-user-*’ : Accessible only to Admin
	 * �?/edit-user-*’ : Accessible to Admin & DBA */
}
