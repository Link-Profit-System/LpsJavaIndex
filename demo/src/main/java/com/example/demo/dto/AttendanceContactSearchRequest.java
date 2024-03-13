package com.example.demo.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AttendanceContactSearchRequest {

    /**
     * 対象日(FROM)
     */
    @NotEmpty
    private Date targetDateFrom;

    /**
     * 対象日(TO)
     */
    @NotEmpty
    private Date targetDateTo;
}
