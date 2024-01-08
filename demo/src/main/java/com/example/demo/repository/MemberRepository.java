package com.example.demo.repository;

import com.example.demo.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByPhone(String phone);

    //@Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
}