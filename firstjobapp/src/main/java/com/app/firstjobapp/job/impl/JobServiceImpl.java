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
<<<<<<< HEAD
=======
    private Long nextId = 1L;
>>>>>>> a10dc5efc3d129a929f19e1b64e51daddab4d309

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
<<<<<<< HEAD
    public boolean createJob(Job job,Long id) {
=======
    public void createJob(Job job,Long id) {
>>>>>>> a10dc5efc3d129a929f19e1b64e51daddab4d309
        Company company = companyService.getCompanyById(id);
        if (company != null){
            job.setCompany(company);
            jobRepository.save(job);
<<<<<<< HEAD
            return true;
        }
        else {
            return false;
=======
>>>>>>> a10dc5efc3d129a929f19e1b64e51daddab4d309
        }

    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
<<<<<<< HEAD
        if (jobRepository.existsById(id)){
            jobRepository.deleteById(id);
            return true;
        } else {
=======
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
>>>>>>> a10dc5efc3d129a929f19e1b64e51daddab4d309
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
