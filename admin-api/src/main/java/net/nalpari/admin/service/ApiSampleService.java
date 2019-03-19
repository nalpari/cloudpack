package net.nalpari.admin.service;

import net.nalpari.admin.entity.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc :
 * @FileName : ApiSampleService.java
 * @Project : cloudpack
 * @Date : 2019-03-14
 * @Author : yoosw@3top.co.kr
 */
@Service
public class ApiSampleService {

    private final static Logger logger = LoggerFactory.getLogger(ApiSampleService.class);
    private final SampleService sampleService;

    @Autowired
    public ApiSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public List<Sample> getSamples() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<Sample> result = sampleService.getSamples();
        logger.debug("##### samples: {}", result);
        return result;
    }

    public Sample getSample(Long sampleId) {
        Sample result = sampleService.getSample(sampleId);
        logger.debug("###### sample.id : {}", result.getSampleId());
        return result;
    }

    public Sample setSample(Sample sample) {
        return sampleService.setSample(sample);
    }

    public Sample putSample(long sampleId, Sample param) {
        Sample sample = sampleService.getSample(sampleId);
        sample.setName(param.getName());

        return sampleService.putSample(sampleId, sample);
    }

    public void delSample(long sampleId) {
        sampleService.delSample(sampleId);
    }
}
