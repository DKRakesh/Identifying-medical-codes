package system;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class D22_Rank3Score1 {
	// static File filew=new File("/home/iitp/project/temp");
	 static File filer=new File("/home/iitp/project/Output File/final_demo/Extracted_suientitytype");
	 static HashMap<String, Float> Entity=new HashMap<String,Float>();
	 static HashMap<String,ArrayList<String>> Valuestored;
	 static HashMap<String,ArrayList<String>> suivscui;//sui|cui [T01$Entity Arraylist]
	 static HashMap<String, TreeMap<String, Float>> suivscui1;//sui [Arraylist Cui:value]
	 static TreeMap<String,Float> cuisort;
	 static ArrayList<String> array;
	 static D23_Entitypriority A=new D23_Entitypriority();
	 static ArrayList<String> E;//To store cui
	 static ArrayList<String> F;//To store TUI$entitytype
	 static int value1;
	 static int count=0;
	 
	 
	 HashMap<String, TreeMap<String, Float>> Priority() throws IOException {
		 
		 System.out.println("Started Rank3Score1!!"+count++);
	
		 System.out.println("Started D22");
		 
		 FileReader fr=new FileReader(filer);
		 BufferedReader br=new BufferedReader(fr);
//		 FileWriter fw=new FileWriter(filew);
	//	 BufferedWriter bw=new BufferedWriter(fw);
		 Valuestored=new HashMap<String,ArrayList<String>>();
		 suivscui=new HashMap<String,ArrayList<String>>();
		 suivscui1=new HashMap<String,TreeMap<String,Float>>();
		 Entity=A.Priority();
		 String line="";
		 String sui="";
		 String prevsui=null;
		 String prevcui="";
		 String cui="";
		 String str="";
		    while((line=br.readLine())!=null)
		    {
		    	/*  if(line.isEmpty())
		    			  continue;
	              */
	         String[] comp = line.split("\\|");
	           
			 sui=comp[0];
			 cui=comp[1];
			 str=sui+"|"+cui;
			 array=new ArrayList<String>();
			 for(int i=2;i<comp.length;i++)
			 {
			//	 String[] comp1=comp[i].split("\\$");
				 array.add(comp[i]);
				 	
			 }
			suivscui.put(str, array);
			 float value2=0;
			 
			
			
			 if(sui.equals(prevsui))
			 {
				 for(int i=2;i<comp.length;i++)
				 {
					 String[] comp1=comp[i].split("\\$");
					 value2=value2+Entity.get(comp1[1]);
					// System.out.println("value2="+value2);
					 	
				 }
				 cuisort.put(cui, value2);
				 prevsui=sui;
				 continue;
			 
		
			 }
			 else
			 {
				 suivscui1.put(prevsui,cuisort);
				 cuisort=new TreeMap<String,Float>();
				 float value1=0;
				 for(int i=2;i<comp.length;i++)
				 {
					 String[] comp1=comp[i].split("\\$");
					 value1=value1+Entity.get(comp1[1]);
					// System.out.println("value2="+value2);
					 	
				 }
				 cuisort.put(cui, value1);
				 prevsui=sui;
				 continue;
				 
				 
			 }
			
			 
		    }
		    suivscui1.put(prevsui,cuisort);
		    br.close();
	
		    
		//	 for(String tempKey: suivscui.keySet()){
					
					
					//	System.out.println("key-"+tempKey+" value-"+suivscui.get(tempKey));
					//	System.out.println("work in progress");
			//		}
			 
		//	 System.out.println("stored arraylist");
		    System.out.println("Done D22");
			
			return suivscui1;
	 }
	 
	HashMap<String,ArrayList<String>> arrayvalue() 
	 
	{
			 
		/*	 for(String tempKey: suivscui.keySet()){
					
					
					System.out.println("key-"+tempKey+" value-"+suivscui.get(tempKey));
				//	System.out.println("work in progress");
				}
			*/	
			return suivscui;

	}	 
		 
		  
		  
		  
			 
		 
		 
		 
		 
	 

}

