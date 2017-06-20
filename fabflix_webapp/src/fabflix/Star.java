package fabflix;

import java.util.List;

public class Star {
	private int id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String dob;
	private String photoURL;
	private List<Movie> movies;
	
	public Star(int id, String firstName, String lastName, String dob, String photoURL) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + " " + lastName;
		this.dob = dob;
		this.photoURL = photoURL;
	}

	public Star(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + " " + lastName;
		this.dob = "";
		this.photoURL = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
