package net.nalpari.adminweb.controller;

import net.nalpari.admin.entity.Sample;
import net.nalpari.admin.entity.User;
import net.nalpari.adminweb.service.FeignUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc :
 * @FileName : TestController.java
 * @Project : cloudpack
 * @Date : 2019-03-19
 * @Author : yoosw@3top.co.kr
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final FeignUserService feignUserService;

    public TestController(FeignUserService feignUserService) {
        this.feignUserService = feignUserService;
    }

    @GetMapping(value = {"/", ""})
    public Sample index() {
        return new Sample("test");
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
//        User result = new User("test", "test@abc.co.kr");
//        return result;
        return feignUserService.getUser(id);
    }

    @GetMapping("/user/spc")
    public User getSpcUser() {
        return feignUserService.getSpcUser();
    }
}
