package com.index.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.index.model.Cat;
import com.index.repository.CatRepository;

@Controller
public class StartController {

	@Autowired // --> Implementation needed, we need it get injected.
				// Interface <- Class (the implementation), spring data magic.
	private CatRepository catRepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	// --> it associate to an URL, the root.
	@Transactional(readOnly=true)
	public String landing(Model model) {
		List<Cat> petList = (List<Cat>) catRepo.findAll();
		model.addAttribute("pets", petList);

		model.addAttribute("cat", new Cat());
		return "landing";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String submit(@ModelAttribute Cat cat, Model model) {
		cat.setBirth(new Date());// TODO: Validate dates
		model.addAttribute("cat", cat);
		catRepo.save(cat);
		return "redirect:/";
	}

}
