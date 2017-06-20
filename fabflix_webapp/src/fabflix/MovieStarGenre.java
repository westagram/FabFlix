package fabflix;

import java.util.List;

public class MovieStarGenre {
	private int movie_id;
	private String title;
	private int year;
	private String director;
	private String bannerURL;
	private String trailerURL;
	private List<Star> stars;
	private List<Genres> genres;
	
	public MovieStarGenre(int movie_id, String title, int year, String director, String bannerURL, String trailerURL) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.bannerURL = bannerURL;
		this.trailerURL = trailerURL;
		this.stars = null;
		this.genres = null;
	}

	public MovieStarGenre(int movie_id, String title, int year, String director) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.bannerURL = "";
		this.trailerURL = "";
		this.stars = null;
		this.genres = null;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getBannerURL() {
		return bannerURL;
	}

	public void setBannerURL(String bannerURL) {
		this.bannerURL = bannerURL;
	}

	public String getTrailerURL() {
		return trailerURL;
	}

	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}

	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	public List<Genres> getGenres() {
		return genres;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}
	
}
