
import java.util.*;

class Hall implements Comparable<Hall>
{
	private String name;
	private String contactNumber;
	private double costPerDay;
	private String ownerName;
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getContactNumber() 
	{
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) 
	{
		this.contactNumber = contactNumber;
	}

	public double getCostPerDay() 
	{
		return costPerDay;
	}

	public void setCostPerDay(double costPerDay) 
	{
		this.costPerDay = costPerDay;
	}

	public String getOwnerName() 
	{
		return ownerName;
	}

	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
	}

	public String toString() 
	{
		return "Hall [name=" + name + ", contactNumber=" + contactNumber + ", costPerDay=" + costPerDay + ", ownerName="
				+ ownerName + "]";
	}

	public int hashCode() 
	{
		return Objects.hash(contactNumber, costPerDay, name, ownerName);
	}

	public Hall(String name, String contactNumber, double costPerDay, String ownerName) 
	{
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.costPerDay = costPerDay;
		this.ownerName = ownerName;
	}
	
	public Hall() 
	{
		super();
	}

	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hall other = (Hall) obj;
		return Objects.equals(contactNumber, other.contactNumber)
				&& Double.doubleToLongBits(costPerDay) == Double.doubleToLongBits(other.costPerDay)
				&& Objects.equals(name, other.name) && Objects.equals(ownerName, other.ownerName);
	}
	
	public int compareTo(Hall h)
	{
		if(h.getCostPerDay() > this.costPerDay)
		{
			return -1;
		}
		else if(h.getCostPerDay() < this.costPerDay)
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
}

public class Ass5
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of halls: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		HashMap<String, Hall> a = new HashMap<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.print("\nHall " + (i+1) + " : ");
			
			System.out.print("\nEnter hall name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter contact number: ");
			String contactNumber = sc.nextLine();
			
			System.out.print("Enter cost per day: ");
			double costPerDay = Double.parseDouble(sc.nextLine());
			
			System.out.print("Enter owner name: ");
			String ownerName = sc.nextLine();
			
			Hall h1 = new Hall(name, contactNumber, costPerDay, ownerName);
			a.put(name, h1);
		}
		
		ArrayList<Hall> l = new ArrayList<>(a.values());
		Collections.sort(l);
		
		System.out.println("\nDisplay details: ");
		for(Hall h: l)
		{
			System.out.println(h);
		}	
	}
}
















