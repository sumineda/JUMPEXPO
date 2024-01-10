package com.example.JumpExpo.Repository.admin;

import com.example.JumpExpo.Entity.admin.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    @Override
    ArrayList<Notice> findAll();
    //2024-01-10 유수민
    //조회수 증가 쿼리
   @Modifying
   @Query("update Notice n set n.not_cnt = n.not_cnt + 1 where n.not_code = :not_code")int updateNot_cnt(int not_code);
}
