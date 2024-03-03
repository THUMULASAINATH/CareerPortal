package com.app.firstjobapp.job;

import com.app.firstjobapp.company.Company;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService=jobService;
    }

    //@GetMapping("/jobs")
    //or
    @GetMapping("/company/{id}")
    public ResponseEntity<List<Job>> findAll(@PathVariable Long id){
        return new ResponseEntity<>(jobService.findAll(id),HttpStatus.OK);
    }

    //@PostMapping("/jobs")
    //or
    @PostMapping("/{id}")
    public ResponseEntity<String> createJob(@RequestBody Job job, @PathVariable Long id){

        jobService.createJob(job,id);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    //@GetMapping("/jobs/{id}")
    //or
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@DeleteMapping("/jobs/{id}")
    //or
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Job Deleted Sucessfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //@PutMapping("/jobs/{id}")
    //or
    @PutMapping("/{id}")
    //or
    //@RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated = jobService.UpdateJob(id, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job updated sucessfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
