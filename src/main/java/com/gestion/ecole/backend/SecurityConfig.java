package com.gestion.ecole.backend;

import com.gestion.ecole.backend.models.securityModels.Utilisateur;
import com.gestion.ecole.backend.service.securityService.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CompteService compteService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(new UserDetailsService() {
                    @Override
                    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                        Utilisateur utilisateur = compteService.getUserByUsername(username);

                        List<GrantedAuthority> authorities = new ArrayList<>();

                        utilisateur.getRolesList()
                                .forEach(
                                        roles -> authorities.add(new SimpleGrantedAuthority(roles.getRoleName()))
                                );

                        System.out.println(utilisateur.getUsername()+","+utilisateur.getPassword()+","+authorities);

                        return new User(utilisateur.getUsername(),utilisateur.getPassword(),authorities);


                    }
                });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http
                .authorizeRequests().antMatchers("/api/**").hasRole("ADMIN")
                .antMatchers("/api/emploi_temps/id/{id}").hasRole("PROFESSEUR")
                .antMatchers("/api/eleves/all").hasRole("PROFESSEUR")
                .antMatchers("/api/controles/create").hasRole("PROFESSEUR")
                .antMatchers("/api/emploi_temps/id/{id}").hasRole("ETUDIANT")
                .antMatchers("/api/controles/id/{id}").hasRole("ETUDIANT")
                .antMatchers("/api/absences_eleves/id/{id}").hasRole("ETUDIANT")
                .antMatchers("/api/retards_eleves/id/{id}").hasRole("ETUDIANT")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

}
