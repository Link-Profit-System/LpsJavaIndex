package com.example.demo.service;

import java.sql.Date;

import com.example.demo.dto.AttendanceContactSearchRequest;

public class AttendanceContactPrincipal{

    private static Date targetDateFrom;
    private static Date targetDateTo;

    // コンストラクタ
    public AttendanceContactPrincipal(AttendanceContactSearchRequest attendanceContactSearchRequest) {
        AttendanceContactPrincipal.targetDateFrom = attendanceContactSearchRequest.getTargetDateFrom();
        AttendanceContactPrincipal.targetDateTo = attendanceContactSearchRequest.getTargetDateTo();
    }

    public static Date getTargetDateFrom() {
        return targetDateFrom;
    }
    
    public static Date getTargetDateTo() {
        return targetDateTo;
    }
    
}
