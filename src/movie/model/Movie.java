package movie.model;

import java.util.Observable;

public class Movie extends Observable{
	
	private MovieObserver movObs;
	private static Movie movieInstance;
	private static String movieTitle;
	private static int releaseYear;
	private static String director;
	private static String writer;
	private static int rating;
	
	private Movie() {

	}
	
	public static Movie getInstance(){
		if(movieInstance == null){
			synchronized(Movie.class){
				if(movieInstance == null){
					movieInstance = new Movie();
				}
			}
		}
		return movieInstance;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {	
		Movie.movieTitle = movieTitle;
		System.out.println("Setting movie title to " + Movie.movieTitle);
		setChanged();
		//movObs.update(this, this);
		notifyObservers();
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		Movie.releaseYear = releaseYear;
		setChanged();
		notifyObservers();
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		Movie.director = director;
		setChanged();
		notifyObservers();
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		Movie.writer = writer;
		setChanged();
		notifyObservers();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		Movie.rating = rating;
		setChanged();
		notifyObservers();
	}
}
