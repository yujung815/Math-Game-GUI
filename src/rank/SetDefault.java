package rank;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SetDefault {//디폴트 랭크세팅하기
	static String[] names = {"default","default","default","default","default"};
	static int[] scores = {0,0,0,0,0};
	
	
	public  void setDName() {
	try{
		PrintWriter pw1=new PrintWriter(new BufferedWriter(new FileWriter("rank_names.txt")));
		for(int i=0;i<5;i++) {
			pw1.append(names[i]+",");		
		}
		pw1.close();
	}catch(IOException ioe) {
		ioe.printStackTrace();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}//setDName-end
	
	public void setDScore() {
		try {
			PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter("rank_scores.txt")));
			for(int score:scores) {	
			pw2.append(String.valueOf(score)+",");
			}
			pw2.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		}//setDScore-end
	
	}//Class-end


