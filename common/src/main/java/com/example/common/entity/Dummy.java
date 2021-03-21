package com.example.common.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 테스트용
 */
@Getter
@Entity
public class Dummy {

    @Id
    public Long id;

    @Column
    public String data;

    public Dummy(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Dummy() {

    }
}
