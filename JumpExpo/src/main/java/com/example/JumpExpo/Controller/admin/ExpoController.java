package com.example.JumpExpo.Controller.admin;

import com.example.JumpExpo.Entity.admin.ScheduleInsert;
import com.example.JumpExpo.Repository.admin.SchInsetExpoRepository;
import com.example.JumpExpo.Service.user.expo.ExpoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ExpoController {

    @Autowired
    SchInsetExpoRepository schInsetExpoRepository;

    @Autowired
    ExpoService expoService;

    //2024.01.08 정정빈
    //행사일정 - 전체일정 
    @GetMapping("/allexpo")
    public String AllExpoList(Model model, @RequestParam(value="page", defaultValue="0")int page,
                              @RequestParam(value = "serch",required = false)String serch){

        //박람회 전체 일정
//        Page<ScheduleInsert> AllList = expoService.getAllList(page);
        if (serch != null && serch.isEmpty()){
            log.info(serch);

        }
        Page<ScheduleInsert> AllList = null;

        if(serch != null){
            AllList = expoService.getSerchList(page,serch);
            log.info(AllList.toString());
        }else {
            AllList = expoService.getAllList(page);
        }

//        log.info(AllList.toString());
        model.addAttribute("AllList",AllList);

        model.addAttribute("TotalPage",AllList.getTotalPages());
        


        return "user/expo/ExpoAllList";
    }

//    @GetMapping("/serch")
//    public String Serch(Model model,@RequestParam(value = "serch")String serch,@RequestParam(value="page", defaultValue="0")int page){
//
//        log.info(serch);
//        Page<ScheduleInsert> Serch = expoService.getSerchList(page,serch);
//
//        model.addAttribute("AllList",Serch);
//        return "user/expo/SearchResultPage";
//    }

}
