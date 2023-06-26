package system;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class G21_Accuracy_check {

	
	static File filer=new File("/home/iitp/project/Output File/final_demo/MRDEF (copy).tsv");
	static File fileread=new File("/home/iitp/Desktop/Output3 (another copy)");
	static File filewrite=new File("/home/iitp/Desktop/output_demo1");
	
	static TreeMap<String, String> map=new TreeMap<String,String>();
	static HashMap<String, String> map1=new HashMap<String,String>();
	static String str="";
	static TreeMap<Double, String> map3=new TreeMap<Double,String>();
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Started  !!");
		
		FileReader fr=new FileReader(filer);
		 BufferedReader br=new BufferedReader(fr);
		 FileReader fr1=new FileReader(fileread);
		 BufferedReader br1=new BufferedReader(fr1);
		 FileWriter fr2=new FileWriter(filewrite);
		 BufferedWriter bw=new BufferedWriter(fr2);
		
		
		 String line="";
	
		 
		 while((line=br.readLine())!=null)
		 {
			 String[] array=line.split("\\s+");
		/*	 Pattern pattern = Pattern.compile("\".\"");
		
			 Matcher matcher = pattern.matcher(line);
			 String str=matcher.group();
		*/
			 
			 String str="";
			 for(int i=1;i<array.length;i++)
				 str=str.concat(array[i]+" ");
			 map.put(array[0], str);

			 

		 }
		 int count=0;
		 int total_word=0,match=0,not_match=0,blank_lemma=0;
		 try
		 {
			 
		 while((line=br1.readLine())!=null )
		 {
			 count++;
			 if((count%2)!=0)
			 {	
				 total_word++;
			 String[] arra=line.split("\\|");
			 String Test_word=arra[0];
			 String[] temp=arra[1].split("\\s+");
		//	 System.out.println("first value="+temp[1]);
			 int j;
			 String cui="",cui2="",prev="",curr="";
			 
			 String lemma_word="";
			 map1=new HashMap<String,String>();
			 if(!temp[1].equals("is"))
			 {
				 match++;
				 for( j=1;j<arra.length;j++)
				 {
					 cui=arra[j].split(":")[3].split("f")[0];
					 cui2=arra[j].split(":")[2].concat("\t"+arra[j].split(":")[3]);
					 lemma_word=arra[j].split(":")[0];
					 curr=lemma_word;
					 if(!lemma_word.equals(" "))//) && (!(prev==curr))*/
		//			 System.out.println("cui="+cui+" Lemma="+lemma_word);
					 {
						 map1.put(lemma_word, cui2);
						 
				 
					 }
					 else blank_lemma++;
					  prev=curr;
				 }
				 System.out.println("Test Word="+Test_word);
				 bw.write("Test Word="+Test_word+"\n");
			/*	
				 
				 System.out.print("Lemma Word");

				
				 bw.write("Lemma Word"+"\t");
				 System.out.print("     ");
				 for(int k=1;k<Test_word.length()-10;k=k+2)
				 {
					 System.out.print(" ");
					 bw.write("\t");
				 }
				 
				 
				 System.out.print("COSINE VALUE"+"     "+"CUI"+"     ");
				 System.out.println("Definition");
				 bw.write("COSINE VALUE"+"\t"+"CUI"+"\t"+"Definition"+"\n");			
				 
			*/	 
				 
				 
				 for ( String key : map1.keySet() ) 
				 {
					System.out.print(key+"  |   ");							
					bw.write(key+"\t"+map1.get(key)+"\t");		
					str=str.concat(key+"|"+map1.get(key)+"|");
					
		//			 System.out.print("     ");
		//			 for(int k=1;k<lemma_word.length()-10;k++)
		//				 System.out.print(" ");
					
					 
					 System.out.print(map1.get(key)+"   |    ");   
					 String key_cui=map1.get(key).split("\t")[1].split("f")[0];
				//	 System.out.println("key_cui"+key_cui);
					if(map.containsKey(key_cui))
					{
						System.out.println(map.get(key_cui));      
						str=str.concat(map.get(key_cui));
					bw.write(map.get(key_cui)+"\n");			
				//		call_func(str);
						 str="";
					}
					else
					{
						System.out.println(" This CUI not found in UMLS");
						bw.write(" This CUI not found in UMLS"+"\n");
						
					}
				//	System.out.println("key1="+key1+" string="+map.get(key1));
					map3=new TreeMap<Double,String>();
					
				 }
				 for(Double key: map3.keySet())
				 {
					 System.out.println(map3.get(key));
					 bw.write(map3.get(key)+"\n");
				 }
				 
			 }
			 else
			 {
				 not_match++;
				 bw.write("Test word="+Test_word+"\n"+"No CUI generated for this Test Word as its lemma generated doesn't have corresponding SUI Present in UMLS");
				 System.out.println("Test word="+Test_word);
				 System.out.println("No CUI generated for this Test Word as its lemma generated doesn't have corresponding SUI Present in UMLS");
			 }
			 System.out.println(" ");
			 }
			
			 bw.write("\n");
		 }
		 
		
		 }
		 catch(Exception e)
		 {
			 System.out.println("Total value="+total_word);
			 System.out.println("Words whose SUI not found="+not_match++);
			 System.out.println("Blank Lemma Generated="+blank_lemma);
			 
		 }
		 
		 bw.write("Total Test Word="+total_word+"\n"+"Words whose SUI not found="+not_match+"\n"+"Blank Lemma Generated="+blank_lemma);
		 bw.close();
		 }

	private static void call_func(String str2) {
		// TODO Auto-generated method stub
		String[] array1=str2.split("\\|");
		String value=array1[1].split("\t")[0];
		map3.put(Double.parseDouble(value) , str2);
		
	}
		 
	}
	
	


