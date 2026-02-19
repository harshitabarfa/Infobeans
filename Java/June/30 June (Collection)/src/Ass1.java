import java.util.*;

class SortByMatchesPlayed implements Comparator<Player>
{
	public int compare(Player o1, Player o2)
	{
		return Integer.compare(o2.getMatchesPlayed(), o1.getMatchesPlayed());
	}
}

class SortByPlayerName implements Comparator<Player>
{
	public int compare(Player o1, Player o2)
	{
		return o1.getPlayerName().compareToIgnoreCase(o2.getPlayerName());
	}
}

class Player implements Comparable<Player>
{
	private int playerId;
	private String playerName;
	private int matchesPlayed;
	private double averageScore;
	
	public int getPlayerId() 
	{
		return playerId;
	}
	
	public void setPlayerId(int playerId) 
	{
		this.playerId = playerId;
	}
	
	public String getPlayerName() 
	{
		return playerName;
	}
	
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}
	
	public int getMatchesPlayed() 
	{
		return matchesPlayed;
	}
	
	public void setMatchesPlayed(int matchesPlayed) 
	{
		this.matchesPlayed = matchesPlayed;
	}
	
	public double getAverageScore() 
	{
		return averageScore;
	}
	
	public void setAverageScore(double averageScore) 
	{
		this.averageScore = averageScore;
	}

	public Player(int playerId, String playerName, int matchesPlayed, double averageScore) 
	{
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.averageScore = averageScore;
	}

	@Override
	public String toString() 
	{
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", matchesPlayed=" + matchesPlayed
				+ ", averageScore=" + averageScore + "]";
	}
	
	public int compareTo(Player p)
	{
		if(p.getAverageScore() > this.getAverageScore())
		{
			return +1;
		}
		else if(p.getAverageScore() < this.getAverageScore())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number of players: ");
		int n = Integer.parseInt(sc.nextLine());
		
		ArrayList<Player> a = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nPlayer " + (i+1) + " : ");
			
			System.out.print("Enter player id: ");
			int playerId = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter player name: ");
			String playerName = sc.nextLine();
			
			System.out.print("Enter matches played: ");
			int matchesPlayed = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter player average scores: ");
			double averageScore = Double.parseDouble(sc.nextLine());
			
			Player p1 = new Player(playerId, playerName, matchesPlayed, averageScore);
			a.add(p1);
		}
		
		System.out.println("\nOriginal list: ");
		for(Player p2 : a)
		{
			System.out.println(p2);
		}
		
		Collections.sort(a);
		System.out.println("\nSorted by average score: ");
		for(Player p2 : a)
		{
			System.out.println(p2);
		}
		
		Collections.sort(a, new SortByMatchesPlayed());
		System.out.println("\nSorted by matches played (Descending): ");
		for(Player p2 : a)
		{
			System.out.println(p2);
		}
		
		Collections.sort(a, new SortByPlayerName());
		System.out.println("\nSorted by player name (alphabetic): ");
		for(Player p2 : a)
		{
			System.out.println(p2);
		}
	}
}














