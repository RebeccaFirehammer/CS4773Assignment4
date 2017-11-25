package movie.model;

import java.util.Observable;
import java.util.Observer;

public class Movie implements Observer{
	
	private static Movie movieInstance = null;
	private static String movieTitle;
	private static int releaseYear;
	private static String director;
	private static String writer;
	private static int rating;
	
	public Movie() {

	}
	
	public static Movie getInstance(){
		if(movieInstance == null){
			movieInstance = new Movie();
		}
		return movieInstance;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
