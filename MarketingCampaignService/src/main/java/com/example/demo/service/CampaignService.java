package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Campaign;
import com.example.demo.reposetry.CampaignRepository;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository repository;

    public List<Campaign> getAllCampaigns() {
        return repository.findAll();
    }

    public Campaign saveCampaign(Campaign campaign) {
        return repository.save(campaign);
    }

    public Campaign getCampaignById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteCampaign(Long id) {
        repository.deleteById(id);
    }

    public List<Campaign> getCampaignsByLeadId(Long leadId) {
        return repository.findByLeadId(leadId);
    }
}
