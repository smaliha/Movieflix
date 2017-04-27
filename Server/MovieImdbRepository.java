package saniya.egenProject.repository;

import java.util.List;

import saniya.egenProject.entity.MovieImdb;

public interface MovieImdbRepository {
	public List<MovieImdb> fetchAll();
	
	public MovieImdb fetchByTitle(String movietitle);
	
	public MovieImdb createNewImdbRating(MovieImdb m);
	
	public MovieImdb updateImdbRating(String movietitle, MovieImdb m);
	
	public void deleteImdbRating(String movietitle);
}
