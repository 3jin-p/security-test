package com.example.common.repo;

import com.example.common.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Dummy, Long> {
}
