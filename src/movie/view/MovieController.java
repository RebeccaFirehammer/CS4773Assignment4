package movie.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class MovieController implements Initializable {
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

    public MovieController() {
   
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addFieldListeners();
	}
    
    public void addFieldListeners(){
    	addMovieFieldListener();
    	addReleaseYearListener();
    	addDirectorListener();
    	addWriterListener();
    	addRatingListener();
    	addRatingSliderListener();
    }
    
    private void addRatingSliderListener(){
    	ratingSlider.pressedProperty().addListener((obs, oldText, newText) -> {
    		try{
    			System.out.println("Rating Slider was pressed");
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Rating.");
    		}
    	});
    }
    
    private void addMovieFieldListener(){
    	movieTitle.textProperty().addListener((obs, oldText, newText) -> {
    		try{
    			movieTitleString = movieTitle.getText();
    			System.out.println(movieTitleString);
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Movie Title.");
    		}
    	});
    }
    
    private void addReleaseYearListener(){
    	releaseYear.textProperty().addListener((obs, oldText, newText) -> {
    		try{
    			releaseYearInt = Integer.parseInt(releaseYear.getText());
    			System.out.println(releaseYearInt);
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Release Year.");
    		}
    	});
    }
    
    private void addDirectorListener(){
    	director.textProperty().addListener((obs, oldText, newText) -> {
    		try{
    			directorString = director.getText();
    			System.out.println(directorString);
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Director Name.");
    		}
    	});
    }
    
    private void addWriterListener(){
    	writer.textProperty().addListener((obs, oldText, newText) -> {
    		try{
    			writerString = writer.getText();
    			System.out.println(writerString);
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Writer Name.");
    		}
    	});
    }
    
    private void addRatingListener(){
    	ratingText.textProperty().addListener((obs, oldText, newText) -> {
    		try{
    			ratingInt = Integer.parseInt(ratingText.getText());
    			System.out.println(ratingInt);
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Movie Rating.");
    		}
    	});
    }

}
