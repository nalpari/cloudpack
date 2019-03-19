package net.nalpari.admin.repository;

import net.nalpari.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc :
 * @FileName : UserRepository.java
 * @Project : cloudpack
 * @Date : 2019-03-19
 * @Author : yoosw@3top.co.kr
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
