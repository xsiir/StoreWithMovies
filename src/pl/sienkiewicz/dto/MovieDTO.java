package pl.sienkiewicz.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MOVIES")
@Table(name = "MOVIES")
public class MovieDTO {

	@Id
	@Column
	private Integer id;
	@Column
	private String title;
	@Column
	private String category;
	@Column
	private char[] year;
	@Column
	private String cast;
	@Column
	private String director;
	@Column
	private String story;
	@Column
	private double price;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getYear() {
		String year = "";
		for(char c  : this.year) {
			year += c;
		}
		return year.toString();
	}
	public void setYear(char[] year) {
		this.year = year;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return this.getId() + " | " + this.getTitle() + " | " + this.getStory();
	}
	

}
