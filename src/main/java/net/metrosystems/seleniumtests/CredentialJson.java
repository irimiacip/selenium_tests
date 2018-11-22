package net.metrosystems.seleniumtests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CredentialJson {

	
	private static final String filePath = "src/main/resources/file/connexion_data.json";
	//public static ArrayList<String> values;
	static List<String> list = new ArrayList<String>();
	
	public static  List<String> returnCredential(Integer testNumber) {
		
		JSONObject myList = getTestData((int) testNumber);
		

	
		list.add((String) myList.get("env_data"));


	
		list.add((String) myList.get("country"));

		
		
		list.add((String) myList.get("database_type"));

		
		JSONArray obj_database_connection = (JSONArray) myList.get("database_connection");
		
		for (int i=0 ; i<obj_database_connection.size(); i++) {
			list.add((String) obj_database_connection.get(i));
		}
		
		JSONArray obj_appl_connection = (JSONArray) myList.get("appl_connection");
		
		for (int i=0 ; i<obj_appl_connection.size(); i++) {
			list.add((String) obj_appl_connection.get(i));
		}
		
		JSONArray test_data = (JSONArray) myList.get("test_data");
		
		for (int i=0 ; i<test_data.size(); i++) {
			list.add((String) test_data.get(i));
		}
		return list ;
	}
	
	
	public  static JSONObject getTestData(int testNumber) {
		try {
			FileReader reader = new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			JSONArray array = (JSONArray) jsonParser.parse(reader);
			return (JSONObject) array.get(testNumber);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}
}