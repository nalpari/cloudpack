package net.nalpari.admin.controller;

import net.nalpari.admin.entity.User;
import net.nalpari.admin.service.ApiUserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Desc :
 * @FileName : UserController.java
 * @Project : cloudpack
 * @Date : 2019-03-19
 * @Author : yoosw@3top.co.kr
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final ApiUserService apiUserService;

    public UserController(ApiUserService apiUserService) {
        this.apiUserService = apiUserService;
    }

    @GetMapping(value = {"/", ""})
    public List<User> getUserList() {
        return apiUserService.getUserList();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return apiUserService.getUser(id);
    }

    @PostMapping(value = {"/", ""})
    @ResponseBody
    public User postUser(User param) {
        return apiUserService.postUser(param);
    }

    @PutMapping("/modify")
    @ResponseBody
    public User putUser(User param) {
        return apiUserService.putUser(param);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public HashMap<String, Object> deleteUser(Long id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            apiUserService.deleteUser(id);
            result.put("code", "success");
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
