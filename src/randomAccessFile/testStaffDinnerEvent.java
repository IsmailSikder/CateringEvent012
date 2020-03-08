package randomAccessFile;

import java.io.*;
import java.util.Scanner;

public class testStaffDinnerEvent {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		StafDinnerEventAndCreateFile dinnerEvent[] = new StafDinnerEventAndCreateFile[3];
		String menuFile = "./menu.txt";
		
        for(int i=0; i<dinnerEvent.length;i++){
			
			dinnerEvent[i] = new StafDinnerEventAndCreateFile();
			dinnerEvent[i].getUserChoice();
			dinnerEvent[i].setEventType(i);
			
		}
	
        writeRandomAccessFile(dinnerEvent);
        
		//writeMenuToFile(menuFile,dinnerEvent);
		//readFromTheFile(menuFile);
	}
	
	//This file write random record
	private static void writeRandomAccessFile(StafDinnerEventAndCreateFile evt[]) throws FileNotFoundException
	{
		String filepath = "./RandomEvent.txt";
	
		try
		{
		RandomAccessFile ref = new RandomAccessFile(filepath,"rw");
		
		for(int i=0;i<3;i++)
		{
			ref.writeInt(evt[i].getEventNumber());
			ref.writeInt(evt[i].getNumberOfGuests());
			ref.writeUTF(evt[i].getEventType());
			ref.writeUTF(evt[i].getDinnerChoice());
			ref.writeDouble(evt[i].getEventPrice());
			System.out.println(" "+ ref.getFilePointer());
		}
		
		long filep = 0;
		for(int i1=0;i1<3;i1++)
		{
		
			ref.seek(filep);
			System.out.println("Event Number is: "+ ref.readInt());
			System.out.println("Number of Guest: " + ref.readInt());
			System.out.println("Event Type: "+ ref.readUTF());
			System.out.println("Dinner Choice: "+ ref.readUTF());
			System.out.println("Event Cost: "+ref.readDouble());
			System.out.println(" "+ref.getFilePointer());
			filep = ref.getFilePointer();
		}
		ref.close();
		}catch(Exception e)
		{
		   e.printStackTrace();
			
		}
		searchRandomFile(filepath);
	}
	
	//This method random search in random access file
	private static void searchRandomFile(String filepath) throws FileNotFoundException
	{
		System.out.println("********Searching record*******");
		
		System.out.print("Enter ID Here: ");
		Scanner sc = new Scanner(System.in);
		int eventID = sc.nextInt();
		
		try
		{
		RandomAccessFile ref = new RandomAccessFile(filepath,"r");
		
		
		ref.seek((eventID-1)*75);
		
		System.out.println("Event Number is: "+ ref.readInt());
		System.out.println("Number of Guest: " + ref.readInt());
		System.out.println("Event Type: "+ ref.readUTF());
		System.out.println("Dinner Choice: "+ ref.readUTF());
		System.out.println("Event Cost: "+ref.readDouble());
		//System.out.println(" "+ref.getFilePointer());
		
		//ref.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	//This method read  menu from file using for loop
	private static void readFromTheFile(String menuFile) throws FileNotFoundException {
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(menuFile));
			        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	    }
		}
	    catch (IOException e) {
	        System.out.println("Error reading file" + e.getMessage());
	    }
	}

	//This method writes user choice for the array of dinnerEvent to a menu files using for loop
	private static void writeMenuToFile(String menuFile,StafDinnerEventAndCreateFile[] dinnerEvent) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				OutputStream outputStream = new FileOutputStream(menuFile);
				OutputStreamWriter  outputStreamwriter = new OutputStreamWriter(outputStream);
				
				try
				{
					for(int i=0; i<dinnerEvent.length;i++){
					
					outputStreamwriter.write("Dinner Event Details\n");
					outputStreamwriter.write("Event Number:\t"+dinnerEvent[i].getEventNumber()+"\nType of Event:\t" + dinnerEvent[i].getEventType()
					                           +"\nDinner choice:\t"+dinnerEvent[i].getDinnerChoice())
					                            ;
					outputStreamwriter.write("\nPrice:\t\t"+(int) dinnerEvent[i].getEventPrice());
					outputStreamwriter.write("\n\n");
					}
					
					outputStreamwriter.close();
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Exception-File cannot be created");
					System.out.println(e.getMessage());
				}
				
			}
		
	}


