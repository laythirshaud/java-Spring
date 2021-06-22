package com.example.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Languages.models.LanguagesModel;
import com.example.Languages.services.LanguagesService;

@Controller
public class LanguagesController {
	private final LanguagesService languagesService;
	
	public LanguagesController(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}
	
	
	@RequestMapping("/languages")
	public String index( Model model) {
		model.addAttribute("lang", new LanguagesModel());
		List<LanguagesModel> lang1 = languagesService.getAll();
		model.addAttribute("lang1", lang1);
		
		return "index.jsp";
	}
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("lang") LanguagesModel lang, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<LanguagesModel> lang1 = languagesService.getAll();
    		model.addAttribute("lang1", lang1);
            return "index.jsp";
        } else {
        	languagesService.createLanguage(lang);
            return "redirect:/languages";
        }
    }
    @RequestMapping("/languages/{id}/Edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        LanguagesModel lang3 = languagesService.findlanguage(id);
        model.addAttribute("lang3", lang3);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("lang3") LanguagesModel lang3, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languagesService.updateLanguages(lang3);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        languagesService.deletelanguages(id);
        return "redirect:/languages";
    }
    @RequestMapping("/languages/{id}")
    public String show(Model model ,@PathVariable("id") Long id) {
		LanguagesModel languages = languagesService.findlanguage(id);
		model.addAttribute("lang",languages);
        return "/show.jsp";
    }
    


}
