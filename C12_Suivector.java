package system;



import java.util.ArrayList;
import java.util.TreeMap;

public class C12_Suivector {
	
	
	static double[] value=new double[60];
	static ArrayList<String> addedvalue=new ArrayList<String>();
	static ArrayList<String> addedvalue1=new ArrayList<String>();
	static ArrayList<String> temp_arra=new ArrayList<String>();
	static TreeMap<ArrayList<String>,Integer> map=new TreeMap<ArrayList<String>,Integer>();
	static String temp;
	
	
	public ArrayList<String> suivector(String line3, int flag) {
	//	System.out.println("adding value");
		// TODO Auto-generated method stub
		System.out.println(" suivector !! C12");
	//	System.out.println("flag value="+flag);
		String s;
		String[] word1=line3.split(" ");
		int n=word1.length/50;
	//	System.out.println("n="+n);
		int i=0,k=0;
		String entity="";
		while(i<n)
		{
			k=(50*i)+i;
			
			entity=entity.concat(word1[k]+" ");
			i++;
		}
		for(int z=1;z<=50;z++)
		{
		//	value[k]=0;
	//	value[k]=Float.parseFloat(word1[k]);
		int j=0;
		float add=0;
		int l=z;
		while(j<n)
		{
			float Val=Float.parseFloat(word1[l]);
			
			add=add+Val;
			l=l+51;
			j++;
			
		}
	//	System.out.println("add="+add);
		double valu=(double)Math.round((add/n) * 10000d) / 10000d;
		value[z]=valu;
		}
		addedvalue=new ArrayList<String>();
	//	String entity=word1[0]+word1[51];
		addedvalue.add(entity+" ");
//	System.out.println("key="+key+" "+"entity="+entity);
	s="";
	for(int c=1;c<=50;c++){
	//	System.out.println(value[c]);
		 s= String.valueOf(value[c]);
		addedvalue.add(s);
	//	System.out.println("addedvalue="+addedvalue);
	}
	
	for(int c=1;c<=50;c++){
		//	System.out.println(value[c]);
			 s= String.valueOf(value[c]);
			addedvalue1.add(s);
		//	System.out.println("addedvalue="+addedvalue);
		}
//	System.out.println(entity+addedvalue1);
//	map=calculating_cosine_value(entity,addedvalue,flag);
	
//	System.out.println("returning value");
//	System.out.println("added value="+addedvalue);
	System.out.println("Done C12");
	return addedvalue;
		
	}
	private TreeMap<ArrayList<String>, Integer> calculating_cosine_value(String entity, ArrayList<String> addedvalue12, int flag) {
		// TODO Auto-generated method stub
		
		 TreeMap<ArrayList<String>,Integer> map=new TreeMap<ArrayList<String>,Integer>();
	//	System.out.println("entity="+entity+"arraylist="+addedvalue12+"int="+flag);
		map.put(addedvalue12, flag);
		return map;
		
		
		
	}
	


}

