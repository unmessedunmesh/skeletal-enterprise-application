package com.example.demo.service;

import com.example.demo.model.RFP;
import com.example.demo.repository.RFPRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RFPServiceImpl {


    private final RFPRepository rfpRepository;

    public RFPServiceImpl(RFPRepository rfpRepository) {
        this.rfpRepository = rfpRepository;
    }

    public List<RFP> findAll() {
        return rfpRepository.findAll();
    }

    public List<RFP> saveAll(List<RFP> rfp) {
        return rfpRepository.saveAll(rfp);
    }
}
