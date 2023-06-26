package system;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class A21_Extract_SUI {
	
	
	 static File filer=new File("/home/iitp/project/Output File/final_demo/Entity_cosine_sui");
	 static File filec=new File("/home/iitp/project/Output File/final_demo/CuiScore");
	 static File filef=new File("/home/iitp/project/Output File/final_demo/FrequencyScore.txt");
	 static File file_entity=new File("/home/iitp/project/Output File/final_demo/suivstuientitytype");
	 
	 static File extract_filec=new File("/home/iitp/project/Output File/final_demo/Extracted_sui_cui");
	 static File extract_filef=new File("/home/iitp/project/Output File/final_demo/Extracted_sui_freq");
	 static File extract_file_entity=new File("/home/iitp/project/Output File/final_demo/Extracted_suientitytype");
	 
	 static ArrayList<String> Asui=new ArrayList<String>();
	 public void Extracting_SUI_of_Test_File()  throws IOException {
		 
		 System.out.println("Started !! A21");
		
		
		FileReader fr=new FileReader(filer);
		 BufferedReader br=new BufferedReader(fr);
		
		 String line="";
		 while((line=br.readLine())!=null)
		 {
			 String[] arra=line.split("\\|");
			 for(int i=1;i<arra.length-1;i++)
			 {
				 String[] arra1=arra[i].split("\\:");
				 
				 String sui=arra1[1].split("\\$")[0];
				 Asui.add(sui);
				 
			 }
			 
		 }
		 
		 FileReader fc=new FileReader(filec);
		 BufferedReader bc=new BufferedReader(fc);
		 
		 FileWriter fwc=new FileWriter(extract_filec);
		 BufferedWriter bwc=new BufferedWriter(fwc);
		 line="";
		 while((line=bc.readLine())!=null)
		 {
			 String[] cui=line.split("|");
			 
			 if(cui!=null)
			 {
				if(Asui.contains(cui[0]))
				{
					bwc.write(line+"\n");
				}
			 }
			 else continue;
			 
			 
		 }
		 bwc.close();
		 
		 
		 FileReader ff=new FileReader(filef);
		 BufferedReader bf=new BufferedReader(ff);
		 
		 FileWriter fwf=new FileWriter(extract_filef);
		 BufferedWriter bwf=new BufferedWriter(fwf);
		 
		 line="";
		 while((line=bf.readLine())!=null)
		 {
			 String[] freq=line.split("|");
			 
			 if(freq!=null)
			 {
				if(Asui.contains(freq[0]))
				{
					bwf.write(line+"\n");
				}
			 }
			 else continue;
		 }
		 bwf.close();
		 
		 FileReader fe=new FileReader(file_entity);
		 BufferedReader be=new BufferedReader(fe);
		 
		 FileWriter fwe=new FileWriter(extract_file_entity);
		 BufferedWriter bwe=new BufferedWriter(fwe);
		 line="";
		 while((line=be.readLine())!=null)
		 {
			 String[] entity=line.split("|");
			 
			 if(entity!=null)
			 {
				if(Asui.contains(entity[0]))
				{
					bwe.write(line+"\n");
				}
			 }
			 else continue;
		 }
		 bwe.close();
		 System.out.println("Done A21");
			
	}
	

}

