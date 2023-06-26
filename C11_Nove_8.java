package system;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C11_Nove_8 {
	
	
	static File w2v=new File("/home/iitp/project/Output File/final_demo/skip50");
//	static File entity=new File("/home/iitp/Desktop/extra/D/ezdi/12_Doc_Data/output/lemmas_12Doc/output_lemma");
	static File entity=new File("/home/iitp/project/Output File/final_demo/output_lemma");
	static File entitysui=new File("/home/iitp/project/Output File/final_demo/Entity_cosine_sui");
	static ArrayList<String> matrix=new ArrayList<String>();
	static ArrayList<String> addedvalue=new ArrayList<String>();
	static TreeMap<Integer,ArrayList<String>> map=new TreeMap<Integer,ArrayList<String>>();
	static C12_Suivector A=new C12_Suivector();
	static String SUI="";
	static double sq_val,sq_val1;
static int flag=0;

	
public void Calculating_of_cosine() throws IOException {
		
		System.out.println("Started !! C11");
		
		
		
FileReader fr=new FileReader(entity);
		
		BufferedReader br=new BufferedReader(fr);
		
		
		FileWriter fw=new FileWriter(entitysui);
		 BufferedWriter bw=new BufferedWriter(fw);
		
		ArrayList<String> temp_testarray=new ArrayList<String>();
		ArrayList<String> temp_lemmaarray=new ArrayList<String>();
		sq_val=0;sq_val1=0;

		String line="";
		
	//	System.out.println(" Part 1");
		
		while((line=br.readLine())!=null)			
		{
			map=new TreeMap<Integer,ArrayList<String>>();
			String[] arra=line.split("\\|");
			String[] medical_words = new String[10]; 
			int n=0;
			for(int i=0;i<arra.length;i++)
			{
				
				if (i==0)
				{
					flag=0;
		 medical_words=arra[0].split(" ");
			 n= medical_words.length;
		//	 System.out.println("Test words="+medical_words);
				}
				else
				{
					
					flag=i;
					
					String[] medical=arra[i].split("=");
					 medical_words=medical[1].split(" ");
					 SUI=medical[0];
					 n=medical_words.length;
				}
			
				String line3="";
			int j=0;
			while(j<n)
				{	
			String temp=medical_words[j];
			FileReader fr1=new FileReader(w2v);
			
			BufferedReader br1=new BufferedReader(fr1);
			
			String line1="";
			while((line1=br1.readLine())!=null)
					{	
				String[] array=line1.split(" ");
				if(array[0].equals(temp))
						{
			    matrix=new ArrayList<String>();
				line3=line3.concat(line1);
			//	System.out.println("line="+line3);
					
						}
				else
					continue;
				
					}
			br1.close();
			j++;
			
				}
			addedvalue=new ArrayList<String>();
	//		System.out.println("flag value="+flag);
	//		System.out.println("checking i value="+i);
		
			addedvalue=A.suivector(line3,flag);
			addedvalue.add(SUI);
			map.put(flag,addedvalue);
		//	System.out.println("addedvalue="+addedvalue);
		//	System.out.println("map value");
			
			}
			
		//	System.out.println("Final Lap !!");
			TreeMap<Double,String> sort=new TreeMap<Double,String>(Collections.reverseOrder()); 
			
			// TREEMAP TO SORT A/Q TO COSINE VALUE
	//J 	System.out.println(" ");
		bw.write(" ");
			for(Integer key: map.keySet())
			{
			//	System.out.println("printing !!"+key);
				if(key==0)
				{
			//		System.out.println(" test word ");
					temp_testarray=map.get(key);
					for(int i=1;i<=50;i++)			
						sq_val=sq_val+((Double.parseDouble(temp_testarray.get(i)))*(Double.parseDouble(temp_testarray.get(i))));
					sq_val= Math.sqrt(sq_val);
	//J				System.out.print(temp_testarray.get(0)+"|");
					bw.write(temp_testarray.get(0)+"|");
					
				}
				else
				{
			//		System.out.println("lemma word");
					temp_lemmaarray=map.get(key);
					for(int j=1;j<=50;j++)
					sq_val1=sq_val1+((Double.parseDouble(temp_lemmaarray.get(j)))*(Double.parseDouble(temp_lemmaarray.get(j))));
					sq_val1= Math.sqrt(sq_val1);
			//		System.out.println("lemma="+temp_lemmaarray.get(0));
				}
				if(key!=0)
				{
				//	System.out.println(" finding cosine value");
					double value=0;
					for(int i=1;i<=50;i++)
						value=value+(Double.parseDouble(temp_lemmaarray.get(i)))*(Double.parseDouble(temp_testarray.get(i)));
					double cosine_value=(value/(sq_val*sq_val1));
				//	System.out.print("lemma word="+temp_lemmaarray.get(0)+"Cosine value="+cosine_value);
					sort.put(cosine_value, temp_lemmaarray.get(51)+"$"+temp_lemmaarray.get(0));
				}
			
			
			
			}
			
			  Set set = sort.entrySet();
			    Iterator i = set.iterator();
			    // Display elements
			    while(i.hasNext()) {
			      Map.Entry me = (Map.Entry)i.next();
			      System.out.print(me.getKey() + ": ");
			      System.out.print(me.getValue()+"|");
			      
			      bw.write(me.getKey() + ": "+me.getValue()+"|");
			    }
			
			
			
//			for(Double key: sort.keySet())
//			{
//				System.out.print(sort.get(key)+"="+key+"|" );
//			}
			
			bw.write("\n");
		}
		bw.close();
	//J	System.out.println("end of while !!");
		System.out.println("Done C11");
		
	}


	
}

