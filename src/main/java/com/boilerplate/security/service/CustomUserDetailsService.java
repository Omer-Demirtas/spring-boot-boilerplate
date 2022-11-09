package com.boilerplate.security.service;

/*
import com.boilerplate.domain.User;
import com.boilerplate.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService
{
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = personRepository.findByUsername(username);
        return JWTUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id)
    {
        User user = personRepository.findById(id).get();
        return JWTUserDetails.create(user);
    }
}
*/