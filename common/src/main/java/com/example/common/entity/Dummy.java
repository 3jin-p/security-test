package com.example.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 테스트용
 */
@Entity
public class Dummy {

    @Id
    public Long id;

    @Column
    public String data;

    public Dummy(String data) {
        this.data = data;
    }
}
