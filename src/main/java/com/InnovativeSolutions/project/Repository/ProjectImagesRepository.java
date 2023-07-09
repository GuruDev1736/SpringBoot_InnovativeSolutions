package com.InnovativeSolutions.project.Repository;

import com.InnovativeSolutions.project.Model.ProjectImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectImagesRepository extends JpaRepository<ProjectImages,Long> {

    boolean existsByImageUrl(String imageUrl);
    List<ProjectImages> findByBuyProjectId(Long buyProject);

}
