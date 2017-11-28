package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
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
	}
	
	public void addReleaseYearListener(){
    	releaseYear.textProperty().addListener((obs, oldText, newText) -> {
    		if(releaseYear.getText().matches("^\\d+$")
				|| releaseYear.getText().equals("")) {
    			releaseYear.setText(newText);
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
}
