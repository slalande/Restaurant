package com.adaming.myapp.security;

import javax.sql.DataSource;

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
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/Ajout").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/All").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/Matiere/Ajout").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Matiere/Supprimer").hasAuthority("Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Matiere/All").permitAll();
		http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username")
		.defaultSuccessUrl("/index").failureUrl("/erreur");
		
	}

}
