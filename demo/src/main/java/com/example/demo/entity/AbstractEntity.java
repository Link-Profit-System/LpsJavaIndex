package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * 共通 Entity
 */
@MappedSuperclass
public class AbstractEntity {

    /**
     * 登録日時
     */
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    /**
     * 更新日時
     */
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    /**
     * 登録前処理
     */
    @PrePersist
    public void prePersist() {
        // 登録日、更新日を設定
        LocalDateTime localDateTime = LocalDateTime.now();
        createdAt = Date.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant());
        updatedAt = Date.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant());
    }

    /**
     * 更新前処理
     */
    @PreUpdate
    public void preUpdate() {
        // 更新日を設定
        updatedAt = Date.from(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant());
    }
}