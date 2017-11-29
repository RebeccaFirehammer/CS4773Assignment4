package movie.model;

import java.util.Observable;

public class MovieObservable extends Observable{
	
	private Movie movieInstance;
	
	public MovieObservable(){
		movieInstance = Movie.getInstance();
	}
	
	public Movie getMovieInstance(){
		return movieInstance;
	}
	
	public void setMovieTitle(String movieTitle) {	
		movieInstance.setMovieTitle(movieTitle);
		setChanged();
		notifyObservers();
	}

	public void setReleaseYear(int releaseYear) {
		movieInstance.setReleaseYear(releaseYear);
		setChanged();
		notifyObservers();
	}


	public void setDirector(String director) {
		movieInstance.setDirector(director);
		setChanged();
		notifyObservers();
	}


	public void setWriter(String writer) {
		movieInstance.setWriter(writer);
		setChanged();
		notifyObservers();
	}

	public void setRating(int rating) {
		movieInstance.setRating(rating);
		setChanged();
		notifyObservers();
	}

}
