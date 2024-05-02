package com.arianit.maturabe.dao;

import com.arianit.maturabe.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    List<QuestionAnswer> findBySubjectIdIn(List<Long> subjectIds);
    List<QuestionAnswer> findBySubjectId(Long id);
}
