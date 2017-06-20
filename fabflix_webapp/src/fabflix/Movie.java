package fabflix;

public class Movie
{
	private int id;
	private String title;
	private int year;
	private String director;
	private String bannerURL;
	private String trailerURL;
	
	public Movie(int id, String title, int year, String director)
	{
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.bannerURL = "";
		this.trailerURL = "";
	}


	public Movie(int id, String title, int year, String director, String bannerURL, String trailerURL)
	{
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.bannerURL = bannerURL;
		this.trailerURL = trailerURL;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}


	public int getYear()
	{
		return year;
	}


	public void setYear(int year)
	{
		this.year = year;
	}


	public String getDirector()
	{
		return director;
	}


	public void setDirector(String director)
	{
		this.director = director;
	}


	public String getBannerURL()
	{
		return bannerURL;
	}


	public void setBannerURL(String bannerURL)
	{
		this.bannerURL = bannerURL;
	}


	public String getTrailerURL()
	{
		return trailerURL;
	}


	public void setTrailerURL(String trailerURL)
	{
		this.trailerURL = trailerURL;
	}


	@Override
	public String toString()
	{
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", director=" + director + ", bannerURL="
				+ bannerURL + ", trailerURL=" + trailerURL + "]";
	}
	
}
