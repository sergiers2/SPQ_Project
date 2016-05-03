

public class Movie {
	int movie_ID;
	String name;
	String description;
	String rating;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}
	
	public int getMovie_ID() {
		return movie_ID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	
	function to be called from ratingFilm after clicking the ok button.

	public String getRating() { return rating; }
	
	public void RateFilm( String rating ){
		double d1 = Double.parseDouble(rating);
		double d2 = Double.parseDouble(this.rating);
		d2=(d1+d2)/2;
		this.rate=Double.toString(d2);
	}

}
