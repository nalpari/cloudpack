package net.nalpari.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.nalpari.admin.entity.Sample;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc :
 * @FileName : UserService.java
 * @Project : cloudpack
 * @Date : 2019-03-15
 * @Author : yoosw@3top.co.kr
 */
@Service
public class GetSamplesCommand {

    @HystrixCommand(fallbackMethod = "defaultFallback")
    public List<Sample> getSamples() {
//        List<Sample> result = new ArrayList<>();
//        result.add(new Sample("test"));
//        result.add(new Sample("test111"));
        List<Sample> result = new RestTemplate().getForObject("http://localhost:7788/test/", ArrayList.class);
        return result;
    }

    public List<Sample> defaultFallback() {
        List<Sample> result = new ArrayList<>();
//        String result = "fallback exec";
        return result;
    }
}
