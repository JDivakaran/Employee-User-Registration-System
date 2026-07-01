package com.eurs.project.security;

import com.eurs.project.model.Employee;
import com.eurs.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Login attempt: " + username);

        Employee emp=employeeRepo.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("Not exist"));

        return new User(
                emp.getEmail(),
                emp.getPassword(),
                List.of(new SimpleGrantedAuthority(emp.getRole()))
        );
    }
}
