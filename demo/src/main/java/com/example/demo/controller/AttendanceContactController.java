package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.dto.AttendanceContactAddRequest;
import com.example.demo.dto.AttendanceContactSearchRequest;
import com.example.demo.service.AttendanceContactPrincipal;
import com.example.demo.service.AttendanceContactService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class AttendanceContactController {
    final
    JdbcTemplate jdbcTemplate;

    public AttendanceContactController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private AttendanceContactService attendanceContactService;

    /**
     * 勤怠連絡一覧画面を表示
     * @param model Model
     * @return 勤怠連絡一覧画面
     */
    @GetMapping("/attendancecontact/list")
    public String display(Model model) {

        LocalDate now = LocalDate.now();
        LocalDate firstDate = now.withDayOfMonth(1);
        LocalDate lastDate = firstDate.plusMonths(1).minusDays(1);

        // 保持
        AttendanceContactSearchRequest attendanceContactSearchRequest = new AttendanceContactSearchRequest();
        attendanceContactSearchRequest.setTargetDateFrom(java.sql.Date.valueOf(firstDate));
        attendanceContactSearchRequest.setTargetDateTo(java.sql.Date.valueOf(lastDate));
        new AttendanceContactPrincipal(attendanceContactSearchRequest);

        List<Map<String, Object>> attendanceContacts = attendanceContactService.search(java.sql.Date.valueOf(firstDate), java.sql.Date.valueOf(lastDate));
        model.addAttribute("title", "勤怠連絡一覧");
        model.addAttribute("dateFrom", firstDate);
        model.addAttribute("dateTo", lastDate);
        model.addAttribute("attendanceContacts", attendanceContacts);
        return "attendanceContact/list";
    }

    /**
     * 勤怠連絡の指定範囲取得
     * @param model Model
     * @return 勤怠連絡一覧画面
     */
    @GetMapping("/attendancecontact/list/get")
    public String display(Model model, @ModelAttribute AttendanceContactSearchRequest attendanceContactSearchRequest) {
        // 保持
        new AttendanceContactPrincipal(attendanceContactSearchRequest);

        List<Map<String, Object>> attendanceContacts = attendanceContactService.search(attendanceContactSearchRequest.getTargetDateFrom(), attendanceContactSearchRequest.getTargetDateTo());
        model.addAttribute("title", "勤怠連絡一覧");
        model.addAttribute("dateFrom", attendanceContactSearchRequest.getTargetDateFrom());
        model.addAttribute("dateTo", attendanceContactSearchRequest.getTargetDateTo());
        model.addAttribute("attendanceContacts", attendanceContacts);
        return "attendanceContact/list";
    }

    /**
     * 勤怠連絡論理削除
     * @param id ID
     * @return 勤怠連絡一覧画面
     */
    @PutMapping("/attendancecontact/list/{id}")
    public String logicalDelete(Model model, @PathVariable Long id) {
        attendanceContactService.logicalDelete(id);

        List<Map<String, Object>> attendanceContacts = attendanceContactService.search(AttendanceContactPrincipal.getTargetDateFrom(), AttendanceContactPrincipal.getTargetDateTo());
        model.addAttribute("title", "勤怠連絡一覧");
        model.addAttribute("dateFrom", AttendanceContactPrincipal.getTargetDateFrom());
        model.addAttribute("dateTo", AttendanceContactPrincipal.getTargetDateTo());
        model.addAttribute("attendanceContacts", attendanceContacts);
        return "attendanceContact/list";
    }

    /**
     * 勤怠連絡画面を表示
     * @param model Model
     * @return 勤怠連絡画面
     */
    @GetMapping("/attendancecontact/add")
    public String displayAdd(Model model) {
        model.addAttribute("title", "勤怠連絡");
        model.addAttribute("attendanceContactAddRequest", new AttendanceContactAddRequest());
        return "attendanceContact/add";
    }

    /**
     * 勤怠連絡登録
     * @param attendanceContactRequest 勤怠連絡リクエストデータ
     * @return 勤怠連絡一覧画面
     */
    @PostMapping("/attendancecontact/add")
    public String create(@ModelAttribute AttendanceContactAddRequest attendanceContactAddRequest) {
        attendanceContactService.save(attendanceContactAddRequest);
        return "redirect:/attendancecontact/list";
    }
}
