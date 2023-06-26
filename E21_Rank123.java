package system;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class E21_Rank123 {
	
//	static File file1=new File("/home/iitp/DCuiScore");
	static File file4=new File("/home/iitp/project/Output File/final_demo/Rank123");
	static File file2=new File("/home/iitp/project/Output File/final_demo/CombinedRank1&Rank2");
	static File file3=new File("/home/iitp/project/Output File/final_demo/Extracted_SUI_cui");
	static TreeMap<String, ArrayList<String>> Dcui=new TreeMap<String,ArrayList<String>>();
	static TreeMap<String,ArrayList<String>> DR123=new TreeMap<String,ArrayList<String>>();
	static TreeMap<String,ArrayList<String>> DR1R2=new TreeMap<String,ArrayList<String>>();
	static TreeMap<String,ArrayList<String>> DR3=new TreeMap<String,ArrayList<String>>();
	static ArrayList<String> value;
	static ArrayList<String> value1;
	static ArrayList<String> value2=new ArrayList<String>();
	static ArrayList<String> value3=new ArrayList<String>();
	static ArrayList<String> value4=new ArrayList<String>();
	public void Combining_Rank123()  throws IOException {
		
		System.out.println("Started  E21 !!");
	//	FileReader fr=new FileReader(file1); //file reading cui score
		FileReader fr2=new FileReader(file2);// file reading rank1 & 2 Score
		FileReader fr3=new FileReader(file3);//file reading rank3 score 
	//	BufferedReader br=new BufferedReader(fr);//cuis core
		BufferedReader br1=new BufferedReader(fr2);//frequency score
		BufferedReader br2=new BufferedReader(fr3);//rank3 score
		FileWriter fw = new FileWriter(file4);    //writting to file
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line="";
		while((line=br1.readLine())!=null) //cui score reading file
		{	
			ArrayList<String> value=new ArrayList<String>();
			String[] array=line.split("\\|");
			for(int i=1;i<array.length;i++)
			{
				value.add(array[i]);
			}
			DR1R2.put(array[0],value);       // treemap containing sui vs cui with rank
			
		}
		br1.close();
		
		while((line=br2.readLine())!=null)// reading cui with frequency
		{	
			 value=new ArrayList<String>();
			String[] array=line.split("\\|");
			for(int i=1;i<array.length;i++)
			{   
				
				value.add(array[i]);
			}
			if(array.length>0)
			DR3.put(array[0],value);  // treemap containing sui vs cui entity types
			
		}
		br2.close();
		
		  
		for ( String key : DR3.keySet() ) // reading frquency treemap first
		{
			value=new ArrayList<String>();
				value=DR3.get(key);
				value4=new ArrayList<String>();
				
				
			//	System.out.println("key="+value);
				String currsui=key;
				for(int i=0;i<value.size();i++)
				{
				String[] comp=value.get(i).split("\\#");
				String cui=comp[0];
				String score=comp[1];
			//	System.out.println("score1"+score);
				if(DR1R2.containsKey(key))
				{ 
					 value1=new ArrayList<String>();
					 value1=DR1R2.get(key);
					 String subcui="";
					 String subscore;
					
					 for(int j=0;j<value1.size();j++)
					   {
						 subcui=value1.get(j).substring(0, 8);
						 String subval=value1.get(j).substring(8, 16);
						 
						 // New addition
						 
						 String[] B=value1.get(j).split("\\#");
						 
						 
						 //New addition
						 subscore=value1.get(j).substring(B[0].length()+1,value1.get(j).length());
					//	 System.out.println("subscore"+subscore);
					 	if(subcui.equals(cui))
					 	    {
					 		double Score1=(double) (Float.parseFloat(score)*Float.parseFloat(subscore));
					 	//	System.out.println("score1"+Score1);
					 	//	System.out.println("sui"+currsui+"cui"+cui+"subcui"+subcui);
					 		value4.add(subcui+subval+Score1);
					 		
					 		
					 		 DR123.put(key, value4);
					 	    }
			
					 	else
					 		continue;
					 	}
				
					
					}
				else 
					continue;
				
				
				}
				
				
			}
			
		 
	
		for ( String key : DR123.keySet() ) 
		{
			value1=new ArrayList<String>();
			value1=DR123.get(key);
			 String str="";
			for(int i=0;i<value1.size();i++)
			{
				str=str.concat(value1.get(i)+"|");
			}
			bw.write(key+"|"+str+"|"+"\n");
			System.out.println("key="+key+"array"+DR123.get(key) );
			//n=i++;
			 //System.out.println(HashKeys[0]);
			//count++;
			//System.out.println(count);
			
		}
		bw.close();
		System.out.println("Done E21");
		
	}


}

