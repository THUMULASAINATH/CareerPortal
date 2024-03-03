package com.app.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll(Long id);

    void createJob(Job job,Long id);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean UpdateJob(Long id, Job updatedJob);
}
