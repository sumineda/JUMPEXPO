package com.example.JumpExpo.Controller.admin;

import com.example.JumpExpo.DTO.admin.NoticeForm;
import com.example.JumpExpo.DTO.admin.schedule.EmpForm;
import com.example.JumpExpo.Entity.admin.Notice;
import com.example.JumpExpo.Entity.admin.ScheduleInsert;
import com.example.JumpExpo.Repository.admin.NoticeRepository;
import com.example.JumpExpo.Repository.admin.SchInsetExpoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
//2024-01-08 유수민
//공지사항 등록 컨트롤러
@Slf4j
@Controller
@RequestMapping("/admin")
public class NoticeController {
    @Autowired
    NoticeRepository noticeRepository;

    //공지사항 등록 페이지
    @GetMapping("/Notice/new")
    public String createNt(){

        return "admin/notice/NoticeNew";
    }
    //     공지사항 등록 (post)
    @PostMapping("/Notice/create")
    public String createNotice(@ModelAttribute NoticeForm form){

        log.info(form.toString());
        //1. DTO > Entity로 변환
        Notice data = form.toEntity();
        log.info(data.toString());
        //2. 변환된 Entity를 Repository를 통해서 DB에 저장
        Notice save = noticeRepository.save(data);


        return "redirect:/admin/notice/Notice";
    }
    @GetMapping("/notice/Notice")
    public String index(Model model)
    {
        //1. 디비에서 notice 테이블에 있는 모든 데이터 가져오기
        ArrayList<Notice> NoticeEntityList = noticeRepository.findAll();

        //2. Notice 묶음을 모델에 등록( Entity > Model )
        model.addAttribute("NoticeList", NoticeEntityList);

        //3. 뷰에 모델 뿌리기
        return  "admin/notice/NoticeList";
    }
    @PostMapping("/save/NoticeFile")
    public String SaveNotF(NoticeForm form, @RequestParam(value = "notFile",required = false) MultipartFile file1){

        log.info(form.toString());


        String link = "\\\\192.168.2.3\\images\\a";

        try {
            if(file1 != null && !file1.isEmpty()){
                String vio1 = link + File.separator + file1.getOriginalFilename();
                Path filePath = Paths.get(vio1);
                Files.copy(file1.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (IOException e) {
            log.error("Error occurred while copying the file: {}", e.getMessage());
            e.printStackTrace();
            return "";
        }

        Notice data = form.toEntity();
        data.setNot_code(0);
        Notice save = noticeRepository.save(data);
        log.info(save.toString());

        return "";
    }
}
