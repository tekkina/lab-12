package edu.miu.e_registrar.service.imp;


import edu.miu.e_registrar.model.User;
import edu.miu.e_registrar.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class E_registrarUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public E_registrarUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findUserByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s is not found!", username))
                    );
            return user;
        }
    }


