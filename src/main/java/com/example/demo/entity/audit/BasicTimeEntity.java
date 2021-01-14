package com.example.demo.entity.audit;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasicTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
