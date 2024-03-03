package com.app.firstjobapp.job;

import com.app.firstjobapp.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyId(Long companyId);
    void deleteByCompanyId(Long companyId);
}
