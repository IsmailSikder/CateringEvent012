package week6;

import java.io.*;

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
	
		writeMenuToFile(menuFile,dinnerEvent);
		readFromTheFile(menuFile);
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


