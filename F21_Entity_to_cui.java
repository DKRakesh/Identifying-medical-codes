package system;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class F21_Entity_to_cui {
	
	static File file1=new File("/home/iitp/project/Output File/final_demo/Entity_cosine_sui");
	static File file2=new File("/home/iitp/project/Output File/final_demo/Rank123");
	 static TreeMap<String,ArrayList<String>> suivscui=new TreeMap<String,ArrayList<String>>(); 
	 static ArrayList<String> cui=new ArrayList<String>();
	 static ArrayList<String> temp=new ArrayList<String>();
	
	 public void Final_endtend_system()throws IOException {
		 
		 System.out.println("Started F21");
		
		 FileReader fr1=new FileReader(file1);
		 BufferedReader br1=new BufferedReader(fr1);
		 
	
		 
		 
		String line="";
		while((line=br1.readLine())!=null)
		{
			temp=new ArrayList<String>();
			String[] arra=line.split("\\|");
			String test_word=arra[0];
			
			if(arra.length>2)
			{
				System.out.print(test_word+"|");
			for(int j=1;j<arra.length-1;j++)
				{
				String[] lemma_word=arra[j].split("\\: ");
				Double cosine_value= Double.parseDouble(lemma_word[0]);
				
				cosine_value=(double)Math.round(cosine_value * 100000d) / 100000d;
				
				String[] lemma_arra=lemma_word[1].split("\\$");
				String sui=lemma_arra[0];
			//	System.out.println( lemma_arra[1]+"|"+sui);
				System.out.print(lemma_arra[1]+":"+sui+":"+cosine_value+":");
			//	System.out.println("SUI not present !!"+sui);
				
				FileReader fr2=new FileReader(file2);
				 BufferedReader br2=new BufferedReader(fr2);
				 String line2="";
				 while((line2=br2.readLine())!=null)
				 {
					 String[] array=line2.split("\\|");
					if(sui.equals(array[0]))
					{
					//	System.out.println("Test word="+ test_word  + "CUI="+array[1].split("\\#")[0] );
						System.out.print(array[1]+"|");
					}
					 
				 }
				
				
				}
			System.out.println();
			}
			
			else
			System.out.println(test_word+"= is not present in UMLS");
			System.out.println();
			
		}
		System.out.println("Done F21");
		
	}

	

}

