package edu.calstatela.cs454.exam1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;
import java.util.Map;

public class Extraction {

	
	public static void extract(File f) throws IOException {
		Map<String, String> maps= new HashMap<String , String>();
		
		Path file = Paths.get(f.getAbsolutePath());
		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
		
		String extension = "";

		int i = f.getName().lastIndexOf('.');
		if (i > 0) {
		    extension = f.getName().substring(i+1);
		}
		
		if(extension.equals("xlsx")) {
			
			UserPrincipal owner = Files.getOwner(file);
			String username = owner.getName();
			maps.put("author", username);
			maps.put("file" , f.getAbsolutePath());
			System.out.println(f.getAbsolutePath());
			maps.put("type", extension);
			maps.put("Date",  attr.creationTime().toString());
			Storage.save(f, maps);
			
		}
		else
		{
			return;
		}
		
		
	}

}
