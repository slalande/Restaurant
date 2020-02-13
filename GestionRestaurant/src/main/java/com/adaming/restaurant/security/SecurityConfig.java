package com.adaming.restaurant.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasourceBean;
		
	
	public DataSource getDatasourceBean() {
		return datasourceBean;
	}

	public void setDatasourceBean(DataSource datasourceBean) {
		this.datasourceBean = datasourceBean;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasourceBean).usersByUsernameQuery("select username,password,activated from users where username=?")
		.authoritiesByUsernameQuery("select u.username, r.rolename from users u, roles r where u.iduser = r.iduser and u.username =? "); 
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().and().authorizeRequests().antMatchers("/Client/Ajout").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Client/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Client/MAJ").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Client/All").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Plat/Ajout").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Plat/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Plat/MAJ").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Plat/All").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Menu/Ajout").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Menu/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Menu/MAJ").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Menu/All").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Reservation/Ajout").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Reservation/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Reservation/MAJ").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Reservation/All").permitAll();		
		http.httpBasic().and().authorizeRequests().antMatchers("/User/Ajout").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/User/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/User/MAJ").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/User/All").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Role/Ajout").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Role/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Role/MAJ").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Role/All").permitAll();
		http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username")
		.defaultSuccessUrl("/home").failureUrl("/erreur");
		http.logout().logoutSuccessUrl("/");
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
