package com.idukelu.demo.demofeignclient.business.service;

import com.idukelu.demo.demofeignclient.business.pojo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("demo-eureka-client")
public interface FeignService {

    @PostMapping("/eurekasvr")
    ResponseEntity<?> createUser(@RequestBody User user) throws Exception;

    @DeleteMapping("/eurekasvr/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") String id) throws Exception;

    @PutMapping("/eurekasvr")
    ResponseEntity<?> updateUser(@RequestBody User user) throws Exception;

    @GetMapping(value = "/eurekasvr")
    ResponseEntity<?> getUser(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "username", required = false) String username) throws Exception;
}
