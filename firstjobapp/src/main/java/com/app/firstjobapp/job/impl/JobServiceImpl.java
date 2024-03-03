package com.app.firstjobapp.job.impl;

import com.app.firstjobapp.company.Company;
import com.app.firstjobapp.company.CompanyService;
import com.app.firstjobapp.job.Job;
import com.app.firstjobapp.job.JobRepository;
import com.app.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    CompanyService companyService;

    public JobServiceImpl(JobRepository jobRepository,CompanyService companyService) {
        this.jobRepository = jobRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Job> findAll(Long id) {
        List<Job> job=jobRepository.findByCompanyId(id);
        return job;
    }

    @Override
    public boolean createJob(Job job,Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null){
            job.setCompany(company);
            jobRepository.save(job);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean UpdateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);

                return true;
            }

        return false;
    }
}
