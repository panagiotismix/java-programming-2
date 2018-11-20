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
	
	public static void main(String[] args) {
		
		//EXAMPLE
		List <String> attNameList = new ArrayList<>(); 
		attNameList.add("Name");
		attNameList.add("Surname");
		attNameList.add("Age");
		
		List <ArrayList> mainList = new ArrayList<>();
		
		List <String> templist1 = new ArrayList<>();
		templist1.add("Grigorios");
		templist1.add("Sakalidis");
		templist1.add("21");
		
		List<String> templist2 = new ArrayList<>();
		templist2.add("Vasilis");
		templist2.add("Sakalidis");
		templist2.add("26");
		
		mainList.add((ArrayList) templist1);
		mainList.add((ArrayList) templist2);
		//END OF EXAMPLE
		
		PrintMenu(attNameList, mainList);
	}// END OF MAIN
		
	public static void PrintMenu(List<String> attNameList, List<ArrayList> mainlist) {
		
		Scanner input = new Scanner(System.in);
		int choice=0;
		
		System.out.println("Choose the way you want to print your data base :");
		System.out.println("Complete Print(1).");
		System.out.println("Print by attribute selection(2).");
		System.out.println("Press(0) to return");
		
		do {
			System.out.print("Choose one of the above:");
			choice = input.nextInt();
			}while(!(choice ==0 || choice ==1 || choice ==2) );
		switch (choice) 
		{
		
		case 0:
			PrintMenu(attNameList, mainlist);
		break;
		
		case 1:	
			ShowComplete(attNameList,mainlist);
		break;
		
		case 2:
			ShowSelected(attNameList,mainlist);
		break;
		} //end of switch
	}
	
	public static void ShowComplete(List<String> attNameList, List<ArrayList> mainList1) {
		
		for (int i=0; i<attNameList.size(); i++) {
			System.out.print(attNameList.get(i)+ " ");
		}
		for (int i =0; i<mainList1.size();i++) {
			System.out.println();
			for (int j =0;j<attNameList.size(); j++)
			{
				System.out.print(mainList1.get(i).get(j)+ " ");
			}
		}
		
	}
	public static void ShowSelected(List<String> attNameList, List<ArrayList> mainList1) {
		
		Scanner input = new Scanner(System.in);
		int choice=0;
		
		System.out.println("Choose the attribute you want to display data with: ");
		for (int i =0; i<attNameList.size(); i++)
		{
			System.out.print(attNameList.get(i) + "(" + i + ") ");
		}
		System.out.println("Choice: ");
		choice = input.nextInt();
		System.out.println("Show data: " + attNameList.get(choice));
		for (int i=0; i<mainList1.size();i++) 
		{
			System.out.print(mainList1.get(i).get(choice)+"(" +i+") ");
		}
		System.out.println();
		System.out.println("Make your choice: ");
		choice = input.nextInt();
		for (int i=0; i<attNameList.size(); i++) {
			System.out.print(attNameList.get(i)+ " ");
		}
		System.out.println();
		for (int j =0;j<attNameList.size() ; j++)
		{
			System.out.print(mainList1.get(choice).get(j)+ " ");
		}
	}
}
