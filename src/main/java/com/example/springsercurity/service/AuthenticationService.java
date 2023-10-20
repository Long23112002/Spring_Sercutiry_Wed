package com.example.springsercurity.service;

import com.example.springsercurity.auth.AuthenticationRequest;
import com.example.springsercurity.auth.AuthenticationResponse;
import com.example.springsercurity.entity.Role;
import com.example.springsercurity.entity.User;
import com.example.springsercurity.repository.RoleCustomRepo;
import com.example.springsercurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final RoleCustomRepo roleCustomRepo;

    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        User user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        List<Role> role = null;
        if(user != null){
            role = roleCustomRepo.getRole(user);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> set = new HashSet<>();
        role.stream().forEach(c ->set.add(new Role(c.getName())));
        user.setRoles(set);
        set.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
        var jwtToken = jwtService.generateToken(user,authorities);
        var refreshToken = jwtService.generateRefreshToken(user,authorities);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(refreshToken).build();
    }
}
