package net.metrosystems.seleniumtests;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {

	public static List<String> dbvalue= new ArrayList<String>();

/*		public static void main(String[] args) {
				DBconnect.getPostrgresSqlConnection("jdbc:postgresql://psql0.opsql.mrcpp0.test9.mcc.be-gcw1.metroscales.io","mcc_test9","3TUwMU0pBFM22VT$9vQO");
				for (int i = 0 ; i<dbvalue.size(); i++) {
					System.out.println("value from db : " + dbvalue.get(i));
				}	
		}*/
		
		  public static  List<String>  getPostrgresSqlConnection(String url, String usr, String pass) {
	  		  
			    //String url = "jdbc:postgresql://psql0.opsql.mrcpp0.test9.mcc.be-gcw1.metroscales.io";
			   // String usr = "mcc_test9";
			    //String pass = "3TUwMU0pBFM22VT$9vQO";		    		     s
			     Connection conn = null;
			     Statement stmt = null;    
			      ResultSet rs = null;
			      String val1 = null;
			      String val2 = null;
			        try {
			            conn = DriverManager.getConnection(url, usr, pass);
			            System.out.println("Connected to the PostgreSQL server successfully.");		      
			      stmt = conn.createStatement();
			            rs = stmt.executeQuery("select approver_result , activation_status from activationservice.activation");
			            System.out.println(rs);
			            if (rs.next()) {
			            	val1 = rs.getString(1);
			            	dbvalue.add(val1);
			                val2 = rs.getString(2);
			                dbvalue.add(val2);
			                System.out.println(rs.getString(1)+" "+rs.getString(2));
			              conn.close();
			            }
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }		       
			        return dbvalue;        		        
		  }	
 	
}