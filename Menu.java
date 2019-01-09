import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu {
	static int choice;
	static Scanner input = new Scanner(System.in);
	static Print printObject = new Print();
	static FieldEdit FieldEditobject = new FieldEdit();

    public static void main(String[] args) {

      List <ArrayList<String>> mainList = new ArrayList<ArrayList<String>>();
      ArrayList <String> attNameList = new ArrayList<String>();
      attNameList.add("ID");
      attNameList.add("Name");
      ArrayList <String> fieldList = new ArrayList<String>();

      System.out.println("\n*        Welcome to your Data Base Tool powered by Amstel!       *");
      System.out.println("         _________________________________________________       ");
      System.out.println("\nSelect from the following menu what you want to do:     ");
      getMenu(mainList, fieldList, attNameList);
	}

      public static void getMenu(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {
		  do {
			System.out.println("\n1. Print your Data.");
			System.out.println("2. Create a new field in your DataBase.");
			System.out.println("3. Edit your fields.");
			System.out.println("4. Delete a field in your DataBase.");
			System.out.println("0. Exit.");
			System.out.print("Choice: ");
			choice = input.nextInt();

			if (choice == 1){
			  System.out.println("\n");

			  printObject.PrintMenu(mainList, fieldList, attNameList);
		 	} else if (choice == 2){
					FieldEditobject.newField(mainList, fieldList, attNameList);
		 	} else if (choice == 3){
			  	System.out.println("\n");
				FieldEditobject.chooseList(mainList, fieldList, attNameList);
		 	} else if (choice == 4){
			   System.out.println("\n");
			   FieldEditobject.deleteField(mainList, fieldList, attNameList);
		 	} else if (choice == 0){
			  System.out.println("\n*             Thank you for using our Tool!           *");
			  System.out.println("                ©©©   Copyrights    ©©©               ");
			  System.out.println("\n                   Blavakis Nikolas                   ");
			  System.out.println("                  Giannopoulos Dimitris                 ");
			  System.out.println("                    Korovesis Petros                   ");
			  System.out.println("                Michalopoulos Panagiotis              ");
			  System.out.println("                    Psillas Kostas                     ");
			  System.out.println("                  Sakalidis Grigoris              \n\n");
              System.exit(1);
			} else
				System.out.println("Invalide input, please try again: ");
		} while(choice < 0 || choice > 4);
    }
}
