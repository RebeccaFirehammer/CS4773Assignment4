package movie.model;

public class Movie extends MovieObserver{
	
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
			movieInstance = new Movie();
		}
		return movieInstance;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void registration(){
		//Forward the calls to MovieObserver.update()
	}
	
	public void unregistration(){
		//Forward the calls to MovieObserver.update()
	}
}
