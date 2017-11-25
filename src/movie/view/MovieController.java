package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
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

    public MovieController() {
   
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
