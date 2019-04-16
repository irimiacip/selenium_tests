package net.metrosystems.seleniumtests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_data {

	public static void main(String[] args) throws FileNotFoundException {

		String xxx = "src/main/resources/file/db_querry" ;
		
		Scanner scanner = new Scanner(new File(xxx));  
		while (scanner.hasNextLine()) {  
		   String line = scanner.nextLine();
		   System.out.println(line);
		   
		}
		
	}

}
