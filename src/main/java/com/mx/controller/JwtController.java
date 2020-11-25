package com.mx.controller;

import com.mx.model.AuthenticationResponse;
import com.mx.ults.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class JwtController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService myUserDetailsService;

    @RequestMapping(value = "/jwt", method = RequestMethod.POST)
    public ResponseEntity<?> generateJwt()   {
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername("");
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
