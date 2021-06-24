package com.example.License.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.License.models.Licenses;
import com.example.License.models.Person;
import com.example.License.repositories.LicenseRepository;

@Service
public class LicenseServices {

	private final LicenseRepository licenseRepository;

	public LicenseServices(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	public List<Licenses> getAll() {
		return licenseRepository.findAll();
	}

	public Licenses createLicense(Licenses l) {
		return licenseRepository.save(l);
	}
	
	public Licenses findPerson(Long id) {
        Optional<Licenses> optionalPerson = licenseRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
//public Licenses findLicense(Long id) {
//    Optional<Licenses> optionalice = LicenseRepository.findById(id);
//    if(optionalice.isPresent()) {
//        return optionalice.get();
//    } else {
//        return null;
//    }
//}
}
