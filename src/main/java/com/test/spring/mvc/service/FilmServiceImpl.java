package com.test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.spring.mvc.dao.FilmDAO;
import com.test.spring.mvc.model.Film;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDAO dao;
	
	@Override
	public Film getFilm(Film film) {
		return dao.getFilm(film);
	}
	
	

	@Override
	public List<Film> getAllFilm() {
		return dao.getAllFilm();
	}

	@Override
	public boolean addFilm(Film film) {
		boolean result = dao.addFilm(film);
		if(result == true) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeFilmById(int id) {
		boolean result = dao.removeFilmById(id);
		if(result == true) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFilmBy(Film film) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Film getFilmById(int id) {
		return dao.getFilmById(id);
	}

	

	

}
