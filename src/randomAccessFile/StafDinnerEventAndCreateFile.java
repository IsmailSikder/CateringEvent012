package randomAccessFile;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * Name Mohammed Sikder
 * Project: Cathy's Catering
 * Class inherits from Event class
 * 
 */

/** 13 unit start here**/

public class StafDinnerEventAndCreateFile extends Event{
	
	int ent;
	int sdish1;
	int sdish2;
	int d;
	String menuChoice;
	public final String entree[] = {"Chicken", "steak", "fish"};
	public final String sideDish1[] ={"Ceaser Salad", "Mixed greens","Regular Greens"};
	public final String sideDish2[] ={"Lobster Bisque", "Chicken Soup","Onion Ring"};
	public final String desert[] = {"ice cream", "pudding","choclate cake"};
	
	//Constructor for this class takes 6 parameters 
	public StafDinnerEventAndCreateFile(int eid, int numGuest, int ent, int s1,int s2, int d){
		setEventType(eid);
		setEventNumber();	
	}
	
	public StafDinnerEventAndCreateFile() {
		// TODO Auto-generated constructor stub
	}

	//GetMenu method return all the menu available
	public String getMenu(){
		String menu;
		
		String d= "Desert Choice:\t";
		String e= "Entree Choice:\t";
		String s1="Ist SideDish Choices:\t";
		String s2="2nd SideDish Choices:\t";
		
		for(int i=0; i<desert.length;i++){
			e=e+(i+1)+"."+entree[i]+"\t";
			d=d+(i+1)+"."+desert[i]+"\t";
			s1=s1+(i+1)+"."+sideDish1[i]+"\t";
			s2=s2+(i+1)+"."+sideDish2[i]+"\t";
		}
		
		menu=e+"\n"+s1+"\n"+s2+"\n"+d;
		
		return menu;	
	}
	
	//This methods calls setEventNumber(), setGuests(), setDinnerChoice() methods
	public void getUserChoice(){
		
		setEventNumber();
		setGuests();
		setDinnerChoice();
	}
	
	//This method ask user to choose dinner from the menu
	public void setDinnerChoice(){
		String msg = "Enter Menu Number to Choose (1,2 or 3): \n";
		//System.out.println(getMenu());
		//Scanner s = new Scanner(System.in);
		System.out.println();
		
		int choice;
		
		do{
		try
		{
			error=false;
			choice = Integer.parseInt(JOptionPane.showInputDialog(getMenu(),msg));
			menuChoice = entree[choice-1]+ ", "+desert[choice-1] + ", "+sideDish1[choice-1]+", "+sideDish2[choice-1];
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid Entry! Only takes integer value");
			error=true;
		}
		}while(error==true);
	}
	public String getDinnerChoice(){
		
		return menuChoice;
	}
	
}
/** Unit 13 end here**/