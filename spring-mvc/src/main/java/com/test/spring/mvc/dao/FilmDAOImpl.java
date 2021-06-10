package com.test.spring.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.spring.mvc.model.Film;


@Repository("filmsDao")
public class FilmDAOImpl extends AbstractDao implements FilmDAO {

	@Override
	public Film getFilm(Film film) {
		Criteria criteria = getSession().createCriteria(Film.class);
		criteria.add(Restrictions.eq("id", film.getId()));
		return (Film) criteria.uniqueResult();
	}
	
	@Override
	public Film getFilmById(int id) {
		Film film = new Film();
		try {
			Criteria criteria = getSession().createCriteria(Film.class);
			criteria.add(Restrictions.eq("id", id));
			film = (Film) criteria.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return film;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> getAllFilm() {
		Criteria criteria = getSession().createCriteria(Film.class);
		return (List<Film>) criteria.list();
	}

	@Override
	public boolean addFilm(Film film) {
		try {
			persist(film);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean removeFilmBy(Film film) {
		try {
			Criteria criteria = getSession().createCriteria(Film.class);
			criteria.add(Restrictions.eq("id", film.getId()));
			Film deleteFilm = (Film) criteria.uniqueResult();
			delete(deleteFilm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean removeFilmById(int id) {
		try {
			Criteria criteria = getSession().createCriteria(Film.class);
			criteria.add(Restrictions.eq("id", id));
			Film deleteFilm = (Film) criteria.uniqueResult();
			delete(deleteFilm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFilm(Film film) {
		try {
			Criteria criteria = getSession().createCriteria(Film.class);
			criteria.add(Restrictions.eq("id", film.getId()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	


}
