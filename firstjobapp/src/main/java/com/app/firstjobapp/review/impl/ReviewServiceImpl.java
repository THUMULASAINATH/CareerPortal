package com.app.firstjobapp.review.impl;

import com.app.firstjobapp.company.Company;
import com.app.firstjobapp.company.CompanyService;
import com.app.firstjobapp.review.Review;
import com.app.firstjobapp.review.ReviewRepository;
import com.app.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        //Optional<Review> reviewOptional=reviewRepository.findById(reviewId);
        //if(reviewOptional.isPresent()){
            //Review review=reviewOptional.get();
            //review.setDescription(updatedReview.getDescription());
            if (companyService.getCompanyById(companyId) != null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            //reviewRepository.save(review);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
             reviewRepository.deleteById(reviewId);
             return true;
        }
        return false;
    }

    private final ReviewRepository reviewRepository;


    private final CompanyService companyService;


    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company=companyService.getCompanyById(companyId);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }
}
