package com.ibagroup.carrental.service;

import com.ibagroup.carrental.service.dto.drivingLicense.DrivingLicenseDto;
import com.ibagroup.carrental.dao.model.drivingLicense.DrivingLicense;
import com.ibagroup.carrental.dao.repository.drivingLicense.DrivingLicenseRepository;
import com.ibagroup.carrental.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingLicenseService {

    private final DrivingLicenseRepository repo;

    private final UserRepository userRepo;

    @Autowired
    public DrivingLicenseService(DrivingLicenseRepository repo, UserRepository userRepo){
        this.repo = repo;
        this.userRepo = userRepo;
    }


    public DrivingLicense addDrivingLicense(DrivingLicenseDto drivingLicense) {
        DrivingLicense entity = new DrivingLicense();
        entity.setUser(userRepo.findById(drivingLicense.getId()).get());
        entity.setPhotoUrl(drivingLicense.getPhotoUrl());

        repo.save(entity);

        return entity;
    }

    public DrivingLicense findDrivingLicenseById(Long drivingLicenseId) {
        return repo.findById(drivingLicenseId).get();
    }

    public List<DrivingLicense> findAllDrivingLicenses() {
        return repo.findAll();
    }

    public DrivingLicense updateDrivingLicense(DrivingLicense drivingLicense) {
        return repo.save(drivingLicense);
    }

    public void deleteDrivingLicenseById(Long drivingLicenseId) {
        repo.deleteById(drivingLicenseId);
    }
}
