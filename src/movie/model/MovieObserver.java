package movie.model;

import java.util.Observable;

public class MovieObserver extends Observable{
	
	private Movie movieInstance;
	
	public MovieObserver() {
		movieInstance = Movie.getInstance();
	}
	
	public void setReleaseYear(int releaseYearInt) {
		movieInstance.setReleaseYear(releaseYearInt);
		this.setChanged();
		this.notifyObservers();		
	}

	public void setRating(int parseInt) {
		movieInstance.setRating(parseInt);
		this.setChanged();
		this.notifyObservers();
	}

	public void setWriter(String writerString) {
		movieInstance.setWriter(writerString);
		this.setChanged();
		this.notifyObservers();
	}

	public void setDirector(String directorString) {
		movieInstance.setDirector(directorString);
		this.setChanged();
		this.notifyObservers();
	}

	public void setMovieTitle(String movieTitleString) {
		movieInstance.setMovieTitle(movieTitleString);
		this.setChanged();
		this.notifyObservers();
	}

	public String getMovieTitle() {
		return movieInstance.getMovieTitle();
	}
	
	public int getReleaseYear() {
		return movieInstance.getReleaseYear();
	}
	
	public int getRating() {
		return movieInstance.getRating();
	}
	
	public String getWriter() {
		return movieInstance.getWriter();
	}
	
	public String getDirector() {
		return movieInstance.getDirector();
	}

}
