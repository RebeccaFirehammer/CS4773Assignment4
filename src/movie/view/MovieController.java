package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import movie.model.Movie;
import javafx.fxml.Initializable;

public class MovieController extends Observable implements Initializable {
    @FXML
    private TextField movieTitle; 
    
    private String movieTitleString;

    @FXML
    private TextField releaseYear;
    
    private int releaseYearInt;
    
    @FXML
    private TextField director;
    
    private String directorString;

    @FXML
    private TextField writer;
    
    private String writerString;

    @FXML
    private Label ratingText;
    
    private int ratingInt;

    @FXML
    private Slider ratingSlider;
    
    private Movie movieInstance;

    public MovieController() {
    	movieInstance = Movie.getInstance();
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
    			releaseYearInt = Integer.parseInt(newText);
    			movieInstance.setReleaseYear(releaseYearInt);
    		}
    		else {
    			releaseYear.setText(oldText);
    			System.err.println("Invalid release year, only numeric values are allowed.");
    		}
    	});
	}
	 
	 private void addMovieFieldListener(){
	 	movieTitle.textProperty().addListener((obs, oldText, newText) -> {
	 		movieTitleString = movieTitle.getText();
	 		movieInstance.setMovieTitle(movieTitleString);
	 	});
	 }
	 
	 private void addDirectorListener(){
	 	director.textProperty().addListener((obs, oldText, newText) -> {
	 		directorString = director.getText();
	 		movieInstance.setDirector(directorString);
	 	});
	 }
	 
	 private void addWriterListener(){
	 	writer.textProperty().addListener((obs, oldText, newText) -> {
	 		writerString = writer.getText();
	 		movieInstance.setWriter(writerString);
	 	});
	 }
	 
	 private void addRatingListener(){
		 ratingSlider.valueProperty().addListener(new ChangeListener<Object>() {
		        public void changed(ObservableValue<?> movieStat, Object oldPropertyValue, Object newPropertyValue) {
		        	ratingText.textProperty().setValue(String.valueOf((int) ratingSlider.getValue()));
		        	movieInstance.setRating(Integer.parseInt((ratingText.getText())));
		        }
		    });
	 }
	 
}
