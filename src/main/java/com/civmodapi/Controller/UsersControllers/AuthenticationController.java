package com.civmodapi.Controller.UsersControllers;

import com.civmodapi.DTOs.JwtResponseDTO;
import com.civmodapi.DTOs.LoginDTO;
import com.civmodapi.DTOs.RegistrationDTO;
import com.civmodapi.Expection.AppError;
import com.civmodapi.Repository.UserRepository;
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
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;

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
        if(userRepository.findByUsername(body.getUsername()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.CONFLICT.value(), "Username already exists"), HttpStatus.CONFLICT);
        }

        if(Objects.equals(body.getConfirmPassword(), body.getPassword())){
            authenticationService.registerUser(body.getUsername(), body.getPassword());
            return ResponseEntity.ok("AccountCreated");
        } else {
            return new ResponseEntity<>(new AppError(HttpStatus.LOCKED.value(), "The passwords don't match"), HttpStatus.LOCKED);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody LoginDTO body) throws UnsupportedEncodingException {
        if(userRepository.findByUsername(body.getUsername()).isEmpty()){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), "UserName not found"), HttpStatus.NOT_FOUND);
        }
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));
        } catch (BadCredentialsException e){

            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Uncorrected pass"), HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userService.loadUserByUsername(body.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}
