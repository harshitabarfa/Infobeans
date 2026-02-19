import java.util.ArrayList;
import java.util.Scanner;

class Hospital
{
	private int patientId;
	private String patientName;
	private String disease;
	private int age;
	
	public int getPatientId() 
	{
		return patientId;
	}
	
	public void setPatientId(int patientId) 
	{
		this.patientId = patientId;
	}
	
	public String getPatientName() 
	{
		return patientName;
	}
	
	public void setPatientName(String patientName) 
	{
		this.patientName = patientName;
	}
	
	public String getDisease() 
	{
		return disease;
	}
	
	public void setDisease(String disease) 
	{
		this.disease = disease;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}

	public Hospital(int patientId, String patientName, String disease, int age) 
	{
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.disease = disease;
		this.age = age;
	}

	public String toString() 
	{
		return "Hospital [patientId=" + patientId + ", patientName=" + patientName + ", disease=" + disease + ", age="
				+ age + "]";
	}
}

public class Ass1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		ArrayList<Hospital> h = new ArrayList<Hospital>();
		
		System.out.println();
		for (int i = 0; i < size; i++) 
		{
			System.out.println("Add Patient " + (i + 1) + ":");
			
			System.out.print("Enter Patient Id: ");
			int patientId = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter Patient Name: ");
			String patientName = sc.nextLine();

			System.out.print("Enter Disease: ");
			String disease = sc.nextLine();

			System.out.print("Enter Patient Age: ");
		    int age = sc.nextInt();
			
			Hospital h1 = new Hospital(patientId, patientName, disease, age);
			h.add(h1);

			System.out.println();
		}
		
		for(Hospital h2 : h)
		{
			System.out.println("Display All Patient details : " + h2);
		}
		sc.nextLine();
		
		System.out.print("\nSearch patients by disease name: ");
		String h3 = sc.nextLine();

		for (Hospital d : h) 
		{
		    if (d.getDisease().equalsIgnoreCase(h3)) 
		    {
		        System.out.println(d);
		    }
		}
		
		System.out.print("\nEnter patient id to discharged a patient: ");
		int removeId = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < h.size(); i++) 
		{
			if (h.get(i).getPatientId() == removeId) 
			{
				h.remove(i);
				break;
			}
			else
			{
				System.out.println("Patient id are not exist");
			}
		}
		
		System.out.println("\nAfter removed ArrayList is: ");
		System.out.println(h);
		
		if (!h.isEmpty()) 
		{
		    Hospital youngest = h.get(0);
		    for (Hospital patient : h) 
		    {
		        if (patient.getAge() < youngest.getAge()) 
		        {
		            youngest = patient;
		        }
		    }
		    System.out.println("\nYoungest Patient: " + youngest);
		}

	}
}
