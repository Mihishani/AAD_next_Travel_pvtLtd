package lk.ijse.gdse63.aad.user_authorized_service.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.user_authorized_service.entity.User;
import lk.ijse.gdse63.aad.user_authorized_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findByUserName(username);
        return user.isPresent()? user.get():user.orElseThrow(()->new UsernameNotFoundException("User Not found!"));
    }
}
