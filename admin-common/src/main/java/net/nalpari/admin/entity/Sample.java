package net.nalpari.admin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Desc :
 * @FileName : Sample.java
 * @Project : cloudpack
 * @Date : 2019-03-14
 * @Author : yoosw@3top.co.kr
 */
@Entity
@Getter
@Setter
@Table(name="sample")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 11)
    private Long sampleId;

    @Column(name = "name", length = 30)
    private String name;

    public Sample() {
    }

    public Sample(String name) {
        this.name = name;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
