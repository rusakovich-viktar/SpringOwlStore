package by.tms.springstore.service.impl;

import by.tms.springstore.domain.User;
import by.tms.springstore.security.CustomUserDetails;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User wasn't found"));
        return new CustomUserDetails(user);
    }

}
