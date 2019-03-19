package net.nalpari.adminweb.controller;

import net.nalpari.admin.entity.Sample;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value = {"/", ""})
    public Sample index() {
        return new Sample("test");
    }
}
