package com.test.spring.mvc.controller;

//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.test.spring.mvc.dao.FilmDAO;
//import com.test.spring.mvc.dao.FilmDAOImpl;
//import com.test.spring.mvc.model.Film;
//import com.test.spring.mvc.model.User;
//import com.test.spring.mvc.service.FilmService;

//@Controller
public class HomeController {

//	@Autowired
//	private FilmService filmService;
	
//	@RequestMapping(value="/")
//	public ModelAndView test(HttpServletResponse response) throws IOException{
//		ModelAndView mv = new ModelAndView("home");
//		mv.addObject("msg", "value");
//		return mv;
//	}
//	
//	
//	@RequestMapping(value = "/test2", method = RequestMethod.GET)
//	public ModelAndView test2(
//			@RequestParam(value = "name", required = false) String name) {
//		ModelAndView mv = new ModelAndView("home");
//		mv.addObject("msg", name.toUpperCase());
//		return mv;
//		
//	}
//	
//	
//	@RequestMapping(value = "/users/get", method = RequestMethod.GET)
//	public ModelAndView c1(
//			@RequestParam(value = "id", required = false) int id) {
//		User user = UsersDB.getUser(id);
//		
//		ModelAndView mv = new ModelAndView("view-user");
//		mv.addObject("user", user);
//		return mv;
//		
//	}
//	
//	@RequestMapping(value = "/users/getUsers", method = RequestMethod.GET)
//	public ModelAndView getAllUsers() {
//		List<User> users = UsersDB.users;
//		ModelAndView mv = new ModelAndView("view-all-users");
//		mv.addObject("users", users);
//		mv.addObject("msg", "Sucessfull");
//		return mv;
//	}
//	
//	@RequestMapping(value = "/test3", method = RequestMethod.GET)
//	public String test3(Model model) {
//		model.addAttribute("msg", "val3");
//		return "home";
//		
//	}
//	
//	@RequestMapping(value = "/test4", method = RequestMethod.GET)
//	public String test4(ModelAndView mv) {
//		
//		return "home";
//		
//	}
//	
//	@RequestMapping(value = "/hiberTest", method = RequestMethod.GET)
//	public String hiberTest(Model model) {
//		
//	
//		Film f= new Film();
//		f.setId(2);
//		Film dbFilm = filmService.getFilm(f);
//		
//		model.addAttribute("msg", dbFilm.getName());
//		return "home";
//		
//	}
}
