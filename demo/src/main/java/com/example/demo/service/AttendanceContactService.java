package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AttendanceContactAddRequest;
import com.example.demo.entity.AttendanceContact;
import com.example.demo.entity.UserInformation;
import com.example.demo.repository.AttendanceContactRepository;

@Service
public class AttendanceContactService {

    final
    JdbcTemplate jdbcTemplate;

    public AttendanceContactService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private AttendanceContactRepository attendanceContactRepository;

    @Autowired
    private UserInformationService userInformationService;

    public List<Map<String, Object>> search(Date targetDateFrom, Date targetDateTo) {

        UserInformation userInformation = userInformationService.findByUsername();

        // データベースの検索
        List<Map<String, Object>> attendanceContacts = jdbcTemplate.queryForList("SELECT * FROM sample.attendance_contacts WHERE employee_num = ? AND is_deleted = false AND target_date >= ? AND target_date <= ? ORDER BY target_date DESC",userInformation.getEmployeeNum(), targetDateFrom, targetDateTo);
        
        return attendanceContacts;
    }

    public void logicalDelete(Long id) {
        // 更新データ取得
        AttendanceContact attendanceContact = attendanceContactRepository.getReferenceById(id);

        // 上書き（論理削除のみ）
        attendanceContact.setIsDeleted(true);
        
        UserInformation userInformation = userInformationService.findByUsername();
        attendanceContact.setUpdatedBy(userInformation.getFamilyName() + " " + userInformation.getFirstName());

        // データベースへの保存
        attendanceContactRepository.save(attendanceContact);
    }

    public void save(AttendanceContactAddRequest attendanceContactAddRequest) {
        AttendanceContact attendanceContact = new AttendanceContact();
        attendanceContact.setTargetDate(attendanceContactAddRequest.getTargetDate());
        attendanceContact.setAttendanceType(attendanceContactAddRequest.getAttendanceType());
        attendanceContact.setAttendanceReasonType(attendanceContactAddRequest.getAttendanceReasonType());
        attendanceContact.setNote(attendanceContactAddRequest.getNote());
        attendanceContact.setIsDeleted(false);

        UserInformation userInformation = userInformationService.findByUsername();
        attendanceContact.setEmployeeNum(userInformation.getEmployeeNum());
        attendanceContact.setCreatedBy(userInformation.getFamilyName() + " " + userInformation.getFirstName());
        attendanceContact.setUpdatedBy(userInformation.getFamilyName() + " " + userInformation.getFirstName());

        // データベースへの保存
        attendanceContactRepository.save(attendanceContact);
    }
}
