package com.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Lookify.models.Lookify;
import com.Lookify.repositories.LookifyRepository;

@Service
public class LookifyServices {
	private final LookifyRepository lookifyRepository;

	public LookifyServices(LookifyRepository lookifyRepository) {
		super();
		this.lookifyRepository = lookifyRepository;
	}
	public List<Lookify> getAll(){
		return lookifyRepository.findAll();
	}
	 public Lookify createLooki(Lookify l) {
	        return lookifyRepository.save(l);
	    }
    public Lookify findlooki(Long id) {
        Optional<Lookify> optionallang = lookifyRepository.findById(id);
        if(optionallang.isPresent()) {
            return optionallang.get();
        } else {
            return null;
        }
    }
    public void deletelooki(Long id) {
		lookifyRepository.deleteById(id);
		
	}
    public List<Lookify> findByArtistContaining(String searchName) {
		return lookifyRepository.findByArtistContaining(searchName);
	}
    public List<Lookify> getTopTen() {
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
}


