package com.idukelu.demo.demofeignclient.business.service;

import com.idukelu.demo.demofeignclient.business.pojo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "demo-eureka-client", fallback = FeignServiceFallback.class)
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

class FeignServiceFallback implements FeignService{

    public ResponseEntity<?> createUser(User user) throws Exception {
        return ResponseEntity.ok("创建用户失败！！！");
    }

    public ResponseEntity<?> deleteUser(String id) throws Exception {
        return ResponseEntity.ok("删除用户失败！！！");
    }

    public ResponseEntity<?> updateUser(User user) throws Exception {
        return ResponseEntity.ok("更新用户失败！！！");
    }

    public ResponseEntity<?> getUser(String id, String username) throws Exception {
        return ResponseEntity.ok("查询用户失败！！！");
    }
}