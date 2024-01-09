package com.example.JumpExpo.Controller.admin;

import com.example.JumpExpo.Entity.comuser.ApplyEmploy;
import com.example.JumpExpo.Repository.comuser.ApplyEmployRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

//2024.01.09 박은채 채용 공고 심사 Controller
//채용 공고 심사 Controller
@Slf4j
@Controller
@RequestMapping("/admin")
public class EmployapplyController {

    @Autowired
    ApplyEmployRepository applyEmployRepository;

    // 심사중인 채용 신청 리스트
    @GetMapping("/show/employapply")
    public String recogeEmploy(Model model){

        ArrayList<ApplyEmploy> reqList = applyEmployRepository.AllreqEmployList();

        model.addAttribute("reqList", reqList);

        return "admin/employApply/Employapply";
    }

    // 심사 완료된 채용 신청 리스트
    @GetMapping("/show/disemployapply")
    public String disRecogeEmploy(Model model){

        ArrayList<ApplyEmploy> reqList = applyEmployRepository.AlldisreqEmployList();

        model.addAttribute("reqList", reqList);

        return "admin/employApply/Disemployapply";
    }

}
