package LeoVegas.LeoVegasV2.service;

import LeoVegas.LeoVegasV2.entity.User;
import LeoVegas.LeoVegasV2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found, please try again.");
        }
        return new CustomUserDetails(user);
    }
}
