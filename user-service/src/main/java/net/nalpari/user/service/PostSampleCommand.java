package net.nalpari.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.nalpari.admin.entity.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PostSampleCommand {

    private static final Logger logger = LoggerFactory.getLogger(PostSampleCommand.class);

    @HystrixCommand(fallbackMethod = "setSampleFallback")
    public Sample setSample(MultiValueMap<String, Object> param) {
//        logger.debug("######## command param: {}", param.getName());
        logger.debug("######## command param: {}", param.get("name"));
        Sample result = new RestTemplate().postForObject("http://localhost:7788/test", param, Sample.class);
        return result;
    }

    public Sample setSampleFallback(MultiValueMap<String, Object> param) {
        return new Sample("fallback");
    }
}
