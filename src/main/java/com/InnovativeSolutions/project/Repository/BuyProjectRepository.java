package com.InnovativeSolutions.project.Repository;

import com.InnovativeSolutions.project.Model.BuyProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyProjectRepository extends JpaRepository<BuyProject,Long> {

    long count();

    @Query("SELECT DISTINCT p FROM BuyProject p WHERE " +
            "p.name LIKE CONCAT('%',:query,'%')"+
            " OR p.description LIKE CONCAT('%',:query,'%')")
    List<BuyProject> searchBuyProject(String query);

    @Query(value = "SELECT DISTINCT * FROM buy_project p WHERE " +
            "p.name LIKE CONCAT('%',:query,'%')"+
            "Or p.description LIKE CONCAT('%',:query,'%')" , nativeQuery = true)
    List<BuyProject> searchBuyProjectSQL(String query);



}
