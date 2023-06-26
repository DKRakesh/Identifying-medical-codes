package system;

import java.io.IOException;

public class Main {

	static  A11_File_Modify A=new  A11_File_Modify();
	static B11_Extract_sui B=new B11_Extract_sui();
	static C11_Nove_8	C=new C11_Nove_8();
	static A21_Extract_SUI A2=new A21_Extract_SUI();
	static C21_Rabk1andRank2Scoring C2=new C21_Rabk1andRank2Scoring();
	 static D21_Rank3Score D2=new  D21_Rank3Score();
	static E21_Rank123 E2=new E21_Rank123();
	static F21_Entity_to_cui F2=new F21_Entity_to_cui();
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Started !!");
		
		A.Creating_lemma_generated_file();
		//Creation of lemma generated file from Text Document
		
		//Done
		
		
		B.Extracting_SUI_Corresponding_lemma();
		// Extracting SUI of Corresponding Lemma 
		
		
		
		//Done
		
		
		C.Calculating_of_cosine();
		//Calculating of cosine from sui extracted file
		
		//Done
		
		
		A2.Extracting_SUI_of_Test_File();
		
		//Extracting only those SUI whose Entities are present in Test file from
		// different files Frequency Rank file, CUI Rank file and TUI Type Rank
		
		//Done
		
		C2.Combining_Rank1Rank2();
		//Combining Rank1 and Rank2 Scoring
		
		//Done
		
		D2.Creating_Rank_3();
		//Creation of Rank3
		
		//Done
		
		
		E2.Combining_Rank123();
		//Combining Rank1,2 & 3
		
		//Done
		
		
		F2.Final_endtend_system();
		//Final End-to-End System
		
		//Done
		
	}
	
}
