package net.nalpari.admin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Desc :
 * @FileName : Item.java
 * @Project : cloudpack
 * @Date : 2019-03-15
 * @Author : yoosw@3top.co.kr
 */
@Entity
@Getter
@Setter
@Table(name = "tbl_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 11)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    public Item() {}

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
