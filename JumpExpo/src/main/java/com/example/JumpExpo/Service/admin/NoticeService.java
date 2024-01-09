//package com.example.JumpExpo.Service.admin;
//
//import com.example.JumpExpo.Entity.admin.Notice;
//import com.example.JumpExpo.Repository.admin.NoticeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//// 2024-01-09 유수민 조회수 서비스 테스트
//@Service
//@Transactional
//public class NoticeService {
//    @Autowired
//    NoticeRepository noticeRepository;
//    public Notice getNotice(Integer notCode) {
//        Optional<Notice> data = this.noticeRepository.findById(notCode);
//        if (data.isPresent()) {
//            Notice data1 = data.get();
//            data1.setNot_cnt(data1.getNot_cnt()+1);
//            this.noticeRepository.save(data1);
//            return data1;
//        } else {
//            throw new DataNotFoundException("notice not found");
//        }
//    }
//}
//
