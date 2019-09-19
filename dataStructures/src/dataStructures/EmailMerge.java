package dataStructures;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * EmailMerge fills a template file with information from a people file
 * @author Emily
 *
 */
public class EmailMerge {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// Create a people Scanner
		
		Scanner peopleScr = new Scanner(new File("src/dataStructures/people.txt"));
		
		// Create null line String, 0 integer counter, and null outputFile String
		
		String line = "";
		
		ArrayList<String> names = new ArrayList<String>();
		
		// While loop to identify the name, age, and gender in each line
		
		while (peopleScr.hasNext()) {
			Scanner tempScr = new Scanner(new File("src/dataStructures/template.txt"));
			
			// Make blank name, age, and gender
			
			int nameCount = 0;
			String name = "";
			String age = "";
			String gender = "";
			
			// Assign a line of the people file to the line String
			
			line = peopleScr.nextLine();
			// Assign the name character by character
			
			for (int i = 0; i < line.indexOf(" "); i++) {
				name = name + line.charAt(i);
			}
			// Add name to the ArrayList
			
			names.add(name);
			
			// Create a substring of the line that does not include the name
			
			String findAge = line.substring(line.indexOf(" ") + 1);
			
			// Assign the age character by character
			
			for (int i = 0; i < findAge.indexOf(" "); i++) {
				age = age + findAge.charAt(i);
			}
			// Create a substring of the line that does not include the age or name
			
			String findGender = findAge.substring(findAge.indexOf(" ") + 1);
			
			// If the gender starts with an f assign the gender female and if the gender
			// starts with an m assign the gender male
			
			if (findGender.startsWith("f") == true) {
				gender = "female";
			} else {
				gender = "male";
			}

			//Create a blank file name
			
			String fileName = "";
			
			//If the name is the same as any other name in the ArrayList then 1 is added to the name count
			
			for (int i = 0; i < names.size(); i++) {
				if (names.get(i).contentEquals(name)==true) {
					nameCount++;
				}
			}
			
			//Assigns the file name. If the name count is 1 or greater the name count is included in the file name
			
			if (nameCount >= 1) {
				fileName = "src/dataStructures/" + name + "-" + nameCount + ".txt";
			} else {
				fileName = "src/dataStructures/" + name + ".txt";
			}
			
			//Creates a PrintWriter that writes in a file with the given file name
			
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(new File(fileName)));
			
			//The while loop goes through each line of the template and replaces place holders with their actual values from the people file
			
			while (tempScr.hasNextLine()) {
					String line2 = tempScr.nextLine();
					line2=line2.replace("<<N>>", name);
					line2=line2.replace("<<A>>", age);
					line2=line2.replace("<<G>>", gender);
					outputStream.println(line2);
			}
			
			//Closes each scanner
			
			outputStream.close();
			tempScr.close();
		}
		peopleScr.close();
	}
	}

