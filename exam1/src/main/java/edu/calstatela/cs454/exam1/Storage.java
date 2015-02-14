package edu.calstatela.cs454.exam1;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import org.json.simple.JSONObject;

 /*
  * http://www.mkyong.com/java/json-simple-example-read-and-write-json/
  */

public class Storage {
	
	@SuppressWarnings("unchecked")
	public static void save(File f, Map<String, String> metadata) {
		FileWriter writer;
		
		 try{
			 writer = new FileWriter("metadata.json",true);
			 
			 JSONObject obj = new JSONObject();
			 obj.put("file", metadata.get("file"));
			 obj.put("date", metadata.get("Date").replaceAll("T", " ").replaceAll("Z", " "));
			 obj.put("author", metadata.get("author"));
			 
			 writer.write("{");
			 writer.write(System.getProperty( "line.separator" ));
			 writer.write("file: " +obj.get("file").toString());
			 writer.write(System.getProperty( "line.separator" ));
			 writer.write("date: " + "'" +obj.get("date").toString() +"'");
			 writer.write(System.getProperty( "line.separator" ));
			 writer.write("author :"+ "'" +obj.get("author").toString() +"'");
			 writer.write(System.getProperty( "line.separator" ));
			 writer.write("}");
			 writer.write(System.getProperty( "line.separator" ));
			 writer.close();
			
	        }catch(Exception e){
	            System.out.println(e);
	        }
		 
	}

}
