import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Event {
	
	public final static double priceperguest=35;
	public final static int cutoffvalue=50;
	private int eventNumber;
	private int numberofGuests;
	private double eventPrice;
	public int eventType;
	
	public final static String eventName[] = {"wedding", "baptism", "birthday", "corporate", "other"};
	
	
	
	public String getEventType() {
		if(eventType>eventName.length)
			return "other";
		else return eventName[eventType];
	}

	public void setEventType(int eType) {
		eventType = eType;
	}

	//This class sets event number 
	public void setEventNumber() {
		

		String msg = "\"Enter Event Number.\n";
		eventNumber = Integer.parseInt(JOptionPane.showInputDialog("Event Number",msg));
		//s.close();
	}
	
	//this function sets number of guests
	public void setGuests()
	{
		String msg = "Enter number of guests.\n";
		numberofGuests = Integer.parseInt(JOptionPane.showInputDialog("Number of Guests",msg));

	}

	//returns eventNumber
	public int getEventNumber() {return eventNumber;}
	
	//returns guestnumber
	public int getNumberOfGuests() { return numberofGuests;}
	
	//returns price
	public double getEventPrice() 
	{ eventPrice = numberofGuests * priceperguest;  
		return eventPrice;
    }
	
	public static String [] SortEventType(){
		Arrays.sort(eventName);
		//System.out.println(eventName);
		return eventName;
		
	}

}
