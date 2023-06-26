package system;

/* 
 * 
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class B11_Extract_sui {

	static File file1=new File("/home/iitp/project/Output File/final_demo/uniquesui");
	static File file2=new File("/home/iitp/project/Output File/final_demo/lemma_generated_file");
	static File entity=new File("/home/iitp/project/Output File/final_demo/output_lemma");
	static TreeMap<String, String> map=new TreeMap<String,String>();
	
	
	public void Extracting_SUI_Corresponding_lemma() throws IOException {
		System.out.println("started !!  B11");
		
		FileReader fr2=new FileReader(file2);
		
		FileWriter fw=new FileWriter(entity);
		 BufferedWriter bw=new BufferedWriter(fw);
		
		 //System.out.println("hkgfkj="+TUI.get(5));
				
				BufferedReader br2=new BufferedReader(fr2);
		
		FileReader fr1=new FileReader(file1);   // To read unique sui file
		
		 //System.out.println("hkgfkj="+TUI.get(5));
				
				BufferedReader br1=new BufferedReader(fr1);
				String line="";
		//		System.out.println("HI Mapping has Started !! Welcome");
				while((line=br1.readLine())!=null)
						{
					String[] arra=line.split("\\|");
					map.put(arra[0],arra[1]);
						}
	//J			System.out.println("HI Mapping has Successfully Done !! Bye");
	//J			System.out.println(" Wait Final Lap has started !! Best Of Luck");
				line="";
				while((line=br2.readLine())!=null)
				{
				String[] arra1=line.split("\\|");	
				String temp="";
				System.out.print(arra1[0]+"|");
				bw.write(arra1[0]+"|");
				for(int i=3;i<arra1.length-1;i++)
					{
					temp=arra1[i];
				
				for(String key: map.keySet())
						{
					if(temp.equals(map.get(key)))
							{
						System.out.print(key+"="+ map.get(key)+"|");
						bw.write(key+"="+map.get(key)+"|");
							}
						}
				
					}
				bw.write("\n");
				System.out.println( );
				}
			//	System.out.println(" Successfully Executed  !! ");
				
				System.out.println("Done B11");
		
	}


	
	
}

