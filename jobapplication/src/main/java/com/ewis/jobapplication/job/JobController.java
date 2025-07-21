package com.ewis.jobapplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll () {
        return new ResponseEntity<>(jobservice.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobservice.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.OK);
    }

    @GetMapping("jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobservice.getJobById(id);
        if(job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        Job deletedJob = jobservice.deleteJobById(id);
        if (deletedJob != null) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob) {
        Job job = jobservice.updateJobById(id, updatedJob);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
