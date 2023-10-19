package yte.intern.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
//    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,CustomUserDetailsService userDetailsService) throws Exception {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("user")
//                .authorities("ROLE_USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("admin")
//                .authorities("ROLE_ADMIN")
//                .build();
//
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//                .inMemoryAuthentication()
//                .withUser(user)
//                .withUser(admin)



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(new AntPathRequestMatcher("/logim")).permitAll()
                        .anyRequest().authenticated())
               // .requestMatchers(AntPathRequestMatcher.antMatcher("/user")).hasAnyRole("USER","ADMIN")
               // .requestMatchers(AntPathRequestMatcher.antMatcher("/admin")).hasRole("ADMIN")

                .formLogin(formLogin -> formLogin.disable())
                .logout(logout -> logout.disable())
                .csrf(csrf -> csrf.disable()) //postmanda post isteği atarken sıkıntı çıkmasın diye
                // normalde başka sitelerden gelehn ve bizden geliyo gibi görünen post isteklerini engelliyor ama localde işimize yaramıyor
//                .and()
//                .formLogin()
//                .and()
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(CustomAuthenticationProvider customAuthenticationProvider){
        return new ProviderManager(customAuthenticationProvider);
    }


}
