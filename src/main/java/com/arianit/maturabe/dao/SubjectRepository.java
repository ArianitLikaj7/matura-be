package com.arianit.maturabe.dao;

import com.arianit.maturabe.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByIdIn(List<Long> ids);
}
