package com.example.JumpExpo.Repository.admin;

import com.example.JumpExpo.Entity.admin.ScheduleInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchInsetExpoRepository extends JpaRepository<ScheduleInsert, Integer> {
}
