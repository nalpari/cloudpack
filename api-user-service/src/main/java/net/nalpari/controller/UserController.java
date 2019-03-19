package net.nalpari.controller;

import net.nalpari.admin.entity.User;
import net.nalpari.service.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final UserCommand userCommand;

    public UserController(UserCommand userCommand) {
        this.userCommand = userCommand;
    }

    @GetMapping(value = {"/", ""})
    public List<User> getUserList() {
        return userCommand.getUserList();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userCommand.getUser(id);
    }

    @GetMapping("/spc")
    public User getSpcUser() {
        return userCommand.getSpecialUser();
    }
}
