package movie.model;

import java.util.Observer;

public class Movie{
	
	private MovieObservable movieObserver;
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
	
	public void register(Observer o){
		movieObserver.addObserver(o);
	}
	
	public void unregister(Observer o){
		movieObserver.deleteObserver(o);
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {	
		Movie.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		Movie.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		Movie.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		Movie.writer = writer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		Movie.rating = rating;
	}
}
