package saniya.egenProject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.movieName ASC"),
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.movieTitle=:pTitle"),
	@NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.movieGenre =:pGenre")
})

public class Movie {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String movieTitle;
	private int movieYear;
	private String movieRate;
	private Date movieReleased;
	private String movieRuntime;
	private String movieGenre;
	
	//Related Foreign keys references . . 
	private MovieImdb ImdbMovie;
	private MovieDetails movieDetails;
	private UserActions userAction;
	
	public MovieImdb getImdbMovie() {
		return ImdbMovie;
	}
	public void setImdbMovie(MovieImdb imdbMovie) {
		ImdbMovie = imdbMovie;
	}
	public MovieDetails getMovieDetails() {
		return movieDetails;
	}
	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}
	public UserActions getUserAction() {
		return userAction;
	}
	public void setUserAction(UserActions userAction) {
		this.userAction = userAction;
	}
	
	
	//Movie fields
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	public String getMovieRate() {
		return movieRate;
	}
	public void setMovieRate(String movieRate) {
		this.movieRate = movieRate;
	}
	public Date getMovieReleased() {
		return movieReleased;
	}
	public void setMovieReleased(Date movieReleased) {
		this.movieReleased = movieReleased;
	}
	public String getMovieRuntime() {
		return movieRuntime;
	}
	public void setMovieRuntime(String movieRuntime) {
		this.movieRuntime = movieRuntime;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	
}
