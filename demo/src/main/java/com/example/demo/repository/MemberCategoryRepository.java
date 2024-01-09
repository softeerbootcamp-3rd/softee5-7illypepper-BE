package com.example.demo.repository;

import com.example.demo.Entity.MemberCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberCategoryRepository extends JpaRepository<MemberCategory, Long> {

    @Query(value = "select * from member_category where member_id = :memberId", nativeQuery = true)
    List<MemberCategory> findAllByMember(Long memberId);
}
