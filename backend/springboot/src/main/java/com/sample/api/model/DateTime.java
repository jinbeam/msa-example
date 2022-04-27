package com.sample.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by jslim
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DateTime {

    @CreatedDate
    @Column(name = "create_dt", updatable = false)
    private LocalDateTime createdDt;

    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updatedDt;

}
