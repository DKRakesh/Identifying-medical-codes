package system;


import java.util.ArrayList;
import java.util.HashMap;



  //  Comparing entity 

public class D24_CompareEntity  {
	static D22_Rank3Score1 A=new D22_Rank3Score1();//sui|cui [T01$Entity Arraylist]
	static D21_Rank3Score     B=new D21_Rank3Score ();//getting sui
	String sui;
	static D23_Entitypriority C=new D23_Entitypriority();
	HashMap<String, Float> Entity=new HashMap<String,Float>();

	static HashMap<String,ArrayList<String>> suivscui;
	static ArrayList<String> entity;
	static ArrayList<String> entity1;
	static float arr[]=new float[5];
	 static int count=0;
	
	public float[] entity(String prevcui, String currcui) {
		// TODO Auto-generated method stub
		
		System.out.println("Started D24");
		System.out.println(" compare entity"+count++);
		
		suivscui=new HashMap<String,ArrayList<String>>();
		suivscui=A.arrayvalue();
	//	sui=B.getsui();
		Entity=C.Priority();
		
	//4	System.out.println("prevsui"+prevcui+"currsui"+currcui);
		entity=suivscui.get(prevcui);
		entity1=suivscui.get(currcui);
	//2	System.out.println("entity"+entity);
	//1	System.out.println("entity1"+entity1);
		
		
		
		
			String[] comp = entity.get(0).split("\\$");
			String[] comp1 = entity1.get(0).split( "\\$");
			//System.out.println("comp"+comp.get()+"comp1"+comp1[1]);	
			Float prevval=Entity.get(comp[1]);
			Float currval1=Entity.get(comp1[1]);
		//3	System.out.println(prevval+"CV"+currval1);
			
			arr[0]=prevval;
			arr[1]=currval1;
		
		//	System.out.println("int arra"+arr[1]);
		
		
	//	System.out.println("sui"+sui);
		
	/*	for(String tempKey: suivscui.keySet()){
			
			
			System.out.println("key-"+tempKey+" value-"+suivscui.get(tempKey));
		//	System.out.println("work in progress");
		}
		*/
			System.out.println("Done D24");
			return arr;
	}

}

