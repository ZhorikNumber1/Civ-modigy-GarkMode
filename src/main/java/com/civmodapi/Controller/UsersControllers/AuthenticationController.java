package com.civmodapi.Controller.UsersControllers;

import com.civmodapi.DTOs.JwtResponseDTO;
import com.civmodapi.DTOs.RegistrationDTO;
import com.civmodapi.Expection.AppError;
import com.civmodapi.Service.AuthenticationService;
import com.civmodapi.Service.UserService;
import com.civmodapi.Utils.JwtTokenUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Objects;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private  JwtTokenUtils jwtTokenUtils;
    @Autowired
    private  UserService userService;



    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody RegistrationDTO body) {
      if(Objects.equals(body.getConfirmPassword(), body.getPassword())){

            authenticationService.registerUser(body.getUsername(), body.getPassword());
            return ResponseEntity.ok("AccountCreated");

        }else
            return ResponseEntity.status(HttpStatus.LOCKED).build();

    }
    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody RegistrationDTO body) throws UnsupportedEncodingException {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));
        } catch (BadCredentialsException e){

            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Uncorrected log or pass"), HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userService.loadUserByUsername(body.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}
