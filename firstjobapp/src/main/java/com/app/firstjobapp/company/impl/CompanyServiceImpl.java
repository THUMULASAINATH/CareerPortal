package com.app.firstjobapp.company.impl;

import com.app.firstjobapp.company.Company;
import com.app.firstjobapp.company.CompanyRepository;
import com.app.firstjobapp.company.CompanyService;

import com.app.firstjobapp.job.JobRepository;
import com.app.firstjobapp.review.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    public CompanyRepository comRepository;
    public JobRepository jobRepository;

    public ReviewRepository reviewRepository;


    public CompanyServiceImpl(CompanyRepository comRepository,JobRepository jobRepository,ReviewRepository reviewRepository) {
        this.comRepository = comRepository;
        this.jobRepository = jobRepository;
        this.reviewRepository=reviewRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return comRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional=comRepository.findById(id);
        if (companyOptional.isPresent()){
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            comRepository.save(companyToUpdate);
            return true;

        }

        return false;
    }

    @Override
    public void createCompany(Company company) {
        comRepository.save(company);
    }

    @Override
    @Transactional
    public boolean deleteCompanyById(Long id) {
        //jobRepository.deleteByCompanyId(id);
        Optional<Company> optionalCompany = comRepository.findById(id);


        if (optionalCompany.isPresent()) {

                Company company = optionalCompany.get();
                reviewRepository.deleteReviewsByCompany(company);
                comRepository.deleteById(id);
                return true;

        }
        else{
            return false;
        }
    }



    @Override
    public Company getCompanyById(Long id) {
        return comRepository.findById(id).orElse(null);
    }


}

