package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AttendanceContact;

public interface AttendanceContactRepository extends JpaRepository<AttendanceContact, Long> {

}
