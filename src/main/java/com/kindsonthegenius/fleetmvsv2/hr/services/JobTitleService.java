package com.kindsonthegenius.fleetmvsv2.hr.services;
import com.kindsonthegenius.fleetmvsv2.hr.models.JobTitle;
import com.kindsonthegenius.fleetmvsv2.hr.repository.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;


    public List<JobTitle> findAll(){
        return jobTitleRepository.findAll();
    }


    public JobTitle findById(int id) {
        return jobTitleRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        jobTitleRepository.deleteById(id);
    }


    public void save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }
}