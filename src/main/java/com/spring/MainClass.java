package com.spring;

import com.spring.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MainClass {
    @Autowired
    static RestTemplate restTemplate;

    public static void main(String[] args) {
        getData();
        //getDataById(1);
        LoginUser loginUser=new LoginUser();
        loginUser.setEmail("kushi@123");
        loginUser.setPassword("kushi");
        //postData(loginUser);
        loginUser.setEmail("chinu@123");
        loginUser.setPassword("chinu");
       // postData(loginUser);
        //update(3,loginUser);
        //delete(3);
    }

    public static void getData() {
        String findAll = "http://localhost:9091/login";
        restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(findAll, String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }
    public static void getDataById(int id) {
        String findById = "http://localhost:9091/login/"+id;
        restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(findById, String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }
    public static void postData(LoginUser loginUser) {
        String update = "http://localhost:9091/login";
        restTemplate = new RestTemplate();
        ResponseEntity<LoginUser> responseEntity=restTemplate.postForEntity(update, loginUser,LoginUser.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }
    public static void update(int id,LoginUser loginUser) {
        String updateById = "http://localhost:9091/login/"+id;
        restTemplate = new RestTemplate();
        HttpEntity<LoginUser> httpEntity = new HttpEntity<>(loginUser);
        ResponseEntity<Integer> responseEntity=restTemplate.exchange(updateById, HttpMethod.PUT,httpEntity,Integer.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }
    public static void delete(int id) {
        String findById = "http://localhost:9091/login/"+id;
        restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity=restTemplate.exchange(findById,HttpMethod.DELETE,null,Integer.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }
}
