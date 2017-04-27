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
	@NamedQuery(name = "UserActions.getComments", query = "SELECT comments FROM UserAction u where u.movieTitle=:pTitle"),
	@NamedQuery(name = "UserActions.getRatings", query = "SELECT ratings FROM UserAction u WHERE u.movieTitle=:pTitle"),
	@NamedQuery(name = "UserActions.getAll", query = "SELECT * FROM UserAction u WHERE u.movieTitle =:pTitle")
})

public class UserActions {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String movieTitle; 
	private String userComments;
	private String userRatings;
	private Date dateOfEntry;
	
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
	public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}
	public String getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(String userRatings) {
		this.userRatings = userRatings;
	}
	public Date getDateOfEntry() {
		return dateOfEntry;
	}
	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

}
