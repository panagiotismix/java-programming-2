import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/*README!!!
TRE3TE TO MIA FORA
-------------------------------------------------------------
OLH H MAIN MPOREI NA SVISTEI, THN EXW MONO GIA TO PARADEIGMA
--------------------------------------------------------------
3 METHODOI: PrintMenu() , ShowComplete() , ShowSelected()
--------------------------------------------------------------
PrintMenu(attNameList,mainList): H KLASSH THN OPOIA PREPEI NA KALESETE OTAN THELETE NA DIALE3EI O XRHSTHS
PWS THA TOY EMFANIZONTAI TA DEDOMENA.AYTOMATA TREXEI TIS ANTISTOIXES KLASSEIS ANALOGA
ME TIS EPILOGES TOY XRHSTH
---------------------------------------------------------------
ShowComplete(attNameList,mainList) : DEIXNEI OLA TA DEDOMENA STO XRHSTH OLHS THS VASHS
---------------------------------------------------------------
ShowSelected(attNameList,mainList) : DEIXNEI TA DEDOMENA SYMFWNA ME TON XARAKTHRISTIKO POY DIALEGEI
---------------------------------------------------------------
GIA APORIES STEILTE MOY STO MESSENGER
GRHGORHS :)
*/

public class Print {

	public void PrintMenu(List<ArrayList<String>> mainList, ArrayList<String> fieldList, ArrayList<String> attNameList) {

		Scanner input = new Scanner(System.in);
		int choice=0;

		System.out.println("Choose the way you want to print your data base :");
		System.out.println("Complete Print(1).");
		System.out.println("Print by attribute selection(2).");
		System.out.println("Return (0).");

		do {
			System.out.print("Choose one of the above:");
			choice = input.nextInt();
			}while(!(choice ==0 || choice ==1 || choice ==2) );
		switch (choice)
		{

		case 0:
			Menu.getMenu(mainList, fieldList, attNameList);
		break;

		case 1:
			ShowComplete(mainList, fieldList, attNameList);
		break;

		case 2:
			ShowSelected(mainList, fieldList, attNameList);
		break;
		} //end of switch
	}

	public void ShowComplete(List<ArrayList<String>> mainList1, ArrayList<String> fieldList, ArrayList<String> attNameList) {

				Scanner input = new Scanner(System.in);

				for (int i = 0; i < mainList1.size(); i++) {
					System.out.println("\nList N." + (i+1) + ": ");
					for (int j=0; j<attNameList.size(); j++) {
						System.out.printf(attNameList.get(j) + ": " + mainList1.get(i).get(j));
						System.out.println();
					}
				}

			System.out.println();
			System.out.println("Enter 0 to return");
			if(input.nextInt() == 0) {
				PrintMenu(mainList1, fieldList, attNameList);
			}

		}

	public void ShowSelected(List<ArrayList<String>> mainList1, ArrayList<String> fieldList, ArrayList<String> attNameList) {

		Scanner input = new Scanner(System.in);
		int choice=1000;

		System.out.println("\nChoose the attribute you want to display data with: ");
		for (int i =0; i<attNameList.size(); i++)
		{
			System.out.print(attNameList.get(i) + "(" + i + ") ");
		}
		System.out.println();
		System.out.print("Choice: ");
		choice = input.nextInt();
		System.out.println("\nShow data by " + attNameList.get(choice));
		for (int i=0; i<mainList1.size();i++)
		{
			System.out.print(mainList1.get(i).get(choice)+"(" +i+") ");
		}
		System.out.println();
		System.out.print("Make your choice: ");
		choice = input.nextInt();
		for(int i =0; i<attNameList.size();i++) {
			System.out.print(attNameList.get(i));
			for (int j =0; j<(24- attNameList.get(i).length());j++){
				System.out.print(" ");
			}
		}
		System.out.println();
		for (int j = 0;j<attNameList.size() ; j++)
		{
			System.out.print(mainList1.get(choice).get(j));
			for (int k=0; k<24 -( (mainList1.get(choice)).get(j)).length();k++)
			{
				System.out.print(" ");
			}
		}
		System.out.println();
		System.out.println("Enter (0) to return");
		if(input.nextInt() == 0) {
			PrintMenu(mainList1, fieldList, attNameList);
		}
	}
}
