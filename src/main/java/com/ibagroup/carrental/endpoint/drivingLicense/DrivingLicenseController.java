package com.ibagroup.carrental.endpoint.drivingLicense;

import com.ibagroup.carrental.service.dto.drivingLicense.DrivingLicenseDto;
import com.ibagroup.carrental.dao.model.drivingLicense.DrivingLicense;
import com.ibagroup.carrental.service.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivinglicense")
public class DrivingLicenseController {

    private final DrivingLicenseService service;

    @Autowired
    public DrivingLicenseController(DrivingLicenseService service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDrivingLicense(@RequestBody DrivingLicenseDto drivingLicense){
        DrivingLicense entity = service.addDrivingLicense(drivingLicense);

        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "/{drivingLicenseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDrivingLicenseById(@PathVariable("drivingLicenseId") Long drivingLicenseId){
        DrivingLicense drivingLicense = service.findDrivingLicenseById(drivingLicenseId);

        return ResponseEntity.ok(drivingLicense);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DrivingLicense> getAllDrivingLicenses(){
        List<DrivingLicense> drivingLicenses = service.findAllDrivingLicenses();

        return drivingLicenses;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDrivingLicense(@RequestBody DrivingLicense drivingLicense){
        DrivingLicense entity = service.updateDrivingLicense(drivingLicense);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "{drivingLicenseId}")
    public void deleteDrivingLicenseById(@PathVariable Long drivingLicenseId){
        service.deleteDrivingLicenseById(drivingLicenseId);
    }
}
