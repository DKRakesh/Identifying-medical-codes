package system;



import java.util.HashMap;


// To decide priority of TUI Type

public class D23_Entitypriority {
	
	
	HashMap<String,Float> Entity=new HashMap<String,Float>();
	
	static int count=0;
	
	 HashMap<String, Float> Priority() {
		 
		 System.out.println("Started Entitypriority");
		 
		 System.out.println("Entity Priority!!"+count++);
		 
		 Entity=new HashMap<String,Float>();
		 
		 Entity.put("PROCEDURE", (float) 8);
		 Entity.put("PROBLEM", (float) 1.875);
		 Entity.put("MEDICINE", (float) 1.750);
		 Entity.put("MEDICAL_DEVICE", (float) 1.625);
		 Entity.put("ANATOMICAL_STRUCTURE", (float) 1.5);
		 Entity.put("FINDING", (float) 1.375);
		 Entity.put("LABORATORY_DATA", (float) 1.250);
		 Entity.put("null", (float) 1.125);
		 
	/*	 
		 for(String tempKey: Entity.keySet()){
				
				
					System.out.println("key-"+tempKey+"entity-"+Entity.get(tempKey));
				//	System.out.println("work in progress");
				}
				*/
		 
		return Entity;
	}

}

