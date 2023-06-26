package system;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class A12_Oct_Extract {
	
	

		
		
//		static File file1=new File("/home/iitp/Desktop/extra/D/ezdi/12_Doc_Data/output/lemmas_12Doc/aalborzi-1776-[5-9004994-1554]-[06052013]-[004149]-14@1234438847X.txt");
//		static File file2=new File("/home/iitp/Desktop/D/ezdi/12_Doc_Data/output/lemmas_12Doc/aalborzi-1776-[5-9004994-1554]-[06052013]-[004149]-14@1234438847X.txt");
	
//	static File file1=new File("/home/iitp/project/Output File/Final_demo/lemma_generated_file");
	static File file1 = new File("/home/iitp/project/Output File/final_demo/lemma_generated_file");

	static ArrayList<String> TUI=new ArrayList<String>(); 
		static int count=0,n=0;
		static String tui="";
		static ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		
		static int file_no=0;
		public void read(String path, int file_no) throws IOException {
			// TODO Auto-generated method stub
			
			System.out.println("Started A12");
			
//			
//			System.out.println("Output of file number="+ file_no);
//			System.out.println(""+"\n");
		//	file_no=file_no;
			

			
			FileWriter fw1 = new FileWriter(file1);
			
			
			BufferedWriter fwrite = new BufferedWriter(fw1);
			
	//		PrintStream myconsole=new PrintStream(new File("/home/iitp/project/Output File/Final_demo/lemma_generated_file"));
	//		System.setOut(myconsole);
			
			
			File file = new File(path);
	FileReader fr1=new FileReader(file);
	
	 TUI=Add();
	 //System.out.println("hkgfkj="+TUI.get(5));
			
			BufferedReader br1=new BufferedReader(fr1);
			String line="";
			while((line=br1.readLine())!=null)
				
			{
				
				
				
				String[] array=line.split("\\s+");
				int pos=0;
				for(int i=0;i<array.length;i++)
				{
				
					
					String str=array[i];
				//	System.out.println("lkjhl"+str);
					if(TUI.contains(str))
					{
						
						pos=i;
						tui=str;
						break;
					}
					else continue;
					
			//	System.out.println("hjlg="+array[i]);
			}
				String test_word="";
				for(int j=2;j<pos;j++)
				{
					test_word=test_word.concat(array[j]+" ");
				}
				String lemma_word="";
				int j=0;
				for(j=++pos;j<array.length;j++)
				{
					lemma_word=lemma_word.concat(array[j]+" ");
				}
				
		//		System.out.println("test="+test_word+"lemma="+lemma_word+"TUI"+tui);
		//		fwrite.write(creating_lemms_words(lemma_word,test_word,tui)+"\n");
				
				
				
				String print="";
				listOfLists = new ArrayList<ArrayList<String>>();
				String[] arraya=lemma_word.split("\\s+");
				 n=arraya.length;
				for(int i=0;i<n;i++)
					listOfLists.add(new ArrayList<String>());
				for(int i=0;i<n;i++)
				{
					String[] array1=arraya[i].split("@");
					for(int m=0;m<array1.length;m++)
						listOfLists.get(i).add(array1[m]);		
				}
		//		
		//		print=call_con(listOfLists,test_word,lemma_word,tui2);
				
				
				

				ArrayList<String> Temp=new ArrayList<String>(); 
				int n=1,m=0;;
				while(n<listOfLists.size())
				{
					int Size=listOfLists.get(0).size();
					for(int k=0;k<listOfLists.get(n).size();k++)
					{
						String temp=listOfLists.get(n).get(k);
						
						for(int l=0;l<listOfLists.get(0).size();l++)
						{
							String temp1=listOfLists.get(0).get(l).concat(" "+ temp);
						
								Temp.add(temp1);
							
							
						}
					}
					//listOfLists2.set(0)=Temp;
					for(int z=0;z<Temp.size();z++)
					{
						String str=Temp.get(z);
						if(z<Size)
						listOfLists.get(0).set(z, str);
						else
							listOfLists.get(0).add(str);
					}	
					Temp=new ArrayList<String>(); 
					n++;
				}
				//	call_func(listOfLists2,test_word,lemma_word,tui2);
				
				
		//J		System.out.print(test_word+"|"+lemma_word+"|"+tui+"|");
	
				
				fwrite.append(test_word+"|"+lemma_word+"|"+tui+"|");
				print=test_word+"|"+lemma_word+"|"+tui+"|";
		//		myconsole.print(print);
				
				for(int i=0;i<listOfLists.get(0).size();i++)
				{
		//J			System.out.print(listOfLists.get(0).get(i)+"|");
					print=print.concat(listOfLists.get(0).get(i)+"|");
		//			myconsole.print(listOfLists.get(0).get(i)+"|");
					fwrite.append(listOfLists.get(0).get(i)+"|");
					
				}
		
				
				
		//J		System.out.println(" ");
		
				
							fwrite.write("\n");
		//			myconsole.println(" ");
		//		
				
				
			}
		
			fwrite.close();
			
			
			System.out.println("Done A12");
			
			
		}

/*
		
		private static String creating_lemms_words(String lemma_word, String test_word, String tui2) throws IOException {
			// TODO Auto-generated method stub
			String print="";
			listOfLists = new ArrayList<ArrayList<String>>();
			String[] array=lemma_word.split("\\s+");
			 n=array.length;
			for(int i=0;i<n;i++)
				listOfLists.add(new ArrayList<String>());
			for(int i=0;i<n;i++)
			{
				String[] array1=array[i].split("@");
				for(int j=0;j<array1.length;j++)
					listOfLists.get(i).add(array1[j]);		
			}
	//		
	//		print=call_con(listOfLists,test_word,lemma_word,tui2);
			
			
			

			ArrayList<String> Temp=new ArrayList<String>(); 
			int n=1,m=0;;
			while(n<listOfLists.size())
			{
				int Size=listOfLists.get(0).size();
				for(int j=0;j<listOfLists.get(n).size();j++)
				{
					String temp=listOfLists.get(n).get(j);
					
					for(int k=0;k<listOfLists.get(0).size();k++)
					{
						String temp1=listOfLists.get(0).get(k).concat(" "+ temp);
					
							Temp.add(temp1);
						
						
					}
				}
				//listOfLists2.set(0)=Temp;
				for(int z=0;z<Temp.size();z++)
				{
					String str=Temp.get(z);
					if(z<Size)
					listOfLists.get(0).set(z, str);
					else
						listOfLists.get(0).add(str);
				}	
				Temp=new ArrayList<String>(); 
				n++;
			}
			//	call_func(listOfLists2,test_word,lemma_word,tui2);
			
			
			System.out.print(test_word+"|"+lemma_word+"|"+tui2+"|");
		//	fwrite.append(test_word+"|"+lemma_word+"|"+tui2+"|");
			print=test_word+"|"+lemma_word+"|"+tui2+"|";
			
			for(int i=0;i<listOfLists.get(0).size();i++)
			{
				System.out.print(listOfLists.get(0).get(i)+"|");
				print=print.concat(listOfLists.get(0).get(i)+"|");
			//	fwrite.append(listOfLists2.get(0).get(i)+"|");
				
			}
				System.out.println(" ");
			
			
			
			
			
			return print;
			
		}	
			
		
		
	private static String call_con(ArrayList<ArrayList<String>> listOfLists2, String test_word, String lemma_word, String tui2) throws IOException {
			// TODO Auto-generated method stub
	//	System.out.println("size="+listOfLists2.size());
		
		

		
		ArrayList<String> Temp=new ArrayList<String>(); 
		int n=1,m=0;;
		while(n<listOfLists2.size())
		{
			int Size=listOfLists2.get(0).size();
			for(int j=0;j<listOfLists2.get(n).size();j++)
			{
				String temp=listOfLists2.get(n).get(j);
				
				for(int k=0;k<listOfLists2.get(0).size();k++)
				{
					String temp1=listOfLists2.get(0).get(k).concat(" "+ temp);
				
						Temp.add(temp1);
					
					
				}
			}
			//listOfLists2.set(0)=Temp;
			for(int z=0;z<Temp.size();z++)
			{
				String str=Temp.get(z);
				if(z<Size)
				listOfLists2.get(0).set(z, str);
				else
					listOfLists2.get(0).add(str);
			}	
			Temp=new ArrayList<String>(); 
			n++;
		}
		//	call_func(listOfLists2,test_word,lemma_word,tui2);
		String print="";
		
		System.out.print(test_word+"|"+lemma_word+"|"+tui2+"|");
	//	fwrite.append(test_word+"|"+lemma_word+"|"+tui2+"|");
		print=test_word+"|"+lemma_word+"|"+tui2+"|";
		
		for(int i=0;i<listOfLists2.get(0).size();i++)
		{
			System.out.print(listOfLists2.get(0).get(i)+"|");
			print=print.concat(listOfLists2.get(0).get(i)+"|");
		//	fwrite.append(listOfLists2.get(0).get(i)+"|");
			
		}
			System.out.println(" ");
		//	fwrite.append("\n");
		

		//	fwrite.close();
			
			return print;
			
	}
			/*	for(int i=0;i<n;i++)
		{
			int m=listOfLists.get(i).size();
			
			System.out.print("row no ="+ i+" ");
			for(int j=0;j<m;j++)
				System.out.print(listOfLists.get(i).get(j)+" ");
			
			System.out.println(" ");
		}	
			
		}


	/*
	private static void call_func(ArrayList<ArrayList<String>> listOfLists2, String test_word, String lemma_word, String tui2) throws IOException {
		// TODO Auto-generated method stub
		

		System.out.print(test_word+"|"+lemma_word+"|"+tui2+"|");
		fwrite.write(test_word+"|"+lemma_word+"|"+tui2+"|");
		
		for(int i=0;i<listOfLists2.get(0).size();i++)
		{
			System.out.print(listOfLists2.get(0).get(i)+"|");
			fwrite.write(listOfLists2.get(0).get(i)+"|");
			
		}
			System.out.println(" ");
			fwrite.write("\n");
		

			fwrite.close();
			/*	for(int i=0;i<n;i++)
		{
			int m=listOfLists.get(i).size();
			
			System.out.print("row no ="+ i+" ");
			for(int j=0;j<m;j++)
				System.out.print(listOfLists.get(i).get(j)+" ");
			
			System.out.println(" ");
		}	
		System.out.println("iteration "+ ++count);	
	
	}
	
	*/

			
			
			
			
			
	


		private static ArrayList<String>  Add() {
			// TODO Auto-generated method stub
			TUI=new ArrayList<String>(); 
			
			TUI.add("PROBLEM");
			TUI.add("ANATOMICAL_STRUCTURE");
			TUI.add("PROCEDURE");
			TUI.add("MODIFIER");
			TUI.add("MEDICINE");
			
			TUI.add("BODY_MEASUREMENT");
			TUI.add("MEASUREMENT_VALUE");
			TUI.add("FINDING");
			TUI.add("LABORATORY_DATA");
			TUI.add("MEDICAL_DEVICE");
			return TUI;
			
		}


		
		
		
		
}



