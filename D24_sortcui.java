package system;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


// Sort cui 

public class D24_sortcui {
	
	

	static D23_Entitypriority A=new D23_Entitypriority();
	 static D22_Rank3Score1 B=new D22_Rank3Score1();
	 static D24_CompareEntity D =new D24_CompareEntity();
	 static HashMap<String,ArrayList<String>> suivscui;//tree containing sorted cui vs sui
	 static HashMap<String, TreeMap<String, Float>> suivscui1;
	 static TreeMap<Integer, String> sort;
	 static ArrayList<String> sortedarray;
	 static ArrayList<String> array;
	 
	 
	 static HashMap<Integer,ArrayList<String>> temp;
	 
	 static String tempKey;
	 
	 public static <K, V extends Comparable<V>> Map<K, V> 
	    sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = 
	             new Comparator<K>() {
	      public int compare(K k1, K k2) {
	        int compare = 
	              map.get(k1).compareTo(map.get(k2));
	        if (compare == 0) 
	          return 1;
	        else 
	          return compare;
	      }
	    };
	 
	    Map<K, V> sortedByValues = 
	      new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	  }
	 
	 
	 
	 static int count=0;
	 
	 
	public ArrayList<String> sort(String tempKey, TreeMap<String, Float> cuisort) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Started sortcui!!"+count++);
		System.out.println("Started D24_sortcui");
		
		suivscui=new HashMap<String,ArrayList<String>>();
		 suivscui1=new HashMap<String, TreeMap<String, Float>>();
		 suivscui1=B.Priority(); //Map containing sui|cui with array
		 suivscui=B.arrayvalue();//Map containing suivscui with value
		 sort=new TreeMap<Integer, String>();
		 array=new ArrayList<String>();
		 sortedarray=new ArrayList<String>();
		// System.out.println(cuisort);
		 temp=new HashMap<Integer,ArrayList<String>>();
		 Map sortedMap = sortByValues(cuisort);
		 // Get a set of the entries on the sorted map
		 
		    Set set = sortedMap.entrySet();
		 
		    // Get an iterator
		    Iterator i = set.iterator();
		   int count=0;
		   
		   String prevcui="";
		   String currcui="";
		    // Display elements
		   int prevvalue=0;
		    while(i.hasNext()) 
		    {
		      Map.Entry me = (Map.Entry)i.next();
		//7      System.out.print(me.getKey() + ": ");
		//8      System.out.print(me.getValue());
		      int currvalue=(int) me.getValue();
		      currcui=(String) me.getKey();
		      count++;
		      float[] arr=new float[5];
		      if(prevvalue==currvalue)
		      { 
		    	  String str=tempKey.concat("|"+prevcui);
		    	  String str1=tempKey.concat("|"+currcui);
		    //	  System.out.println("sui inside loop"+ str);
		    	 arr=D.entity(str,str1);
		    	 if(arr[0]>arr[1])
		    	 {
		    		 int s=array.size();
		    	 array.set(array.size()-1, currcui);
		    	 //array.size()++;
		    	 array.add(prevcui);
		    	 }
		    	
		    	 else
		    	 {
		    	//1	 array.add((String) me.getKey());
		    	 }
		    	 continue;
		      }
		     
		      array.add((String) me.getKey());
		    //  System.out.println("p"+prevvalue+"c"+currvalue);
		   //   System.out.println(count);
		      System.out.print(" ");
		      prevvalue=currvalue;
		      prevcui=currcui;
		     
		    }
		  temp.put(count, array);
		 array=temp.get(count);
		 String str="";
 		
	   for(int j=array.size();j>0;j--)
	   {
		   //str=array.get(--j);
		  sortedarray.add(array.get(--j));
		   ++j;
	   }

	//5	System.out.println("array"+array);
	//	 System.out.println("stored arraylist"+sortedarray);
	
		// System.out.println("");
	//	 System.out.println(sortedarray);
		    
		    
		System.out.println("");
		
		
		System.out.println("D24_sortcui");
		return sortedarray;
	}






	
	
	

}

