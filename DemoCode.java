import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class DemoCode {


	Scanner input = new Scanner(System.in);
	int choice;

	List <String> CharNameList = new ArrayList <String>();


	//Δημιουργια κεντρικης λιστας
	List <List> mainList = new ArrayList <List>();

	public static void main(String[] args) {

		Main mainObject = new Main();

		mainObject.menu();

	}

	public void menu() {
		System.out.println("******Menu******");
		System.out.println("1. Field creation.");
		System.out.println("2. Print fields.");
		System.out.println("3. Attribute Creation.");
    	System.out.println("Waiting for your input, 0 to exit: ");

    	choice = input.nextInt();

    	if (choice == 1)
    		newField();
    	else if (choice == 2 )
    		printFieldLists();
    	else if (choice == 3)
    		chooseList();
    	else if (choice == 0)
    		System.exit(0);
	}

//Δημιουργια καινουριου παιδιου

	 public void newField() {

		List <String> fieldList = new ArrayList <String> ();

		System.out.println("Enter a name: ");
		input.nextLine();
		fieldList.add(input.nextLine());
		mainList.add(fieldList);
		System.out.println("Would you like to create another one?");
		System.out.println("1. Yes.");
		System.out.println("2. Back.");
		choice = input.nextInt();
		if (choice == 1)
			newField();
		else if (choice == 2)
			menu();

		 }

	 public void printFieldLists( ) {
			for (int i = 0; i < mainList.size(); i++) {
				int x = i + 1;
				System.out.println("Field Ν." + x);
				for (int y = 0; y < mainList.get(i).size(); y++) {
					System.out.println(mainList.get(i).get(y));
				}
			}
			System.out.println("Press 0 to return: "); {
				choice = input.nextInt();
				if (choice == 0)
					menu();
			}
	 }

//Για σιμπλισιτι αυτη τη στιγμη θα ψαχνει με τη θεση στη μεινλιστ
	public void chooseList() {
		System.out.println("Choose the field you want: ");
		addNewAttribute(mainList.get(choice = input.nextInt()));
	}

//Προσθηκη χαρακτηριστικου
	 public void addNewAttribute(List fieldList) {

		 String AtName;

		 System.out.println("Input your value: ");
     	 input.nextLine();
		 AtName = input.nextLine();

		 fieldList.add(AtName);

		 System.out.println("Would you like to create another one?");
			System.out.println("1. Yes.");
			System.out.println("2. Back.");
			choice = input.nextInt();
			if (choice == 1)
				chooseList();
			else if (choice == 2)
				menu();
	 }
}
