package yte.intern.springsecurity;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    public void init(){
        userRepository.save(new Users(null,"user",passwordEncoder.encode("user"), List.of(new Authority(null,"ROLE_USER"))));
        userRepository.save(new Users(null,"admin",passwordEncoder.encode("admin"), List.of(new Authority(null,"ROLE_ADMIN"),new Authority(null,"ROLE_USER"))));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
