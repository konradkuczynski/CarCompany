package carrentalcompany.demo.service;


import carrentalcompany.demo.model.CustomUserDetails;
import carrentalcompany.demo.model.Users;
import carrentalcompany.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> usersOptional = userRepository.findUserByName(username);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("User not find"));

        return usersOptional.map(CustomUserDetails::new).get();
    }
}
