import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class DemoCode {


	Scanner input = new Scanner(System.in);
	int choice, counter = 0;

	List <String> CharNameList = new ArrayList <String>();



	List <List<String>> mainList = new ArrayList <List<String>>();

	public static void main(String[] args) {

		DemoCode mainObject = new DemoCode();

		mainObject.menu();

	}

	public void menu() {
		System.out.println("******Menu******");
		System.out.println("1. Field creation.");
		System.out.println("2. Print fields.");
		System.out.println("3. Attribute Creation.");
    	System.out.println("Waiting for your input, 0 to exit: ");

    	do {

    	choice = input.nextInt();

    	if (choice == 1)
    		newField();
    	else if (choice == 2 )
    		printFieldLists();
    	else if (choice == 3)
    		chooseList();
    	else if (choice == 0)
    		System.exit(0);
    	else
    		System.out.println("Try again.");
    	}
    	 while (choice > 3 || choice < 0);

	}


	 public void newField() {

		List <String> fieldList = new ArrayList <String> ();

		fieldList.add(String.valueOf(counter));
		counter++;
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
				System.out.println();
				System.out.println("Field N." + x);
				for (int y = 0; y < mainList.get(i).size(); y++) {
					System.out.println(mainList.get(i).get(y));
				}
			}
			System.out.println();
			System.out.println("Press 0 to return: "); {
				choice = input.nextInt();
				if (choice == 0)
					menu();
			}
	 }

	public void chooseList() {
		System.out.println("Choose the field you want: ");
		addNewAttribute( (List<String>) mainList.get(choice = input.nextInt()));
	}

	 public void addNewAttribute(List<String> fieldList) {

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
