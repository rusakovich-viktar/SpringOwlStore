package by.tms.springstore.service.impl;

import static by.tms.springstore.utils.Constants.Attributes.NOT_FOUND;

import by.tms.springstore.domain.User;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.security.CustomUserDetails;
import by.tms.springstore.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    private final UserService userService;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User wasn't found"));
//        return new
//
//    CustomUserDetails(user);
//}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findFirstByUsername(username);
        if (user.isPresent()) {
            return new CustomUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("user " + username + NOT_FOUND);
        }
    }

}
