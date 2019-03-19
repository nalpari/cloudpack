package net.nalpari.user.controller;

import net.nalpari.admin.entity.Sample;
import net.nalpari.admin.entity.User;
import net.nalpari.user.service.GetSampleCommand;
import net.nalpari.user.service.GetSamplesCommand;
import net.nalpari.user.service.PostSampleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc :
 * @FileName : UserController.java
 * @Project : cloudpack
 * @Date : 2019-03-15
 * @Author : yoosw@3top.co.kr
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final GetSamplesCommand getSamplesCommand;
    private final GetSampleCommand getSampleCommand;
    private final PostSampleCommand postSampleCommand;

    public UserController(GetSamplesCommand getSamplesCommand,
                          GetSampleCommand getSampleCommand,
                          PostSampleCommand postSampleCommand) {
        this.getSamplesCommand = getSamplesCommand;
        this.getSampleCommand = getSampleCommand;
        this.postSampleCommand = postSampleCommand;
    }

    @GetMapping(value = {"/", ""})
    public List<User> getUsers(@PathVariable String name){
        logger.info("User service "+name);
        List<User> userLists = new ArrayList<>();

        return userLists;
    }

    @GetMapping("/samples")
    public List<Sample> getSamples() {
        return getSamplesCommand.getSamples();
    }

    @GetMapping("/sample/{id}")
    public Sample getSample(@PathVariable Long id) {
        return getSampleCommand.getSample(id);
    }

    @PostMapping("/sample")
    @ResponseBody
    public Sample setSample(Sample param) {
        logger.debug("########### user param: {}", param.getName());
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("name", param.getName());
        return postSampleCommand.setSample(parameters);
    }
}
