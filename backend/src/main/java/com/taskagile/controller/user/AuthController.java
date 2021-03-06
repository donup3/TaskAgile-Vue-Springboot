package com.taskagile.controller.user;

import com.taskagile.controller.user.dto.UserRequest;
import com.taskagile.controller.user.dto.UserResponse;
import com.taskagile.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRequest.Register request) {
        userService.create(request);
    }

    @PostMapping("/login")
    public UserResponse.Login login(@RequestBody @Valid UserRequest.Login request) {
        return userService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/refreshtoken")
    public UserResponse.Login refreshToken(@RequestBody UserRequest.RefreshToken request){
        return userService.refreshToken(request);
    }
}
