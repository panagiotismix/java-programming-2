import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class FieldEdit {

	int flag = 0;
	int delCounter, delID, ID = 0;
	String attKind;
	Print printOb = new Print();

	Scanner input = new Scanner(System.in);
	int choice, counter = 0;

		public void chooseList(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {

		do {

			System.out.println("\n0. Go back to main menu.");
			System.out.println("1. Choose a field based on id.");
			System.out.println("2. Print ids.");
			System.out.println("Waiting for your choice: ");

			choice = input.nextInt();

			if (choice == 0) {

				Menu.getMenu(mainList, fieldList, attNameList);

			} else if (choice == 1) {

				System.out.println("\nChoose the field you want to edit: ");
				printEditOptions(mainList, mainList.get(idChoice(mainList)), attNameList);

			} else if ( choice == 2 ) {

				for (int i = 0; i < mainList.size(); i++) {
					System.out.println("\nList N." + (i+1) + ": ID = " + mainList.get(i).get(0) + " Name = " + mainList.get(i).get(1));
					System.out.println();
				}

			} else
		   		System.out.println("Invalid Input, please try again");

		} while (choice <= 0 || choice >= 2 );
		chooseList(mainList, fieldList, attNameList);
	}

	public void printEditOptions(List<ArrayList<String>> mainList,
			ArrayList<String> fieldList, ArrayList<String> attNameList) {

		do {
			System.out.println("\n0. Back to main menu.");
			System.out.println("1. Add attribute.");
			System.out.println("2. Edit existing attribute.");
			System.out.println("3. Delete attribute.");
			System.out.println("Waiting for your choice: ");

			choice = input.nextInt();

			if (choice == 1)
				addNewAttribute(mainList, fieldList, attNameList);
	    	else if (choice == 2 )
	    		editAttribute(mainList, fieldList, attNameList);
	    	else if (choice == 3)
	    		deleteAttribute(mainList, fieldList, attNameList);
	    	else if (choice == 0)
					Menu.getMenu(mainList, fieldList, attNameList);
	    	else
	    		System.out.println("Invalide input, please try again: ");

			}  while (choice < 0 || choice > 3);
	}

	 public void addNewAttribute(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {
		do {
		 	System.out.println("\nEnter the kind of the attribute: ");
		 	attKind = input.next();
			for (int i = 0; i < attNameList.size(); i++) {

				if (attNameList.get(i).equals(attKind))
					flag = 1;
			}

			if (flag != 1) {
				attNameList.add(attKind);
				for (int i = 0; i < mainList.size(); i++) {
					mainList.get(i).add("NO INPUT"); //kainourgies adies theseis se olous tous
				}												  //pinakes gia na diatirite h paralilia

				System.out.println("\nEnter the value of the attribute: ");
				fieldList.set(attNameList.size()-1, input.next());

			} else {
				System.out.println("\nThis kind of attribute already exists.");
				System.out.println("0 to go back.");
				System.out.println("1 to retry.");
				do {
					choice = input.nextInt();
					if (choice == 0) {
						printEditOptions(mainList, fieldList, attNameList);
					} else if (choice == 1) {
						flag = 0;
						addNewAttribute(mainList,fieldList,attNameList);
					} else
						System.out.println("Invalid input, please try again.");
				} while (choice != 0 || choice != 1);
			}
		} while (flag == 1);

		System.out.println("\nWould you like to create another one?");
		System.out.println("0 to go back.");
		System.out.println("1 to repeat.");
		do {
			choice = input.nextInt();
			if (choice == 0) {
				printEditOptions(mainList, fieldList, attNameList);
			} else if (choice == 1)
				addNewAttribute(mainList, fieldList, attNameList); //An epilexthi auto o xristis ftiaxnei
			else 												  //ksana anagastika sthn idia lista
				System.out.println("Invalid input, please try again.");
		} while (choice != 0 || choice != 1);

	 }

	public void editAttribute(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {

		System.out.println("\n0. Back to main menu.");
		System.out.println("1. Choose attribute to edit.");
		System.out.println("2. Print available attributes.");
		System.out.println("Waiting for your choice: ");

		do {

			choice = input.nextInt();

			if (choice == 0)

				Menu.getMenu(mainList, fieldList, attNameList);

		   else if (choice == 1) {

			    System.out.println("Input attribute ID: ");
			    int index = idChoice(fieldList);
				System.out.println("Input new value: ");
				fieldList.set(index, input.next());

		   } else if (choice == 2) {
			   System.out.println("");
			   for (int i = 0; i < fieldList.size(); i++) {
				   if(i > 0)
					System.out.println(i + " " + fieldList.get(i));
			   }

		   } else
	    		System.out.println("Invalid input, please try again: ");

		} while (choice < 0 || choice > 2);

		editAttribute(mainList, fieldList, attNameList);
	}

	public void deleteAttribute(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {

		System.out.println("\n0. Back to main menu.");
		System.out.println("1. Choose attribute to delete.");
		System.out.println("2. Print available attributes.");
		System.out.println("Waiting for your choice: ");

		do {

			choice = input.nextInt();

			if (choice == 0)

				Menu.getMenu(mainList, fieldList, attNameList);

		   else if (choice == 1) {

				System.out.println("Input attribute ID: ");
				fieldList.remove(idChoice(fieldList));

		   } else if (choice == 2) {
			   for (int i = 0; i < fieldList.size(); i++) {
				    if (i > 0)
					System.out.println(i + " " + fieldList.get(i));
			   }
		   } else
		   		System.out.println("Invalid Input, please try again: ");

		} while (choice < 0 || choice > 2);

		deleteAttribute(mainList, fieldList, attNameList);

	}

	public void newField(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {

		ArrayList<String> newFieldList = new ArrayList<String> ();
		newFieldList.add(0, String.valueOf(ID));
		ID++;
		System.out.println("\nInput the name of the new field: ");
		newFieldList.add(1, input.next());
		mainList.add(newFieldList);

		for (int i = 0; i < attNameList.size(); i++) {
			if (i > 1)
				newFieldList.add("NO INPUT"); //dimiourgia kenwn thesewn gia diatirisi paralilias
		}
		System.out.println("\nList added successfuly!");
		System.out.println();
		Menu.getMenu(mainList, fieldList, attNameList);

	} //pithanon na xriasti uperofortosi gia na mporei na kaleite apo alles klasis autonoma

	public void deleteField(List<ArrayList<String>> mainList,
			ArrayList<String> fieldList, ArrayList<String> attNameList) {

		System.out.println("\n0. Go back.");
		System.out.println("1. Print all fields.");
		System.out.println("2. Delete a single field.");
		System.out.println("3. Delete multiple fields.");

		do {

			choice = input.nextInt();

			if (choice == 0)
				Menu.getMenu(mainList, fieldList, attNameList);

		   else if (choice == 1) {

				printOb.ShowComplete(mainList, fieldList, attNameList);

		   } else if (choice == 2) {

				System.out.println("Input the id of the field you wish to delete: ");
				mainList.remove(idChoice(mainList));
				System.out.println("Field deleted Succesfuly");


		   } else if (choice == 3) {

				System.out.println("WARNING!!!!! This method only works if you input each individual ID with increasing order.");
				System.out.println();
			   	delCounter = 0;
				System.out.println("Input the number of the fields you wish to delete: ");
				System.out.println();

				for (int i = idChoice(mainList); i > 0; i--) {
					System.out.println("Input the id of the field you wish to delete: ");
					mainList.remove(input.nextInt() - delCounter); //delCounter gia na antistathmizi to delete kathe listas me to kainourio id
					delCounter++;
					System.out.println();
				}
		   } else
		   		System.out.println("Invalid Input, please try again: ");

		} while (choice < 0 || choice > 3);

		deleteField(mainList, fieldList, attNameList);

	}

	public int idChoice(List<ArrayList<String>> mainList) {

		do {
			choice = input.nextInt();
			if (choice < 0 || choice > mainList.size()-1)
	    		System.out.println("Invalid input, please try again: ");

	    } while (choice < 0 || choice > mainList.size()-1);
		return choice;
	}

	public int idChoice(ArrayList<String> fieldList) {

		do {
			choice = input.nextInt();
			if (choice < 0 || choice > fieldList.size()-1)
	    		System.out.println("Invalid input, please try again: ");

	    } while (choice < 0 || choice > fieldList.size()-1);
		return choice;
	}

}
