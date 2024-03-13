package com.example.demo.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * 勤怠連絡 リクエストデータ
 */
@Data
public class AttendanceContactAddRequest {

    /**
     * 対象日
     */
    @NotEmpty
    private Date targetDate;

    /**
     * 勤怠種別
     */
    @NotEmpty
    private String attendanceType;

    /**
     * 理由種別
     */
    @NotEmpty
    private String attendanceReasonType;

    /**
     * 備考
     */
    private String note;
}
