

import java.time.LocalDate;

/**
 * 
 */
public class Feedback {

	public int id ;
	public LocalDate date;
	public int rating;
	public String message;
	
	
	public Feedback(int id,LocalDate date, int rating, String message) {
		this.id = id;
		this.date = date;
		this.rating = rating;
		this.message = message;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
