package org.example.p_be.controllers;


import org.example.p_be.config.service.JwtResponse;
import org.example.p_be.config.service.JwtService;
import org.example.p_be.config.service.UserService;
import org.example.p_be.models.Course;
import org.example.p_be.models.OrderCourse;
import org.example.p_be.models.User;
import org.example.p_be.services.ICartService;
import org.example.p_be.services.ICourseService;
import org.example.p_be.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private ICourseService iCourseService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String a = "aa";
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        System.out.println("kk " + currentUser);
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo(@RequestHeader("Authorization")String token) {
        String newToken = token.substring(7);
        String userName = jwtService.getUsernameFromJwtToken(newToken);
        System.out.println(userName);
        return ResponseEntity.ok(userName);
    }

    @GetMapping("/getInfoCart")
    public ResponseEntity<?> getInfoAndCart(@RequestHeader("Authorization")String token) {
        String newToken = token.substring(7);
        String userName = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(userName);
        List<Course> courses = iCourseService.findAllCartByIdCustomer(user.getCustomer().getId());
        Integer size = courses.size();
        String result = userName + "," + size;
        System.out.println(userName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutSuccessful(){
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("ok dang xuat");
    }

}
