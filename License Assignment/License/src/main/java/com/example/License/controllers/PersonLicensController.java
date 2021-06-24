package com.example.License.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.License.models.Licenses;
import com.example.License.models.Person;
import com.example.License.services.LicenseServices;
import com.example.License.services.PersonServices;

@Controller
public class PersonLicensController {
	private final PersonServices personService;
	private final LicenseServices licenseService;

	public PersonLicensController(PersonServices personService, LicenseServices licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}

	@RequestMapping("/")
	public String all(Model model) {
		List <Person> person=personService.getAll();
		List <Licenses> lice=licenseService.getAll();
		model.addAttribute("person",person);
		model.addAttribute("lice",lice);
		return "person.jsp";
	}
	@RequestMapping(value="/persons/new",method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	    if (result.hasErrors()) {
	        return "newPerson.jsp";
	    } else {
	    	personService.createParson(person);
	        return "redirect:/persons/new";
	    }
	}
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("licens") Licenses licens,Model model) {
//		List<Person> persons = personService.getAll();
		List<Person> persons = personService.withoutLicensePersons();
		model.addAttribute("persons",persons);
		return "newLicense.jsp";
	}
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String createL(@Valid @ModelAttribute("licens") Licenses licen,BindingResult result,Model model) {
//		List<Person> persons = personService.getAll();
		List<Person> persons = personService.withoutLicensePersons();
		model.addAttribute("persons",persons);
		
		if (result.hasErrors()) {
	        return "newLicense.jsp";
	    } else {
	    	licenseService.createLicense(licen);
	        return "redirect:/licenses/new";
	        
	    }
	}
	@RequestMapping("/persons/{id}")
    public String person(@PathVariable("id") Long id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        Licenses lice = licenseService.findPerson(id);

        model.addAttribute("lice",lice);
        return "person.jsp";
    }
	
}
	

