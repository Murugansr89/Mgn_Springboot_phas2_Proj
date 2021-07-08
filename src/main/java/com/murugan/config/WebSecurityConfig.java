package com.murugan.config;
/*
 * package com.kalyan.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * 
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private DataSource dataSource;
 * 
 * @Autowired public void configAuthentication(AuthenticationManagerBuilder
 * auth) throws Exception { System.out.println("Came here...123");
 * 
 * auth.jdbcAuthentication() .dataSource(dataSource) .passwordEncoder(new
 * BCryptPasswordEncoder())
 * .usersByUsernameQuery("select USER_NAME, ENCRYTED_PASSWORD, ENABLED from app_user where USER_NAME=?"
 * )
 * .authoritiesByUsernameQuery("select app_user.USER_NAME, app_role.ROLE_NAME from app_user inner join user_role on app_user.USER_ID = user_role.USER_ID inner join app_role on user_role.ROLE_ID = app_role.ROLE_ID where app_user.USER_NAME=?;"
 * ) ; }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * System.out.println("Came here too..321");
 * 
 * http.authorizeRequests() .anyRequest().authenticated() .and()
 * .formLogin().permitAll() .and() .logout().permitAll(); }
 * 
 * }
 */