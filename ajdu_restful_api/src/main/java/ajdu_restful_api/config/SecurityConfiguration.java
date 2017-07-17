package ajdu_restful_api.config;


import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				//.passwordEncoder(passwordEncoder())
				.usersByUsernameQuery(
					"SELECT login as username, password, active FROM user where login=?"
				 )
				.authoritiesByUsernameQuery(
					"SELECT user.login as username, user_role.role as user_role from user INNER JOIN user_role on user.id=user_role.user_id where user.login=?"
				 )
				.and()
				.inMemoryAuthentication()
					.withUser("user").password("password").roles("REG_USER").and()
					.withUser("test").password("test").roles("ADMIN");
		
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(
						"SELECT login as username, password, active FROM organization where login=?"
				)
				.authoritiesByUsernameQuery("SELECT organization.login as username, 'REG_USER' as user_role from organization where organization.login=?"
						 );
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
						.cors();
		httpSecurity
						.authorizeRequests()
						.antMatchers(HttpMethod.POST, "/users").anonymous()
						.antMatchers(HttpMethod.POST, "/orgs").anonymous()
						.antMatchers(HttpMethod.GET, "/orgs").authenticated()
						.antMatchers(HttpMethod.POST, "/*").authenticated()
						.antMatchers(HttpMethod.GET, "/*").access("hasAuthority('ADMIN')")
						.antMatchers("/*/**").access("hasAnyAuthority('ADMIN','REG_USER')")
						.and()
						.httpBasic();
		httpSecurity
						.csrf().disable();		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
}
