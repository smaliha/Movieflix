package saniya.egenProject.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "MovieDetails.findByTitle", query = "SELECT * FROM MovieDetails m WHERE m.movieTitle=:pName") ,
	@NamedQuery(name = "MovieDetails.findAll", query = "SELECT * FROM MovieDetails m WHERE m.movieTitle=:pName")
})


public class MovieDetails {
	private String movieTitle;
	private String movieDirector;
	private String movieWriter;
	private String movieActors;
	private String moviePlot;
	private String movieLanguage;
	private String movieCountry;
	private String movieAwards;
	private String moviePoster;
	
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getMovieWriter() {
		return movieWriter;
	}
	public void setMovieWriter(String movieWriter) {
		this.movieWriter = movieWriter;
	}
	public String getMovieActors() {
		return movieActors;
	}
	public void setMovieActors(String movieActors) {
		this.movieActors = movieActors;
	}
	public String getMoviePlot() {
		return moviePlot;
	}
	public void setMoviePlot(String moviePlot) {
		this.moviePlot = moviePlot;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public String getMovieCountry() {
		return movieCountry;
	}
	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}
	public String getMovieAwards() {
		return movieAwards;
	}
	public void setMovieAwards(String movieAwards) {
		this.movieAwards = movieAwards;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

}
