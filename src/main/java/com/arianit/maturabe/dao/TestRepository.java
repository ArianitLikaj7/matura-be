package com.arianit.maturabe.dao;

import com.arianit.maturabe.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
