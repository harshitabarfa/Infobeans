import java.util.*;

class MovieComparator implements Comparator<Movie>
{
	public int compare(Movie m1, Movie m2)
	{
		return Double.compare(m1.getRating(), m2.getRating());
	}
}

class Movie
{
	private String title;
	private int releaseYear;
	private double rating;
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public int getReleaseYear() 
	{
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) 
	{
		this.releaseYear = releaseYear;
	}
	
	public double getRating() 
	{
		return rating;
	}
	
	public void setRating(double rating) 
	{
		this.rating = rating;
	}

	public Movie(String title, int releaseYear, double rating) 
	{
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}

	public Movie() 
	{
		super();
	}
}

public class Ass6 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Movie> a = new ArrayList<Movie>();
		
		System.out.print("Enter number of movies: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("Movie " + (i+1) + ": ");
			
			System.out.print("Enter the title: ");
			String title = sc.nextLine();
			
			System.out.print("Enter the release year: ");
			int releaseYear = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter rating: ");
			double rating = Double.parseDouble(sc.nextLine());
			
			Movie m = new Movie(title, releaseYear, rating);
			a.add(m);
		}
		
		Collections.sort(a, new MovieComparator());
		
		System.out.println("\nDisplay the movies in the sorted order: ");
		for(Movie m3 : a)
		{
			System.out.println("Title: " + m3.getTitle() + ", Release year: " + m3.getReleaseYear() + ", Rating: " + m3.getRating());
		}
	}
}

















