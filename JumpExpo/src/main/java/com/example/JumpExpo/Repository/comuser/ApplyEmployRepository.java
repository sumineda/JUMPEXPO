package com.example.JumpExpo.Repository.comuser;

import com.example.JumpExpo.Entity.admin.ScheduleInsert;
import com.example.JumpExpo.Entity.comuser.ApplyEmploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyEmployRepository  extends JpaRepository<ApplyEmploy, Integer> {
}
