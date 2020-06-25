package com.coronavirus.insumos.controller;

import com.coronavirus.insumos.dto.LogInDto;
import com.coronavirus.insumos.dto.SingUpDto;
import com.coronavirus.insumos.dto.UserDto;
import com.coronavirus.insumos.service.UserService;
import com.coronavirus.insumos.users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;


@RestController
@RequestMapping("/autentication")
public class AutenticationController {

    @Autowired
    private UserService usersRepositoris;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User toEntity(SingUpDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setEntity(dto.getEntity());
        user.setPosition(dto.getPosition());
        user.setLocation(dto.getLocation());
        return user;
    }

    public UserDto toDto(User user){
        UserDto dto =
                new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFullname(user.getFullname());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setEntity(user.getEntity());
        dto.setPosition(user.getPosition());
        dto.setLocation(user.getLocation());
//        new ObjectMapper().readValue(user, UserDto.class)
        return dto;
    }

    @PostMapping(value = "/singUp")
    public @ResponseBody ResponseEntity<UserDto> singUp(@RequestBody SingUpDto dto){
        if(usersRepositoris.findByEmail(dto.getEmail()) != null){
            return new ResponseEntity("User Already exist",HttpStatus.BAD_REQUEST);
        }
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        User entity = toEntity(dto);
        User saved = usersRepositoris.create(entity);
        return new ResponseEntity(toDto(saved), HttpStatus.CREATED);
    }

    @PostMapping(value = "/logIn")
    public @ResponseBody ResponseEntity logIn(@RequestBody LogInDto user){
        return new ResponseEntity("LogIn Successful",HttpStatus.OK);
    }


}
