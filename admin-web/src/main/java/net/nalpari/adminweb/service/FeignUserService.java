package net.nalpari.adminweb.service;

import net.nalpari.admin.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Desc :
 * @FileName : FeignUserService.java
 * @Project : cloudpack
 * @Date : 2019-03-20
 * @Author : yoosw@3top.co.kr
 */
@FeignClient(name = "apiuser")
public interface FeignUserService {
    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);

    @GetMapping("/user/spc")
    User getSpcUser();
}
