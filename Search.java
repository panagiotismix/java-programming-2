import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Search {
	
	public static void main(String[] args) {
		
		//ΠΑΡΑΔΕΙΓΜΑ
		List <String> FieldList = new ArrayList<>(); // λίστα στον αρέα
		FieldList.add("Όνομα");
		FieldList.add("Επίθετο");
		FieldList.add("Ηλικία");
		
		List <ArrayList> MainList = new ArrayList<>();
		
		List <String> templist1 = new ArrayList<>();
		templist1.add("Γρηγόρης");
		templist1.add("Σακαλίδης");
		templist1.add("21");
		
		List<String> templist2 = new ArrayList<>();
		templist2.add("Βασίλης");
		templist2.add("Σακαλίδης");
		templist2.add("26");
		
		MainList.add((ArrayList) templist1);
		MainList.add((ArrayList) templist2);
		//ΤΕΛΟΣ ΠΑΡΑΔΕΙΓΜΑΤΟΣ
		
		SearchMenu(FieldList, MainList);
	}
		
	//παραμετρική συνάρτηση, χρειάζεται ορίσματα από το πρόγραμμα, δεν επιστρέφει τίποτα!
	public static void SearchMenu(List<String> fieldlist, List<ArrayList> mainlist) {
		
		Scanner input = new Scanner(System.in);
		int choice=0;
		
		System.out.println("Διαλέξετε μέθοδο παρουσίασης της βάσης δεδομένων σας:");
		System.out.println("Ολική παρουσίαση (1).");
		System.out.println("Παρουσίαση με συγκεκριμένο χαρακτηριστικό (2).");
		System.out.println("Εισάγεται (0) για να επιστρέψετε στο αρχικό μενού.");
		
		do {
			System.out.print("Διαλέξτε ένα από τα παραπανω: ");
			choice = input.nextInt();
			}while(!(choice ==0 || choice ==1 || choice ==2) );
		switch (choice) 
		{
		
		case 0:
			SearchMenu(fieldlist, mainlist);
		break;
		
		case 1:	
			ShowComplete(fieldlist,mainlist);
		break;
		
		case 2:
			ShowSelected(fieldlist,mainlist);
		break;
		} //end of switch
	}
	
	public static void ShowComplete(List<String> fieldlist1, List<ArrayList> mainlist1) {
		int fsize = fieldlist1.size(); //fieldlist size
		int msize = mainlist1.size(); //mainlist size
		
		for (int i=0; i<fsize; i++) {
			System.out.print(fieldlist1.get(i)+ " ");
		}
		for (int i =0; i<msize;i++) {
			System.out.println();
			for (int j =0;j<fsize; j++)
			{
				System.out.print(mainlist1.get(i).get(j)+ " ");
			}
		}
		
	}
	public static void ShowSelected(List<String> fieldlist1, List<ArrayList> mainlist1) {
		
		Scanner input = new Scanner(System.in);
		int choice=0;

		int fsize = fieldlist1.size(); //fieldlist size
		int msize = mainlist1.size(); //mainlist size
		
		System.out.println("Επιλέξτε το χαρακτηριστικό με το οποίο θέλετε να κάνετε αναζήτηση: ");
		for (int i =0; i<fsize; i++)
		{
			System.out.print(fieldlist1.get(i) + "(" + i + ") ");
		}
		System.out.println("Επιλογή: ");
		choice = input.nextInt();
		System.out.println("Εμφάνιση στοιχείων χαρακτηριστικού: " + fieldlist1.get(choice));
		for (int i=0; i<msize;i++) 
		{
			System.out.print(mainlist1.get(i).get(choice)+"(" +i+") ");
		}
		System.out.println();
		System.out.println("Κάντε την επιλογή σας: ");
		choice = input.nextInt();
		for (int i=0; i<fsize; i++) {
			System.out.print(fieldlist1.get(i)+ " ");
		}
		System.out.println();
		for (int j =0;j<fsize; j++)
		{
			System.out.print(mainlist1.get(choice).get(j)+ " ");
		}
	}
}
