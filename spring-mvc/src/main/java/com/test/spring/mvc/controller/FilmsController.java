package com.test.spring.mvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.spring.mvc.model.Film;
import com.test.spring.mvc.service.FilmService;
import com.test.spring.mvc.util.JsonConverter;

@Controller
public class FilmsController {
	//CRUD DAO FILMS
	@Autowired
	private FilmService filmsService;
	
	
	@RequestMapping(value = "/films/show-films", method = RequestMethod.GET)
	public ModelAndView showAllFilms() {
		ModelAndView mv = new ModelAndView("view-all-films");
		List<Film> films = filmsService.getAllFilm();
		String jsonCode = JsonConverter.convertToJSON(films);
		mv.addObject("jsonCode",jsonCode);
		return mv;
	}
	
	@RequestMapping(value = "/films/show-film-form", method = RequestMethod.GET)
	public String showFilmForm(Model model) {
		Film film = new Film();
		model.addAttribute("film", film);
		return "film-form";
	}
	@RequestMapping(value = "/films/remove-film/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFilm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("result-page");
		boolean resultService = filmsService.removeFilmById(id);
		if(resultService == true) {
			mv.addObject("msg","Film Deleted");
		} else {
			mv.addObject("msg", "Delete Failed");
		}
		return mv;
	}
	
	@RequestMapping(value="/films/save-film/", method = RequestMethod.POST)
	public ModelAndView addFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView("result-page");
		boolean resultService = filmsService.addFilm(film);
		if(resultService == true) {
			mv.addObject("msg","Film Saved");
		} else {
			mv.addObject("msg", "Save Failed");
		}
		return mv;
	}
	
	@RequestMapping(value = "/films/update-film/{id}", method = RequestMethod.GET)
	public ModelAndView showFilmToUpdate(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("film-form");
		Film filmUpd = filmsService.getFilmById(id);
		//mv.addObject("id",filmUpd.getName());
		mv.addObject("name",filmUpd.getName());
		mv.addObject("genre",filmUpd.getGenre());
		mv.addObject("year",filmUpd.getYear());
		
		
		return mv;
	}
	
}
