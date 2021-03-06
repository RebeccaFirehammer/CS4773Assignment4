package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import movie.model.Movie;
import movie.model.MovieObservable;

import javafx.fxml.Initializable;

public class MovieController implements Initializable, Observer {
    @FXML
    private TextField movieTitle; 

    @FXML
    private TextField releaseYear;
    
    private int releaseYearInt;
    
    @FXML
    private TextField director;

    @FXML
    private TextField writer;

    @FXML
    private Label ratingText;

    @FXML
    private Slider ratingSlider;
    
    private MovieObservable movieObserver;


    public MovieController(MovieObservable movieObserver) {
    	this.movieObserver = movieObserver;
    }
    
	@Override
	public void update(Observable o, Object obj) {
		if(o instanceof MovieObservable){
			Movie movie = ((MovieObservable) o).getMovieInstance();
			movieTitle.setText(movie.getMovieTitle());
			releaseYear.setText(Integer.toString(movie.getReleaseYear()));
			writer.setText(movie.getWriter());
			director.setText(movie.getDirector());
			ratingSlider.setValue(movie.getRating());
		}
		
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addTextFieldListeners();
	}
	
	public void addTextFieldListeners() {
		addReleaseYearListener();
		addMovieFieldListener();
		addDirectorListener();
		addWriterListener();	
		addRatingListener();
	}
	
	public void addReleaseYearListener(){
    	releaseYear.textProperty().addListener((obs, oldText, newText) -> {
    		if(releaseYear.getText().matches("^\\d+$")
				|| releaseYear.getText().equals("")) {
    			releaseYear.setText(newText);
    			if(!releaseYear.getText().equals(""))
    				releaseYearInt = Integer.parseInt(newText);
    			else
    				releaseYearInt = 0;
    			movieObserver.setReleaseYear(releaseYearInt);

    		}
    		else {
    			releaseYear.setText(oldText);
    			System.err.println("Invalid release year, only numeric values are allowed.");
    		}
    	});
	}
	 
	 private void addMovieFieldListener(){
	 	movieTitle.textProperty().addListener((obs, oldText, newText) -> {
	 		movieObserver.setMovieTitle(newText);
	 	});
	 }
	 
	 private void addDirectorListener(){
	 	director.textProperty().addListener((obs, oldText, newText) -> {
	 		movieObserver.setDirector(newText);
	 	});
	 }
	 
	 private void addWriterListener(){
	 	writer.textProperty().addListener((obs, oldText, newText) -> {
	 		movieObserver.setWriter(newText);
	 	});
	 }
	 
	 private void addRatingListener(){
		 ratingSlider.valueProperty().addListener(new ChangeListener<Object>() {
		        public void changed(ObservableValue<?> movieStat, Object oldPropertyValue, Object newPropertyValue) {
		        	ratingText.textProperty().setValue(String.valueOf((int) ratingSlider.getValue()));
		        	movieObserver.setRating(Integer.parseInt((ratingText.getText())));
		        }
		    });
	 }

}
