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


	public static boolean checkPoint(String name,int point){//��ŷ�� �����ִ� �������� Ȯ���ϴ� �޼���
		if(point>min) {
			result=true;
			min=point;//�׻� min���� ū ������ ���ö��� true�� ������ min�� ������Ʈ �����ش�.
			arr1.set(4,new CalcRank(name, point));//replace�� ��ȯ
		}
		return result;
	}//checkPoint-end



	public static void getRank() {//������ ���ؼ� ������� �����ϱ����� �޼���
		int idx[]= {0,1,2,3,4};
		for(int i=0;i<5;i++) {
			for(int j=0;j<5-i;j++) {
				if(arr1.get(j).getScore()<arr1.get(j+1).getScore()) {
					int tmp=arr1.get(j).getScore();
					arr1.get(j).setScore(arr1.get(j+1).getScore());
					arr1.get(j+1).setScore(tmp); //����ȯ

					tmp=idx[j];
					idx[j]=idx[j+1];
					idx[j+1]=tmp; //�ε��� �� ��ȯ

				}//if-end

			}//for j end

		}//for-i end

		min=arr1.get(4).getScore();//min update
	}//getRank()-end


	public static String[] printRank(ArrayList<CalcRank> arr1) {
		String[] str =new String[150];
		for(int i=0;i<5;i++) {

			str[i]= (i+1)+"��\t"+ arr1.get(i).getName()+"\t\t"+arr1.get(i).getScore()+"��\n";
		}
		return str ;
	}//printRank-end


	public static void makeRank() {//Ranking.txt�� ����� �޼���
		
		resetRank(arr1);

		//�ϴ� �̸��̶� ������ ����´�.
		try {
			BufferedReader br1 =new BufferedReader(new FileReader("Nickname.txt"));
			nickname=(br1.readLine()).trim();
			BufferedReader br2 =new BufferedReader(new FileReader("Score.txt"));//��������� ������
			point=(br2.readLine()).trim();//���� point�� string
			br1.close();
			br2.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("������ ã�� �� �����ϴ�.");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		//point�� string-> int �� ��ȯ
		try{
			int total =Integer.parseInt(point);
			checkPoint(nickname,total);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}

		//�״����� �Լ��ɷ��� ����.

		getRank();

		String[] str =new String[6];
		str=printRank(arr1);//��¹��� ���� ����
		
		//��¹��� �о txt���Ϸ� ����

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



