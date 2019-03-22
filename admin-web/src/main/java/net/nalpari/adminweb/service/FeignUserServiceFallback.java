package net.nalpari.adminweb.service;

import net.nalpari.admin.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Desc :
 * @FileName : FeignUserServiceFallback.java
 * @Project : cloudpack
 * @Date : 2019-03-22
 * @Author : yoosw@3top.co.kr
 */
@Component
public class FeignUserServiceFallback implements FeignUserService {
    @Override
    public User getUser(Long id) {
        return new User("getUser fallback", "getUser fallback");
    }

    @Override
    public User getSpcUser() {
        return new User("spcUser fallback", "spcUser fallback");
    }
}
