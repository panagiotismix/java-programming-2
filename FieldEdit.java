
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class FieldEdit {

	int flag = 0;
	Menu mainObject = new Menu();
	Scanner input = new Scanner(System.in);
	int choice, counter = 0;

	public void printEditOptions(List<List<String>> mainList, List<String> fieldList, List<String> attNameList) {

		do {
			System.out.println("0. Back to main menu.");
			System.out.println("1. Add attribute.");
			System.out.println("2. Edit existing attribute.");
			System.out.println("3. Delete attribute.");
			System.out.println("4. Add field.");
			System.out.println("Waiting for your choice: ");

			choice = input.nextInt();

			if (choice == 1)
				addNewAttribute(mainList, fieldList, attNameList);
	    	else if (choice == 2 )
	    		editAttribute(fieldList);
	    	else if (choice == 3)
	    		deleteAttribute(fieldList);
	    	else if (choice == 0)
				mainObject.menu();
	    	else
	    		System.out.println("Invalide input, please try again: ");
	    	}  while (choice <= 0 || choice >= 4);


		}


	 public void addNewAttribute(List<List<String>> mainList, List<String> fieldList, List<String> attNameList) {
		 
		do {
		 
		 	System.out.println("Enter the kind of the attribute: ");
			
			for (int i = 0; i < attNameList.size(); i++) {
				
				if (attNameList.get(i).equals(input.nextLine()))
					flag = 1;
			}
			
			if (flag != 1) {
				attNameList.add(input.nextLine());
				for (int i = 0; i < mainList.size(); i++) {
				
					mainList.get(i).set(attNameList.size(), null);
				
				}
			
				System.out.println("Enter the name of the attribute: ");
				fieldList.set(attNameList.size(), input.nextLine());
				
			} else {
				System.out.println("This kind of attribute already exists. ");
				System.out.println("0 to go back.");
				System.out.println("1 to retry.");
					choice = input.nextInt();
					if (choice == 0) {
						printEditOptions(mainList, fieldList, attNameList);
					} else if (choice == 1)
						flag = 0;
			}
			
		} while (flag == 1);

	 }


	public void chooseList(List<List<String>> mainList, List<String> attNameList) {

		System.out.println("0. Go back to main menu.");
		System.out.println("1. Choose a field based on id.");
		System.out.println("2. Print ids.");
		System.out.println("Waiting for your choice: ");

		choice = input.nextInt();

		if (choice == 0) {

			mainObject.menu();

		} else if (choice == 1) {

			System.out.println("Choose the field you want to edit: ");
			printEditOptions(mainList, mainList.get(input.nextInt()), attNameList);

		} else if ( choice == 2 ) {

			for (int i = 0; i < mainList.size(); i++) {

				System.out.println("List N." + (i+1) + ": ID = ");
				System.out.printf(mainList.get(i).get(0));
				System.out.printf(" Name = ");
				System.out.printf(mainList.get(i).get(1));
				System.out.println();
			}

			System.out.println("0. Go back to edit options.");
			System.out.println("Waiting for your choice: ");

			do {
				choice = input.nextInt();

				if (choice == 0)
					chooseList(mainList, attNameList);
				else
		    		System.out.println("Invalide input, please try again: ");

			} while (choice != 0);
		}
	}
	
	public void editAttribute(List<String> fieldList) {
		
		System.out.println("0. Back to main menu.");
		System.out.println("1. Choose attribute to edit.");
		System.out.println("2. Print available attributes.");
		System.out.println("Waiting for your choice: ");
		
		do {
			
			choice = input.nextInt();
			
			if (choice == 0)
			
				mainObject.menu();

		   else if (choice == 1) {
			   
				System.out.println("Input attribute ID: ");
				choice = input.nextInt();
				System.out.println("Input new value: ");
				fieldList.set(choice, input.nextLine());			   
		   } else if (choice == 2) {
			   for (int i = 0; i < fieldList.size(); i++) {
					System.out.println(i + fieldList.get(i));
			   }
		   }
				
			
		} while (choice < 0 || choice > 2);
	}
	
	public void deleteAttribute(List<String> fieldList) {
		
		System.out.println("0. Back to main menu.");
		System.out.println("1. Choose attribute to delete.");
		System.out.println("2. Print available attributes.");
		System.out.println("Waiting for your choice: ");
		
		do {
			
			choice = input.nextInt();
			
			if (choice == 0)
			
				mainObject.menu();

		   else if (choice == 1) {
			   
				System.out.println("Input attribute ID: ");
				fieldList.remove(input.nextInt());
				
		   } else if (choice == 2) {
			   for (int i = 0; i < fieldList.size(); i++) {
					System.out.println(i + fieldList.get(i));
			   }
		   }
				
			
		} while (choice < 0 || choice > 2);
		
	}

}
