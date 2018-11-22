package net.metrosystems.seleniumtests;

import java.util.ArrayList;

import net.metrosystems.seleniumtests.CredentialJson;


public class JsonData {

	
	public static ArrayList<String> xxx;
	
	public static void populatearray (int a) {
		   System.out.println("value of a" + a);
           //CredentialJson.returnCredential(a);	
	
           for(int i=0; i<=10; i++) {
       		xxx.add(CredentialJson.returnCredential(a).get(i));
			}
	}
	
	public static void readarray() {
		for(int i=0; i<=xxx.size(); i++) {
       		System.out.println(xxx.get(4));
       		}
	}
           

}
