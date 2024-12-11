package com.mysql.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question , Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject,String content);
    List<Question> findByCreateDateLessThan(LocalDateTime time);
    List<Question> findBySubjectLike(String subject);
}