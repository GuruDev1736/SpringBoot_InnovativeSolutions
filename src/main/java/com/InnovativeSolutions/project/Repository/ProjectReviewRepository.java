package com.InnovativeSolutions.project.Repository;

import com.InnovativeSolutions.project.Model.ProjectReviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectReviewRepository extends JpaRepository<ProjectReviews,Long> {

    List<ProjectReviews> findByReviewId (Long review);

}
