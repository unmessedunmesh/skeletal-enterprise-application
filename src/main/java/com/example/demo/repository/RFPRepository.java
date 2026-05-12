package com.example.demo.repository;

import com.example.demo.model.RFP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RFPRepository extends JpaRepository<RFP, Long> {

    @Query("SELECT DISTINCT c FROM RFP c LEFT JOIN FETCH c.policies")
    List<RFP> findAllWithBranches();
}