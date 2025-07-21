package com.ewis.jobapplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    Job deleteJobById(Long id);

    Job updateJobById(Long id, Job updatedJob);
}
