import java.util.*;
import java.util.Scanner;

public class Example {
  public static void main (String [] args) {
      int counter = 0;
      ArrayList<String> charNames = new ArrayList<String>();
      HashMap<Integer, ArrayList<Object>> iDMap = new HashMap<Integer,ArrayList<Object>>();
      Scanner sc = new Scanner(System.in);
      Scanner sc1 = new Scanner(System.in);
      int choice,choice2;

      do {
          System.out.println("******Menu******");
          System.out.println("Δημιουργία πεδίου πάτα το 1.");
          System.out.println("Εμφάνιση πεδίου πάτα 2.");
          System.out.println("Για εμφάνιση των χαρακτηριστικών πάτα 3.");
          System.out.println("Για έξοδο πάτα 4.");
          System.out.printf("Επιλογή: ");
          choice = sc.nextInt();
          if (choice == 1){
              counter++;
              ArrayList<Object> charInfos = new ArrayList<Object>();
              iDMap.put(counter, charInfos);
            do{
              System.out.println("Θες να προσθέσεις χαρακτηριστικό; Πάτα 1, αλλιώς 0 για να επιστρέψεις στο menu.");
              choice = sc.nextInt();
              if(choice == 1){
                  String NameofAttribute,InfoofAttribute;
                  System.out.println("Δώσε όνομα στο χαρακτηριστικό.");
                  NameofAttribute = sc1.nextLine();
                  if(charNames.contains(NameofAttribute) == true){
                    int temp = 0;
                    for(int i = 0;  i < charNames.size(); i++){
                      if(charNames.get(i) == NameofAttribute) {
                        temp = i;
                        System.out.println(temp);
                        System.out.println(i);
                      }
                    }
                    System.out.println("Τι τιμή θέλεις να έχει το καινούργιο χαρακτηριστικό;");
                    InfoofAttribute = sc1.nextLine();

                    charInfos.add(temp,InfoofAttribute);
                  } else {
                    charNames.add(NameofAttribute);
                    System.out.println("Τι τιμή θέλεις να έχει το καινούργιο χαρακτηριστικό;");
                    InfoofAttribute = sc1.nextLine();
                    charInfos.add(InfoofAttribute);
                  }
              }
            }while(choice != 0);
          } else if (choice == 2){
              do{
                System.out.println("Ποιο στοιχείο θές να εμφανίσεις με βάση το id του; Αν θες να επιστρέψεις στο menu πάτα 0.");
                choice2 = sc.nextInt();
                System.out.println();
                System.out.println();
                System.out.println(charNames);
                System.out.println();
                System.out.println();
                  if(iDMap.containsKey(choice2) == true){
                    ArrayList<Object> tempInfos = new ArrayList<Object>();
                    tempInfos = iDMap.get(choice2);
                    for(int i = 0; i < tempInfos.size(); i++){
                      if(! tempInfos.get(i).equals(null)) {
                        System.out.print(tempInfos.get(i) + "   ");
                      } else {
                        System.out.print(" - ");
                      }
                    }
                    System.out.println();
                  } else {
                    System.out.println("Δεν υπάρχει το συγκεκριμένο id. Παρακαλώ δώσε id που να υπάρχει, αλλίως πάτα 0 για να επιστρέψεις στο menu.");
                  }
              }while(choice2 != 0);
          } else if(choice == 3){
            System.out.println(charNames);
            System.out.println();
            System.out.println();
          } else {
              System.out.println("Adios Amigos! Muchas");
          }
      }while( choice != 4);
  }

}
