package security.securityserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import security.securityserver.service.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserDetailsServiceImp userDetailsServiceImp) throws Exception {
        return httpSecurity
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(ar -> ar
                        .requestMatchers("/auth/addUser", "/auth/addRole", "/auth/addRoleUser","/registration/appuser", "auth/login","/swagger-ui/**","/v3/api-docs/**","/swagger-ui.html/**").permitAll()
                        .anyRequest().authenticated()
                )

                .oauth2ResourceServer(oa -> oa.jwt(Customizer.withDefaults()))
                .userDetailsService(userDetailsServiceImp)
                .build();
    }


}



