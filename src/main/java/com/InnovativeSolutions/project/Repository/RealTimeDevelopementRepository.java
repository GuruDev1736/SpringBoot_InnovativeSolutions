package com.InnovativeSolutions.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InnovativeSolutions.project.Model.RealTimeDevelopment;

public interface RealTimeDevelopementRepository extends JpaRepository<RealTimeDevelopment,Long> {

    boolean existsByTopicAndEmail(String topic , String email);

    long count();
}
