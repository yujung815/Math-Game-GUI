package rank;

import java.io.*;


public class GetRank {//��ũ�ҷ��ͼ� �迭�� ����

	static String score="";
	static String name="";
	//�̸��̶� ���� default�� ����.
	static BufferedReader br1;
	static BufferedReader br2;


	public String[] getRName() throws IOException{

		try {
			br1 =new BufferedReader(new FileReader("D:\\SW�ǽ�\\rungame\\rank_names.txt"));
			String s="";
			while((s=br1.readLine())!=null) {
//				System.out.println(s);
				name=s;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			br1.close();
		}

		String[] arrNames = name.split(",");

/*		for(int i=0;i<arrNames.length;i++) {

			System.out.println(i+arrNames[i]);
		}*/
		return arrNames;

	}//getRName-end





	public String[] getRScore(){
		try {
			br2 =new BufferedReader(new FileReader("D:\\SW�ǽ�\\rungame\\rank_scores.txt"));
			String s="";
			while((s=br2.readLine())!=null) {
				System.out.println(s);
				score=s;
			}
			br2.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		String[] arrScores=score.split(",");
	
		return arrScores;
	}//getRScore()-end


}//class-end
