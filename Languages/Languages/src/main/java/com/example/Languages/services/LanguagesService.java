package com.example.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Languages.models.LanguagesModel;
import com.example.Languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {
	private final LanguagesRepository languagesRepository;

	public LanguagesService(LanguagesRepository languagesRepository) {
		
		this.languagesRepository = languagesRepository;
	}
	public List<LanguagesModel> getAll(){
		return languagesRepository.findAll();
	}
	 public LanguagesModel createLanguage(LanguagesModel l) {
	        return languagesRepository.save(l);
	    }
    public LanguagesModel findlanguage(Long id) {
        Optional<LanguagesModel> optionallang = languagesRepository.findById(id);
        if(optionallang.isPresent()) {
            return optionallang.get();
        } else {
            return null;
        }
    }
    
        public LanguagesModel updateLanguages(LanguagesModel lang) {
//    		LanguagesModel language1=this.findlanguage(id);
//    		language1.setName(name);
//    		language1.setCreator(creator);
//    		language1.setVersion(version);
    		
    		return languagesRepository.save(lang);
    	}
        public void deletelanguages(Long id) {
    		languagesRepository.deleteById(id);
    		
    	}

}
