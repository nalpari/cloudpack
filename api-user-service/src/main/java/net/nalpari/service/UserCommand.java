package net.nalpari.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.nalpari.admin.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc :
 * @FileName : UserCommand.java
 * @Project : cloudpack
 * @Date : 2019-03-19
 * @Author : yoosw@3top.co.kr
 */
@Service
public class UserCommand {

    private static final Logger logger = LoggerFactory.getLogger(UserCommand.class);

    @Value("${command.test.local}")
    private String testStr;

    @HystrixCommand(fallbackMethod = "getUserListFallback")
    public List<User> getUserList() {
        return new RestTemplate().getForObject("http://localhost:7788/user", List.class);
    }

    public List<User> getUserListFallback() {
        List<User> result = new ArrayList<>();
        return result;
    }

    @HystrixCommand(fallbackMethod = "getUserFallback")
    public User getUser(Long id) {
        return new RestTemplate().getForObject("http://localhost:7788/user/" + id, User.class);
    }

    public User getUserFallback(Long id) {
        User result = new User();
        result.setId(id);
        result.setName("fallback");
        result.setEmail("fallback@fallback.com");
        return result;
    }

    @HystrixCommand(fallbackMethod = "getSpecialUserFallback")
    public User getSpecialUser() {
        logger.debug("##### testStr: {}", testStr);
        return new User(testStr, testStr);
    }

    public User getSpecialUserFallback() {
        return new User("spcFallback", "spcFallback");
    }
}
