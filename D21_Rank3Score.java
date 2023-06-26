package system;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class D21_Rank3Score {
	 static File filew=new File("/home/iitp/project/Output File/final_demo/Extracted_sui_tui");
	 static File filer=new File("/home/iitp/project/Output File/final_demo/Extracted_suientitytype");
//	 static File file=new File("/home/iitp/project/DRank3Score.txt");
	 static HashMap<String, Float> Entity=new HashMap<String,Float>();
	
	 static HashMap<String,ArrayList<String>> Valuestored;
	 static HashMap<String,ArrayList<String>> suivscui;//tree containing sorted cui vs sui
	 static HashMap<String, TreeMap<String, Float>> suivscui1;
	 static TreeMap<String,ArrayList<String>> finalsorted;
	 static ArrayList<String> temp;
	 static ArrayList<String> array;
	 static TreeMap<String, Float> cuisort;
	 static D23_Entitypriority A=new D23_Entitypriority();
	 static D22_Rank3Score1 B=new D22_Rank3Score1();
	 static D24_sortcui C=new D24_sortcui();
	 static ArrayList<String> E;//To store cui
	 static ArrayList<String> F;//To store TUI$entitytype
	 static ArrayList<String> sortedarray;
	 static int value1;
	 static String sui;
	 
	 public void Creating_Rank_3() throws IOException {
		 
		 System.out.println("Started D21!!");
		 
		 FileReader fr=new FileReader(filer);
		 BufferedReader br=new BufferedReader(fr);
		 FileWriter fw=new FileWriter(filew);
		 BufferedWriter bw=new BufferedWriter(fw);
		 Valuestored=new HashMap<String,ArrayList<String>>();
		 suivscui=new HashMap<String,ArrayList<String>>();
		 suivscui1=new HashMap<String, TreeMap<String, Float>>();
		 finalsorted=new TreeMap<String,ArrayList<String>>(); 
		 Entity=A.Priority();
		 String line="";
		 String sui="";
		 String prevsui="";
		 String prevcui="";
		 String cui="";
		 suivscui1=B.Priority();
		 suivscui=B.arrayvalue();
		 
		 
//  Date 18/11/2016			 for(String tempKey: suivscui.keySet()){
					
					
				//		System.out.println("key-"+tempKey+" value-"+suivscui.get(tempKey));
					//	System.out.println("work in progress");
//	Date 18/11/2016				}
		//	 System.out.println("Difference ");
			 for(String tempKey: suivscui1.keySet())
			 {
				 sui=tempKey;
				 temp=new ArrayList<String>();
				 sortedarray=new ArrayList<String>();
				 array=new ArrayList<String>();
				 cuisort=new TreeMap<String,Float>();
				 cuisort=suivscui1.get(tempKey);
			//	 System.out.println(cuisort);
			//	 System.out.println("");
				 if(tempKey!=null)
				 temp=C.sort(tempKey,cuisort);
			//	 System.out.println("temp"+temp);
				if(sui!=null)
				 finalsorted.put(sui, temp);
				// Map<String,Integer> tree=new TreeMap<String,Integer>(cuisort);
				//	System.out.println("key-"+tempKey+" value-"+suivscui1.get(tempKey));
				//	for(Map.Entry<String, Integer> entry : tree.entrySet())
				//	{
				//		System.out.println("key :" +entry.getKey()+"value :"+ entry.getValue());
				//	}
				//	System.out.println("work in progress");
				 
			
			 }
			 
			 for ( String key : finalsorted.keySet() ) 
				{
				 temp=new ArrayList<String>();
				 temp=finalsorted.get(key);
				 float tmp=(float)5/temp.size();
			//	System.out.println(temp.size()+"D"+tmp);
				 String string1="";
				 for (int i=0;i<temp.size();i++)
		        	{
		        		
		        		float value=(5-(tmp*i));
		        	//	System.out.println(value);
		        		string1=string1.concat(temp.get(i)+"#"+value+"|");
		        	//			j++;
		        				
		        	}
				 string1=key.concat("|"+string1);
				 bw.write(string1+"\n");
				 System.out.println(string1);
				 System.out.println();
				// System.out.println("");
		
				//	System.out.println( key+finalsorted.get(key) );
				}
			 bw.close();
		  
		  System.out.println("Done D21");
			 
		 }

	
		 
		 
		 
	 

}

