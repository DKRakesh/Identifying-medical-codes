package system;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;




// Code to modfiy lemma file a/q to requirement
// Separating Document and making separate document a/q to problem type

public class A11_File_Modify {
	static  A12_Oct_Extract A=new  A12_Oct_Extract();
	
	static File file=new File("/home/iitp/project/Output File/final_demo/file1");
//	static File file1=new File("/home/iitp/project/Output File/Final_demo/lemma_generated_file");
	
	
	
	
	static ArrayList<String> TUI=new ArrayList<String>(); 
	
	
	public void Creating_lemma_generated_file() throws IOException{
	
		System.out.println("started A11");
		

		
FileReader fr1=new FileReader(file);
		
		BufferedReader br1=new BufferedReader(fr1);
		String line="";
		int file_no=0;
		while((line=br1.readLine())!=null)
		{
			file_no++;
			String path=line;
			A.read(path,file_no);
			
			
//			
		}
//		new NewThread("/home/iitp/Desktop/D/ezdi/12_Doc_Data/output/lemmas_12Doc/aalborzi-1776-[1-9004419-1556]-[11092012]-[144012]-14@1234433262T.txt"); // start threads
//	    
		
		
		
//		
//
System.out.println("Done A11");		
		
	}

	


}
//	
//	
//}

