package com.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.index.model.Cat;
import com.index.repository.CatRepository;

@Controller
public class StartController {

	@Autowired // --> Implementation needed, we need it get injected.
				// Interface <- Class (the implementation), spring data magic.
	private CatRepository catRepo;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	// --> it associate to an URL, the root.
//	public ModelAndView start() {
//		List<Cat> petList = (List<Cat>) catRepo.findAll();
//		ModelAndView mav = new ModelAndView("landing");
//		mav.addObject("pets", petList);
//		return mav;
//	}

	//TODO: change above method for the one in 02:06:55
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landing(Model model){
		List<Cat> petList = (List<Cat>) catRepo.findAll();
		model.addAttribute("pets", petList);
		return "landing";
	}
	
	
	
	
}
