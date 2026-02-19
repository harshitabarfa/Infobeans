import java.util.*;

class Movie implements Comparable<Movie>
{
	private String title;
	private double rating;
	private int releaseYear;
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public double getRating() 
	{
		return rating;
	}
	
	public void setRating(double rating) 
	{
		this.rating = rating;
	}
	
	public int getReleaseYear() 
	{
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) 
	{
		this.releaseYear = releaseYear;
	}

	public Movie(String title, double rating, int releaseYear) 
	{
		super();
		this.title = title;
		this.rating = rating;
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() 
	{
		return "Movie [title=" + title + ", rating=" + rating + ", releaseYear=" + releaseYear + "]";
	}
	
	public int compareTo(Movie m)
	{
		if(m.getReleaseYear() > this.getReleaseYear())
		{
			return -1;
		}
		else if(m.getReleaseYear() < this.getReleaseYear())
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
}

public class Ass9 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Movie> t = new TreeSet<>();
		
		System.out.print("Enter number of movies: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nMovie " + (i+1) + " : ");
			
			System.out.print("\nEnter title: ");
			String title = sc.nextLine();
			
			System.out.print("Enter rating: ");
			double rating = Double.parseDouble(sc.nextLine());
			
			System.out.print("Enter release year: ");
			int releaseYear = Integer.parseInt(sc.nextLine());
			
			Movie s = new Movie(title, rating, releaseYear);
			t.add(s);
		}
		
		System.out.println("\nMovies sorted by release year (oldest to newest): ");
		for(Movie e : t)
		{
			System.out.println("\n" + e);
		}
	}
}

















