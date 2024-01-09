package com.example.JumpExpo.Repository.comuser;

import com.example.JumpExpo.Entity.comuser.ApplyEmploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//2024.01.09 박은채
//채용 공고 심사 Repository
@Repository
public interface ApplyEmployRepository  extends JpaRepository<ApplyEmploy, Integer> {

//    @Query(value = "select *\n" +
//            "from apply_employ" +
//            "where recog_check = 0", nativeQuery = true)
//    ArrayList<ApplyEmploy> AllreqEmployList();

    @Query(value = "SELECT *\n" +
            "FROM apply_employ\n" +
            "WHERE recog_check = 0;", nativeQuery = true)
        ArrayList<ApplyEmploy> AllreqEmployList();

    @Query(value = "select *\n" +
            "from apply_employ\n" +
            "where recog_check = 1", nativeQuery = true)
    ArrayList<ApplyEmploy> AlldisreqEmployList();
}
