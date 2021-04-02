package rungame;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class CalcRank {
	public static String point;
	public static boolean result;
	public static int min=0;
	private static String nickname;

	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public CalcRank(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}


	public static ArrayList <CalcRank> arr1 = new ArrayList<CalcRank>();	


	public static void resetRank(ArrayList<CalcRank> arr1) {
		for(int i=0;i<5;i++) {
			arr1.get(i).name="default";
			arr1.get(i).score=0;
		}

	}//resetRank-end


	public static boolean checkPoint(String name,int point){//랭킹에 들어갈수있는 점수인지 확인하는 메서드
		if(point>min) {
			result=true;
			min=point;//항상 min보다 큰 점수가 들어올때만 true가 됨으로 min을 업데이트 시켜준다.
			arr1.set(4,new CalcRank(name, point));//replace로 변환
		}
		return result;
	}//checkPoint-end



	public static void getRank() {//점수를 비교해서 순서대로 정렬하기위한 메서드
		int idx[]= {0,1,2,3,4};
		for(int i=0;i<5;i++) {
			for(int j=0;j<5-i;j++) {
				if(arr1.get(j).getScore()<arr1.get(j+1).getScore()) {
					int tmp=arr1.get(j).getScore();
					arr1.get(j).setScore(arr1.get(j+1).getScore());
					arr1.get(j+1).setScore(tmp); //값교환

					tmp=idx[j];
					idx[j]=idx[j+1];
					idx[j+1]=tmp; //인덱스 값 교환

				}//if-end

			}//for j end

		}//for-i end

		min=arr1.get(4).getScore();//min update
	}//getRank()-end


	public static String[] printRank(ArrayList<CalcRank> arr1) {
		String[] str =new String[150];
		for(int i=0;i<5;i++) {

			str[i]= (i+1)+"등\t"+ arr1.get(i).getName()+"\t\t"+arr1.get(i).getScore()+"점\n";
		}
		return str ;
	}//printRank-end


	public static void makeRank() {//Ranking.txt를 만드는 메서드
		
		resetRank(arr1);

		//일단 이름이랑 점수를 갖고온다.
		try {
			BufferedReader br1 =new BufferedReader(new FileReader("Nickname.txt"));
			nickname=(br1.readLine()).trim();
			BufferedReader br2 =new BufferedReader(new FileReader("Score.txt"));//비어있으면 오류남
			point=(br2.readLine()).trim();//현재 point는 string
			br1.close();
			br2.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		//point를 string-> int 로 변환
		try{
			int total =Integer.parseInt(point);
			checkPoint(nickname,total);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}

		//그다음에 함수걸러서 넣자.

		getRank();

		String[] str =new String[6];
		str=printRank(arr1);//출력문을 집어 넣음
		
		//출력문을 읽어서 txt파일로 저장

		try{
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("Ranking.txt",true)));
			for(int i=0;i<5;i++) {
				pw.append(str[i]);
			}
			pw.close();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}


	}


}//class-end



