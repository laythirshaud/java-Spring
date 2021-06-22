package com.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Lookify.models.Lookify;
import com.Lookify.services.LookifyServices;
@Controller
public class LookifyController {
	private final LookifyServices lookifyServices;

	public LookifyController(LookifyServices lookifyServices) {
		this.lookifyServices = lookifyServices;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	
	}
	@RequestMapping("/dashboord")
	public String index2( Model model) {
		model.addAttribute("looki", new Lookify());
		List<Lookify> look1 = lookifyServices.getAll();
		model.addAttribute("looki", look1);
		return "dashboord.jsp";
	}

	@RequestMapping("/songs/new")
	public String New(@ModelAttribute("looki") Lookify looki) {
		return "new.jsp";
	}
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("looki") Lookify looki, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
		lookifyServices.createLooki(looki);
		return "redirect:/dashboord";
		}
	}
    @RequestMapping("/looki/{id}")
    public String show(Model model ,@PathVariable("id") Long id) {
		Lookify looki = lookifyServices.findlooki(id);
		model.addAttribute("looki",looki);
        return "/show.jsp";
    }
    @RequestMapping("/looki/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        lookifyServices.deletelooki(id);
        return "redirect:/dashboord";
    }
    @RequestMapping(value="/song/searcher", method=RequestMethod.POST)
    public String Searcher(Model model,@RequestParam(name = "search") String search) {
   	 List<Lookify> song = lookifyServices.findByArtistContaining(search);
   	model.addAttribute("searchResult", song);
   	model.addAttribute("searchValue", search);
   	 return "search.jsp";
    }
    @RequestMapping("/search/tobTen")
	public String tophard( Model model) {
		List<Lookify> toops = lookifyServices.getTopTen();
		model.addAttribute("topyou", toops);
		return "top.jsp";
	}
    
    
}

