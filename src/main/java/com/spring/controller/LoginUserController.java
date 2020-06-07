package com.spring.controller;

import com.spring.model.LoginUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginUserController {
     private RestTemplate  restTemplate;
    @GetMapping("/login")
    public ResponseEntity<LoginUser[]>  getData() {
        String findAll = "http://localhost:9091/login";
        restTemplate = new RestTemplate();
       return restTemplate.getForEntity(findAll, LoginUser[].class);
    }
    @GetMapping("/login/{id}")
    public  ResponseEntity<LoginUser> getDataById(@PathVariable int id) {
        String findById = "http://localhost:9091/login/"+id;
        restTemplate = new RestTemplate();
       return restTemplate.getForEntity(findById, LoginUser.class);
    }
    @PostMapping("/login")
    public  ResponseEntity<LoginUser> postData(LoginUser loginUser) {
        String update = "http://localhost:9091/login";
        restTemplate = new RestTemplate();
        return restTemplate.postForEntity(update, loginUser,LoginUser.class);
    }
    @PutMapping("/login/id")
    public  ResponseEntity<Integer> update(@PathVariable("id")int id, @RequestBody LoginUser loginUser) {
        String updateById = "http://localhost:9091/login/"+id;
        restTemplate = new RestTemplate();
        HttpEntity<LoginUser> httpEntity = new HttpEntity<>(loginUser);
        return restTemplate.exchange(updateById, HttpMethod.PUT,httpEntity,Integer.class);
    }
    @DeleteMapping("login/id")
    public  ResponseEntity<Integer> delete(int id) {
        String findById = "http://localhost:9091/login/"+id;
        restTemplate = new RestTemplate();
        return restTemplate.exchange(findById,HttpMethod.DELETE,null,Integer.class);
    }
}
