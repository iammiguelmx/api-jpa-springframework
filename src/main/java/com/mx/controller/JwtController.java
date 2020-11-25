package com.mx.controller;

import com.mx.model.AuthenticationResponse;
import com.mx.ults.JwtUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(tags = "JWT", description = "Enpoint for generate JWT")
public class JwtController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService myUserDetailsService;

    @RequestMapping(value = "/jwt", method = RequestMethod.POST)
    public ResponseEntity<?> generateJwt()   {
        //TODO: Refactor loadUserByUsername.
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername("MIKE");
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
