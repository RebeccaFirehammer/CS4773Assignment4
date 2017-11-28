package movie.model;

import java.util.Observable;
import java.util.Observer;

//This is the delegate that handles Movie's update function

public class MovieObserver implements Observer{
	
	private Movie movieInstance;
	
	@Override
	public void update(Observable observable, Object arg) {
		movieInstance = (Movie) observable;
		System.out.println(movieInstance.getMovieTitle());
	}

}
