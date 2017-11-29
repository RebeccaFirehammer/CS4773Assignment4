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
import movie.model.MovieObserver;
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
    
    private MovieObserver movieObserver;

    public MovieController(MovieObserver movieObserver) {
    	this.movieObserver = movieObserver;
    	movieObserver.addObserver(this);
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

	@Override
	public void update(Observable o, Object arg) {
		if (!movieTitle.getText().equals(((MovieObserver) o).getMovieTitle()))
			movieTitle.setText(((MovieObserver) o).getMovieTitle());

		if (!director.getText().equals(((MovieObserver) o).getDirector()))
			director.setText(((MovieObserver) o).getDirector());

		if (releaseYear.getText().equals("") || Integer.parseInt(releaseYear.getText()) != ((MovieObserver) o).getReleaseYear())
			releaseYear.setText(String.valueOf(((MovieObserver) o).getReleaseYear()));

		if (!writer.getText().equals(((MovieObserver) o).getWriter()))
			writer.setText(((MovieObserver) o).getWriter());
		
		if(ratingSlider.getLayoutX() != ((MovieObserver) o).getRating())
			ratingSlider.adjustValue(((MovieObserver) o).getRating());
	}

}
