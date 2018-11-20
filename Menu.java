import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
      int choice;
      Scanner input = new Scanner(System.in);
      Print printObject = new Print();
      FieldEdit FieldEditobject = new FieldEdit();

      List <List<String>> mainList = new ArrayList<>();
      List <String> attNameList = new ArrayList<>();
      List <String> fieldList = new ArrayList<>();

      System.out.println("\n*        Welcome to your Data Base Tool powered by Amstel!       *");
      System.out.println("         _________________________________________________       ");
      System.out.println("\nSelect from the following menu what you want to do:     ");
      getMenu();
      do {
        System.out.print("Choice: ");
        choice = input.nextInt();
        switch (choice)
    		{

    		case 1:
          System.out.println("\n");
    			printObject.PrintMenu(attNameList, mainList);
    		break;

    		case 2:

    		break;

    		case 3:
          System.out.println("\n");
    			FieldEditobject.printEditOptions(mainList, fieldList, attNameList);
    		break;

        case 0:

          System.out.println("\n*             Thank you for using our Tool!           *");
          System.out.println("                ©©©   Copyrights    ©©©               ");
          System.out.println("\n                   Blavakis Nikolas                   ");
          System.out.println("                  Giannopoulos Dimitris                 ");
          System.out.println("                    Korovesis Petros                   ");
          System.out.println("                Michalopoulos Panagiotis              ");
          System.out.println("                    Psillas Kostas                     ");
          System.out.println("                  Sakalidis Grigoris              \n\n");
          break;
    		} //end of switch
      }while(choice != 0);
    }

    public static void getMenu() {
      System.out.println("\n1. Print your Data.");
      System.out.println("2. Create a new field in your DataBase.");
      System.out.println("3. Edit your fields.");
      System.out.println("0. Exit.");
    }
}
