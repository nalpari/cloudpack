package net.nalpari.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.nalpari.admin.entity.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Desc :
 * @FileName : GetSampleCommand.java
 * @Project : cloudpack
 * @Date : 2019-03-15
 * @Author : yoosw@3top.co.kr
 */
@Service
public class GetSampleCommand {

    private static final Logger logger = LoggerFactory.getLogger(GetSampleCommand.class);

    @HystrixCommand(fallbackMethod = "getSampleFallback")
    public Sample getSample(Long id) {
        Sample result = new RestTemplate().getForObject("http://localhost:7788/test/{id}", Sample.class, id);
        logger.debug("##### result.getSampleId: {}", result.getSampleId());
        return result;
    }

    public Sample getSampleFallback(Long id) {
        return new Sample("fallback");
    }
}
