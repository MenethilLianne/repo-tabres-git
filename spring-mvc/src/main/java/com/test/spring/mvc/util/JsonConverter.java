package com.test.spring.mvc.util;

import java.util.List;

import com.google.gson.Gson;
import com.test.spring.mvc.model.Film;

public class JsonConverter {
	public static String convertToJSON(List<Film> films) {
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		for (Film film : films) {
			sb.append(gson.toJson(film));
		}
		String jsonCode = sb.toString().replace("}{", "},{").trim();
		
		return jsonCode;
	}

}
