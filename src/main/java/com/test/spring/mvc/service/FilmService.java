package com.test.spring.mvc.service;

import java.util.List;

import com.test.spring.mvc.model.Film;

public interface FilmService {
	Film getFilm(Film film);
	
	Film getFilmById(int id);

	List<Film> getAllFilm();

	boolean addFilm(Film film);

	boolean removeFilmBy(Film film);
	
	boolean removeFilmById(int id);

	boolean updateFilm(Film film);
}
