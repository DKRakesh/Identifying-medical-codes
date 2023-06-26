package system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class B21_Extract_Selecting_SUI {
	
	
	static File filer=new File("/home/iitp/project/Output File/final_demo/Entity-SUI");
	ArrayList<String> sui=new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		
		
		FileReader fr=new FileReader(filer);
		 BufferedReader br=new BufferedReader(fr);
		 
		 String line="";
		 while((line=br.readLine())!=null)
		 {
			 
			 
			 
		 }
				 
		
		
		
	}

}
