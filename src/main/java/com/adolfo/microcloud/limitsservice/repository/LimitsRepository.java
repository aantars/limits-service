package com.adolfo.microcloud.limitsservice.repository;

import com.adolfo.microcloud.limitsservice.entity.Limits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitsRepository extends JpaRepository<Limits, Long> {
}
