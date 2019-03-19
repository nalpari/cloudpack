package net.nalpari.admin.service;

import net.nalpari.admin.entity.Sample;
import net.nalpari.admin.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc :
 * @FileName : SampleService.java
 * @Project : cloudpack
 * @Date : 2019-03-14
 * @Author : yoosw@3top.co.kr
 */
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }

    public Sample getSample(Long sampleId) {
        return sampleRepository.findById(sampleId).get();
    }

    public Sample setSample(Sample sample) {
        return sampleRepository.save(sample);
    }

    public Sample putSample(Long sampleId, Sample sample) {
        sample = sampleRepository.findById(sampleId).get();
        return sampleRepository.saveAndFlush(sample);
    }

    public void delSample(Long sampleId) {
        sampleRepository.deleteById(sampleId);
    }
}
