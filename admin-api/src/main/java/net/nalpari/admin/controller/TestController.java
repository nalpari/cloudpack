package net.nalpari.admin.controller;

import net.nalpari.admin.entity.Sample;
import net.nalpari.admin.service.ApiSampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desc :
 * @FileName : TestController.java
 * @Project : cloudpack
 * @Date : 2019-03-14
 * @Author : yoosw@3top.co.kr
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final ApiSampleService apiSampleService;

    @Autowired
    public TestController(ApiSampleService apiSampleService) {
        this.apiSampleService = apiSampleService;
    }

    @GetMapping(value = {"/", ""})
    public List<Sample> getSamples() {
        return apiSampleService.getSamples();
    }

    @GetMapping("/{sampleId}")
    public Sample getSample(@PathVariable Long sampleId) {
        return apiSampleService.getSample(sampleId);
    }

    @PostMapping(value = {"/", ""})
    @ResponseBody
    public Sample setSample(Sample param) {
        logger.debug("######## test param: {}", param.getName());
        return apiSampleService.setSample(param);
    }

    @PutMapping("/{sampleId}")
    public Sample putSample(@PathVariable Long sampleId, @RequestBody Sample param) {
        return apiSampleService.putSample(sampleId, param);
    }

    @DeleteMapping("/{sampleId}")
    public void delSample(@PathVariable Long sampleId) {
        apiSampleService.delSample(sampleId);
    }
}
