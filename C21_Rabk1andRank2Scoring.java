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

public class C21_Rabk1andRank2Scoring {
	
	static File file1=new File("/home/iitp/project/Output File/final_demo/Extracted_SUI_cui");
	static File file2=new File("/home/iitp/project/Output File/final_demo/Extracted_SUI_freq");
	static File file3=new File("/home/iitp/project/Output File/final_demo/CombinedRank1&Rank2");
//	static File file4=new File("/home/iitp/project/DDRank3Score");
	static TreeMap<String, ArrayList<String>> Dcui=new TreeMap<String,ArrayList<String>>();
	static TreeMap<String,ArrayList<String>> DFre=new TreeMap<String,ArrayList<String>>();
	static TreeMap<String,ArrayList<String>> DSc=new TreeMap<String,ArrayList<String>>();
	static TreeMap<String,ArrayList<String>> DR3=new TreeMap<String,ArrayList<String>>();
	static ArrayList<String> value;
	static ArrayList<String> value1;
	static ArrayList<String> value2=new ArrayList<String>();
	static ArrayList<String> value3=new ArrayList<String>();
	static ArrayList<String> value4=new ArrayList<String>();
	
	public void Combining_Rank1Rank2()  throws IOException {
		
		System.out.println("Started C21 !!");
		
		FileReader fr=new FileReader(file1); //file reading cui score
		FileReader fr2=new FileReader(file2);// file reading frequency score
//		FileReader fr3=new FileReader(file4);//file reading rank3 score 
		BufferedReader br=new BufferedReader(fr);//cuis core
		BufferedReader br1=new BufferedReader(fr2);//frequency score
//		BufferedReader br2=new BufferedReader(fr3);//rank3 score
		FileWriter fw = new FileWriter(file3);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line="";
		while((line=br.readLine())!=null) //cui score reading file
		{	
			ArrayList<String> value=new ArrayList<String>();
			String[] array=line.split("\\|");
			for(int i=1;i<array.length;i++)
			{
				value.add(array[i]);
			}
			Dcui.put(array[0],value);       // treemap containing sui vs cui with rank
			
		}
		br.close();
		
		// Dcui is map containing string vs cui with rank
		
		while((line=br1.readLine())!=null)// reading cui with frequency
		{	
			 value=new ArrayList<String>();
			String[] array=line.split("\\|");
			for(int i=1;i<array.length;i++)
			{   
				
				value.add(array[i]);
			}
			if(array.length>0)
			DFre.put(array[0],value);  // treemap containing sui vs cui with frequency
			
		}
		br1.close();
		/*
		while((line=br2.readLine())!=null)// reading cui with frequency
		{	
			 value=new ArrayList<String>();
			String[] array=line.split("\\|");
			for(int i=1;i<array.length;i++)
			{   
				
				value.add(array[i]);
			}
		//	System.out.println("sui-"+array[0]+"value-"+value);
			if(array.length>0)
			DR3.put(array[0],value);  // treemap containing sui vs cui with frequency
			
		}
		br2.close();
	/*	for(String key: DR3.keySet())
		{   
			 value=new ArrayList<String>();
			 value=DR3.get(key);
			 System.out.println(value);
			
			System.out.println("key"+key+"DR3"+DR3.get(key));
		}
		*/
		
		value=new ArrayList<String>();
		for ( String key : DFre.keySet() )  // reading frquency treemap first
		{
			value=DFre.get(key);			// Value arraylist containing frequency
			String str="";
			String str4="";
			
			String StrScore="";
			for(int i=0;i<value.size();i++)
			{
			//	str=value[i].substring(7);
				str=value.get(i).substring(0, 8); //getting cui
			//	String[] A=value.get(i).split("\\$");
				String[] B=value.get(i).split("\\#");
			//	int alength=A[1].length();
				int blength=B[0].length();
				int L=value.get(i).length();
				StrScore=value.get(i).substring(blength+1, value.get(i).length()); // getting score value //Error Point
				str4=value.get(i).substring(9,blength); // getting frequency
	//J			System.out.print("value="+value.get(i)+"\n");  
				value1=new ArrayList<String>();
				
				value1=Dcui.get(key); 		// getting cui from treemap with rank 
				String str1="";
				String str5="";
				String StrScore1="";
				for(int j=0;j<value1.size();j++)
				{
					str1=value1.get(j).substring(0, 8);
					StrScore1=value1.get(j).substring(14, value1.get(j).length());
					str5=value1.get(j).substring(9, 13);
				//	System.out.println(StrScore1+"rank-"+str5);  
					if(str.equals(str1))
					{
						
				//	String str2="";
					
				//	String str6="";
				//	String StrScore2="";
				//	value4=new ArrayList<String>();
				//	value4=DR3.get(key);
				//	System.out.println("DR3 value="+ value4);
				//	for(int k=0;k<value1.size();k++)
				//	{
				//	str2=value1.get(j).substring(0, 8);
				//		StrScore1=value1.get(j).substring(14,17);
				//		if(str2.equals(str1))
				//				{
		float Score=(float) (Float.parseFloat(StrScore)*Float.parseFloat(StrScore1));
					//	System.out.println(Score);
						
					//	if(str1!=null)
						value2.add(str1+"f"+str4+"R"+str5+"#"+Score);
						
				//				}
				//	}
				}
				
			}
			}
			DSc.put(key, value2);
			value2=new ArrayList<String>();
		
		//	System.out.println( key+DFre.get(key) );
			//n=i++;
			 //System.out.println(HashKeys[0]);
			//count++;
			//System.out.println(count);
			
		
		}
		value2=new ArrayList<String>();
		for ( String key1 : DSc.keySet() ) 
		{
			
		   value2=DSc.get(key1);
		   String str1="";
		//	System.out.println( key1+DSc.get(key1) );
			for(int i=0;i<value2.size();i++)
			{
			 str1=str1.concat(value2.get(i)+"|");
			}
			System.out.println(key1+"|"+str1);
			bw.write(key1+"|"+str1);
			bw.write("\n");
			//n=i++;
			 //System.out.println(HashKeys[0]);
			//count++;
			//System.out.println(count);
			
		}
		bw.close();
		
		System.out.println("Done C21");
		
	}


	
}

