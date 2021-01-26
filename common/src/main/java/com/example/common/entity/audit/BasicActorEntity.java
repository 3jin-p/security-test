package com.example.common.entity.audit;

import com.example.common.entity.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasicActorEntity {

    @CreatedBy
    User createdBy;

    @LastModifiedBy
    User modifiedBy;
}