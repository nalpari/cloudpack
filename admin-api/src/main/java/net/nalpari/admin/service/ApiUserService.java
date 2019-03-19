package net.nalpari.admin.service;

import net.nalpari.admin.entity.User;
import net.nalpari.admin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc :
 * @FileName : ApiUserService.java
 * @Project : cloudpack
 * @Date : 2019-03-19
 * @Author : yoosw@3top.co.kr
 */
@Service
public class ApiUserService {

    private final UserRepository repository;

    public ApiUserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUserList() {
        return repository.findAll();
    }

    public User getUser(Long id) {
        return repository.findById(id).get();
    }

    public User postUser(User user) {
        return repository.saveAndFlush(user);
    }

    public User putUser(User user ) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
