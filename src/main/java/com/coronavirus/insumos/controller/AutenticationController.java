package com.coronavirus.insumos.controller;

import com.coronavirus.insumos.dto.BaseDTO;
import com.coronavirus.insumos.dto.UserDto;
import com.coronavirus.insumos.repository.UserRepository;
import com.coronavirus.insumos.service.BaseService;
import com.coronavirus.insumos.service.UserService;
import com.coronavirus.insumos.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;


@RestController(value = "/users")
public class AutenticationController {

    @Autowired
    private UserService usersRepositoris;

    public User toEntity(UserDto dto, String password){
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(password);
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setEntity(dto.getEntity());
        user.setPosition(dto.getPosition());
        user.setLocation(dto.getLocation());
        return user;
    }

    public UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFullname(user.getFullname());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setEntity(user.getEntity());
        dto.setPosition(user.getPosition());
        dto.setLocation(user.getLocation());
        return dto;
    }

    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<UserDto> register(@RequestBody UserDto dto,@PathVariable("password") String password){
        User entity = toEntity(dto,password);
        User saved = usersRepositoris.create(entity);
        return new ResponseEntity<UserDto>(toDto(saved), HttpStatus.CREATED);
    }

    @PostMapping(value = "/logIn")
    public @ResponseBody ResponseEntity<UserDto> logIn(@RequestBody UserDto dto,@PathVariable("password") String password){
        User entity = toEntity(dto,password);
        User saved = usersRepositoris.create(entity);
        return new ResponseEntity<UserDto>(toDto(saved), HttpStatus.OK);
    }

    @PostMapping(value = "/logOut")
    public @ResponseBody ResponseEntity<UserDto> logOut(@RequestBody UserDto dto,@PathVariable("password") String password){
        User entity = toEntity(dto,password);
        User saved = usersRepositoris.create(entity);
        return new ResponseEntity<UserDto>(toDto(saved), HttpStatus.OK);
    }


}
