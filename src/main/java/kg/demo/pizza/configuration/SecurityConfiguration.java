package kg.demo.pizza.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }


    @Autowired
    private DataSource dataSource;

    // @Value("${spring.queries.users-query}")
    //private String clientsQuery;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        //auth.jdbcAuthentication().usersByUsernameQuery(clientsQuery)
        //      .dataSource(dataSource)
        //    .passwordEncoder(bCryptPasswordEncoder);
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("admin").password("123").authorities("ADMIN")
                .and()
                .withUser("user").password("456").authorities("USER")
                .and()
                .withUser("jamka").password("254336").authorities("JAMKA")
                .and()
                .withUser("").password("").authorities("");


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ADMIN").
                anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/fonts/**", "/fonts/font-awesome/**", "/images/**");
    }

}