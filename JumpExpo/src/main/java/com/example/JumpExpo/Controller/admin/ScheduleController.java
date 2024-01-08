package com.example.JumpExpo.Controller.admin;

import com.example.JumpExpo.DTO.admin.schedule.EmpForm;
import com.example.JumpExpo.Entity.admin.ScheduleInsert;
import com.example.JumpExpo.Repository.admin.SchInsetExpoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Controller
@RequestMapping("/admin")
public class ScheduleController {

    @Autowired
    SchInsetExpoRepository schInsetExpoRepository;

    //취업 박람회 일정 등록 페이지
    @GetMapping("/insert/emp")
    public String insertEmp(){

        return "admin/schedule/ScheduleEmp";
    }
    
    //취업 등록 정보 가져옴
    @PostMapping("/save/emp")
    public String SaveEmp(EmpForm form,@RequestParam(value = "ExpoImage",required = false) MultipartFile file1){

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

        ScheduleInsert data = form.toEntity();
        data.setExpo_cate(0);
        ScheduleInsert save = schInsetExpoRepository.save(data);
        log.info(save.toString());

        return "";
    }
}
