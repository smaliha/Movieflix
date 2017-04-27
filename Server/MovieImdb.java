package saniya.egenProject.entity;

import javax.persistence.Column;
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
	@NamedQuery(name = "movieImdb.findAll", query = "SELECT * FROM movieImdb m ORDER BY m.movieTitle ASC"),
	@NamedQuery(name = "movieImdb.findByTitle", query = "SELECT * FROM movieImdb m WHERE m.movieTitle=:pName"),
	@NamedQuery(name = "movieImdb.findTopMovies", query = "SELECT * FROM movieImdb m WHERE m.movieImdbRating>6"
			+ "ORDER BY m.movieImdbRating ASC LIMIT 10"),
//	@NamedQuery(name = "movieImdb.findTopSeries", query = "SELECT m FROM movieImdb m WHERE m.movieImdbRating>6"
//			+ "ORDER BY m.movieImdbRating ASC LIMIT 10"),
	
})

public class MovieImdb {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String movieTitle;

	private int movieImdbMetascore;
	private int movieImdbRating;
	private int movieImdbVotes;
	
	@Column(unique = true)
	private int movieImdbId;
	private String movieImdbType;
	
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
	public int getMovieImdbMetascore() {
		return movieImdbMetascore;
	}
	public void setMovieImdbMetascore(int movieImdbMetascore) {
		this.movieImdbMetascore = movieImdbMetascore;
	}
	public int getMovieImdbRating() {
		return movieImdbRating;
	}
	public void setMovieImdbRating(int movieImdbRating) {
		this.movieImdbRating = movieImdbRating;
	}
	public int getMovieImdbVotes() {
		return movieImdbVotes;
	}
	public void setMovieImdbVotes(int movieImdbVotes) {
		this.movieImdbVotes = movieImdbVotes;
	}
	public int getMovieImdbId() {
		return movieImdbId;
	}
	public void setMovieImdbId(int movieImdbId) {
		this.movieImdbId = movieImdbId;
	}
	public String getMovieImdbType() {
		return movieImdbType;
	}
	public void setMovieImdbType(String movieImdbType) {
		this.movieImdbType = movieImdbType;
	}

}
