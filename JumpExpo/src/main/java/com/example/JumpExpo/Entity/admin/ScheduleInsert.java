package com.example.JumpExpo.Entity.admin;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

//2024.01.08 정정빈 박람회 등록 Entity
//박람회 정보 Entity
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleInsert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int expo_code;

    @Column
    int expo_cate;  //취업 0 페어 1 채용 2

    @Column
    String expo_title; //25자리

    @Temporal(TemporalType.DATE)
    Date expo_start;

    @Temporal(TemporalType.DATE)
    Date expo_end;

    @Temporal(TemporalType.DATE)
    Date apply_start;

    @Temporal(TemporalType.DATE)
    Date apply_end;

    @Column
    String expo_add;

    @Column
    String  expo_image;

    @Column
    String expo_time;

    @Column
    String expo_outline;

    @Column
    String expo_host;

    @Column
    String expo_manage;

    @Column
    String expo_exhibit;

    @Column
    String master_name;

    @Column
    String master_phone;

    @Column
    String master_mail;

    @Column
    String expo_occ_cate;

    @Column
    String expo_content;
}
