package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 勤怠連絡 Entity
 */
@Entity
@Data
@Table(name = "attendance_contacts")
public class AttendanceContact extends AbstractEntity {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 社員番号
     */
    @Column(name = "employee_num", nullable = false)
    private String employeeNum;

    /**
     * 対象日
     */
    @Column(name = "target_date", nullable = false)
    private Date targetDate;

    /**
     * 勤怠種別
     */
    @Column(name = "attendance_type", nullable = false)
    private String attendanceType;

    /**
     * 勤怠種別
     */
    @Column(name = "attendance_reason_type", nullable = false)
    private String attendanceReasonType;

    /**
     * 備考
     */
    @Column(name = "note", nullable = true)
    private String note;

    /**
     * 論理削除
     */
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    /**
     * 登録者
     */
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    /**
     * 更新者
     */
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
}