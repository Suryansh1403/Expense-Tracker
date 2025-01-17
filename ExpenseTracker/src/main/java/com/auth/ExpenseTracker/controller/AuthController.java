package com.auth.ExpenseTracker.controller;

import com.auth.ExpenseTracker.entities.RefreshToken;
import com.auth.ExpenseTracker.model.UserInfoDto;
import com.auth.ExpenseTracker.response.JwtResponseDTO;
import com.auth.ExpenseTracker.service.JwtService;
import com.auth.ExpenseTracker.service.RefreshTokenService;
import com.auth.ExpenseTracker.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController
{

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("auth/v1/signup")
    public ResponseEntity SignUp(@RequestBody UserInfoDto userInfoDto){
        try{

            Boolean isSignUped = userDetailsService.signupUser(userInfoDto);
            if(Boolean.FALSE.equals(isSignUped)){
                return new ResponseEntity<>("Already Exist", HttpStatus.BAD_REQUEST);
            }
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfoDto.getUsername());
            String jwtToken = jwtService.GenerateToken(userInfoDto.getUsername());
          JwtResponseDTO response=  new JwtResponseDTO(jwtToken,
                    refreshToken.getToken());

//return   new ResponseEntity<>(refreshToken.getToken(),HttpStatus.OK);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ex){


            return new ResponseEntity<>("Exception in User Service", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
