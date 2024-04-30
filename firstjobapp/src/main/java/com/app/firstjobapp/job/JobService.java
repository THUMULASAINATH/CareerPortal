package com.app.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll(Long id);

<<<<<<< HEAD
    boolean createJob(Job job,Long id);
=======
    void createJob(Job job,Long id);
>>>>>>> a10dc5efc3d129a929f19e1b64e51daddab4d309

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean UpdateJob(Long id, Job updatedJob);
}
