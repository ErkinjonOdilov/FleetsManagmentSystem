package com.kindsonthegenius.fleetmvsv2.security.services;


import com.kindsonthegenius.fleetmvsv2.security.models.User;
import com.kindsonthegenius.fleetmvsv2.security.models.UserPrincipal;
import com.kindsonthegenius.fleetmvsv2.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrincipal(user);
    }
}