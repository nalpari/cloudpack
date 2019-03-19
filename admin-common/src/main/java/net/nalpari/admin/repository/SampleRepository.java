package net.nalpari.admin.repository;

import net.nalpari.admin.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc :
 * @FileName : SampleRepository.java
 * @Project : cloudpack
 * @Date : 2019-03-14
 * @Author : yoosw@3top.co.kr
 */
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
