import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args){

		//use this for indexes 0=hlikies, 1=epitheta , 2=onomata ktlp ktlp
		List holder = new ArrayList();

		//Preety self-explanatory
		List Mainlist = new ArrayList();

		//addding elements to the list
		//always true
		if(true){
				List newlist = new ArrayList();
				newlist.add(0,"sakalidis");
				newlist.add(1,"grigoris");
				newlist.add(2,21);
				Mainlist.add(newlist);
				}
		if(true){
				List newlist = new ArrayList();
				newlist.add(0,"sakalidis");
				newlist.add(1,"vasilis");
				newlist.add(2,26);
				Mainlist.add(newlist);
		}

		//printing original values
		System.out.println("Printing original values: ");
		System.out.println(Mainlist.get(0));
		System.out.println(Mainlist.get(1));

		//editing existing lists - WAY1
		List templist = new ArrayList();
		templist = (List)Mainlist.get(0);
		templist.set(0,"papaspirou");
		Mainlist.set(0,templist);

		//printing after editing
		System.out.println("Printing after editing : ");
		System.out.println(Mainlist.get(0));
		System.out.println(Mainlist.get(1));

		//editing existing lists - WAY2, DIRECT EDITING in MainList

	}//end of main
}//end of class
