package edu.calstatela.cs454.exam1;

import java.io.File;
import java.io.IOException;

public class Crawler {

	/* 
	 * source: http://stackoverflow.com/questions/2056221/recursively-list-files-in-java
	 * 
	 */
	public void walk(String path) throws IOException {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());

			} else {
				Extraction.extract(f);
			}
		}
	}

	public static void main(String[] args) {
	    try {
		    String startDir = ".";
    		new Crawler().walk(startDir);
    		System.out.println("Finish");
	    } catch (Exception ex) {
	    	System.out.println(ex);
	    }
	}
}
