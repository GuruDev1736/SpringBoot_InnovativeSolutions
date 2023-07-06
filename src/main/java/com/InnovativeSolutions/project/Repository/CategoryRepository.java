package com.InnovativeSolutions.project.Repository;

import com.InnovativeSolutions.project.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


    boolean existsByName(String name);
    long count();
}
