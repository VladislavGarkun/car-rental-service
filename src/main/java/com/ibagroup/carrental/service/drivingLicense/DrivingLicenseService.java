package com.ibagroup.carrental.service.drivingLicense;

import com.ibagroup.carrental.dto.drivingLicense.DrivingLicenseDto;
import com.ibagroup.carrental.model.drivingLicense.DrivingLicense;
import com.ibagroup.carrental.repo.drivingLicense.DrivingLicenseRepo;
import com.ibagroup.carrental.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingLicenseService {

    private final DrivingLicenseRepo repo;

    private final UserRepo userRepo;

    @Autowired
    public DrivingLicenseService(DrivingLicenseRepo repo, UserRepo userRepo){
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

    public DrivingLicense getDrivingLicenseById(Long drivingLicenseId) {
        return repo.findById(drivingLicenseId).get();
    }

    public List<DrivingLicense> getAllDrivingLicenses() {
        return repo.findAll();
    }

    public DrivingLicense updateDrivingLicense(DrivingLicense drivingLicense) {
        return repo.save(drivingLicense);
    }

    public void deleteDrivingLicenseById(Long drivingLicenseId) {
        repo.deleteById(drivingLicenseId);
    }
}
