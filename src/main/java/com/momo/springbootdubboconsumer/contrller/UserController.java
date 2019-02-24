package com.momo.springbootdubboconsumer.contrller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.momo.springbootdubboapi.UserService;
import com.momo.springbootdubboapi.po.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author MQG
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:20880")
    private UserService userService;

    @GetMapping("/sayHello")
    public void sayHello(@RequestParam String name) {
        userService.sayHello(name);
    }

    @GetMapping("/findById/{id}")
    public User sayHello(@PathVariable Integer id) {
        return userService.findById(id);
    }
}
