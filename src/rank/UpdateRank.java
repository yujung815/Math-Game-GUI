package rank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateRank {
	
	public String[] changeR(String[] score,int total) {
		score[4]=String.valueOf(total);
		
		return score;
	}
	public String[] changeN(String[] names) {
		String nickname="";
		try {
			BufferedReader br =new BufferedReader(new FileReader("Nickname.txt"));
			nickname=(br.readLine()).trim();
			br.close();
			
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("파일을 찾을 수 없습니다.");
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		names[4]=nickname;
		return names;
	}
	
	public void sortRSave(String[] scores,String[] names){
		for(int j=0;j<4;j++) {
			for(int i=0;i<4-j;i++) {
				if(Integer.parseInt(scores[i])<Integer.parseInt(scores[i+1])) {
					System.out.println("비교가능");
					String tmp="";
					tmp=scores[i];
					scores[i]=scores[i+1];
					scores[i+1]=tmp;
					
					tmp=names[i];
					names[i]=names[i+1];
					names[i+1]=tmp;				

				}//if-end
			}//for-end
			}//j for end
		
		try{
			PrintWriter pw1=new PrintWriter(new BufferedWriter(new FileWriter("rank_names.txt",false)));
			for(int i1=0;i1<5;i1++) {
				pw1.append(names[i1]+",");		
			}
			pw1.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		try{
			PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter("rank_scores.txt",false)));
			for(int i1=0;i1<5;i1++) {
				pw2.append(scores[i1]+",");		
			}
			pw2.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
		
		
	//txt파일에 다시 저장하기

	

			
	
	
	

	
	
}
