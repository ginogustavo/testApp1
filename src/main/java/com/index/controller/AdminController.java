package com.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.index.model.Cat;
import com.index.repository.CatRepository;

@Controller
public class AdminController {
	
	@Autowired
	CatRepository catRepo;

	@RequestMapping(value="/admin", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView inicio(){
		List<Cat> petList = (List<Cat>) catRepo.findAll();
		ModelAndView mav = new ModelAndView("administration");
		mav.addObject("pets",petList);
		return mav;
	}
	
	@RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
	public String submit(@PathVariable Long id) {
		Cat cat = catRepo.findOne( id );
		catRepo.delete(cat);
		return "redirect:/admin";
	}
}
