package rungame;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import rungame.CalcRank.*;


public class GamePage extends JFrame{
	
	private static int i;
	private static int num1;
	private static int num2;
	private static String nickname;
	private static JLabel lblnick;
	private static JLabel lblshow;
	private static JLabel lblquestion;
	public static String question;
	public static int cnt=0; //문제바꾸는 용도 
	public static int trial = 3; //3번의 기회
	public static int opt;//사칙연산
	private static int point=0;//문제당 점수
	private static int total=0;//총 점수
	public static int answer;//정답
	private JPanel contentPane;
	private JTextField txtanswer;
	private static JButton btncheck = new JButton("\uD655\uC778");
	private JLabel lblwrong;
	private JLabel lbltotal;
	public interface TestInterface {

	}

	public static int getRandom(int cnt){
		int ran =0;	
		switch(cnt){
		case 0:
		case 1: int ran1 = (int)(Math.random()*10+1);	//-----------0~9까지 랜덤수
		ran=ran1;
		break;
		case 2: 
		case 3:
		case 4:
		case 5: int ran2 = (int)(Math.random()*89+10);//----------- 10~99까지 랜덤수
		ran=ran2;
		break;
		case 6:
		case 7:
		case 8:
		default:int ran3 =(int)(Math.random()*899+100);//------------ 100~999까지 랜덤수
		ran=ran3;
		break;
		
		}
		return ran;//random 정수값 리턴
	}//getRandom-end
	
	public static int getPoint(int cnt){
		point=0;	
		switch(cnt){
		case 0:
		case 1: 	//-----------0~9까지 랜덤수
		point+=10;
		break;
		case 2: 
		case 3:
		case 4:
		case 5: //----------- 10~99까지 랜덤수
		point+=20;
		break;
		case 6:
		case 7:
		case 8:
		default:;//------------ 100~999까지 랜덤수
		point+=30;
		break;
		
		}
		return point;//random 정수값 리턴
	}//getRandom-end



	public static int getOpt(int i) { //사칙연산 순환해주는 메서드

		switch(i%4) {
		case 0: opt='/'; 
		break;
		case 1: opt='+';
		break;
		case 2: opt='-';
		break;
		case 3: opt='*';
		break;
		default: opt='^';
		break;
		}

		return opt;
	}//getOpt-end
	public static int getAnswer(int n1, int n2, int i){
		switch(i%4) {
		case 0: answer=n1/n2;
		break;
		case 1: answer=n1+n2;
		break;
		case 2: answer=n1-n2;
		break;
		case 3: answer=n1*n2;
		break;
		default: answer=n1^n2;
		break;
		}
		return answer;
	}
	//클릭할때 cnt가 늘어날어남
	public static String getQuestion(int cnt) {

			
			 num1=getRandom(cnt);//cnt을 매개변수로 ->switch case 이용해서 random 숫자를 가져옴
			 num2=getRandom(cnt+1);//변수에 따로 넣은 이유는 출력할때 다시 호출하면 숫자가 또 변하기 때문.
			char opt =(char)getOpt(cnt);//사칙연산 변환 받기
			//System.out.printf("%d%c%d=?\n",num1,opt,num2);
			question=(num1+(opt+((num2)+"= ?")));
			answer=getAnswer(num1,num2,opt);
			
		return question;
	}
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
					GamePage frame = new GamePage();
					frame.setVisible(true);
			
			}//run() end
		});//EventQue.invokeLater
	}//main end

	/**
	 * Create the frame.
	 */
	public GamePage() throws NullPointerException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1200, 800, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblquestion = new JLabel("\uBB38\uC81C"+": "); //"문제 :"출력하는 라벨 
		lblquestion.setFont(new Font("바탕체", Font.BOLD, 60));
		lblquestion.setBounds(175, 173, 202, 184);
		contentPane.add(lblquestion);


		//btnenter.accActionListener


		txtanswer = new JTextField(); //답입력받는 textfield
		txtanswer.setFont(new Font("바탕체", Font.BOLD, 40));
		txtanswer.setBounds(414, 442, 274, 99);
		contentPane.add(txtanswer);
		txtanswer.setColumns(10);

		lblshow = new JLabel(getQuestion(cnt));
		lblquestion.setLabelFor(lblshow);
		lblshow.setBackground(Color.WHITE);
		lblshow.setFont(new Font("바탕체", Font.BOLD, 60));
		lblshow.setBounds(363, 173, 453, 184);
		contentPane.add(lblshow);


		btncheck.addMouseListener(new MouseAdapter() {//확인버튼 눌렀을때
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{String answer =(txtanswer.getText()).toString();//정답받아오기

				if(answer.isEmpty()) { //아무것도 없을때 예외처리
					showMessageDialog(lblshow,"정답을 입력해주세요!");		
							
				}else {//if-end
					answer =txtanswer.getText();//정답입력받아 String answer에 넣음
					int answer1=Integer.parseInt(answer);
					if (answer1==getAnswer(num1,num2,cnt)) {//정답일치확인
						lblwrong.setText("정답입니다!");
						getPoint(cnt);
						total+=point;
					}else {//정답확인 if-end
						lblwrong.setText("땡! 오답입니다!");
						trial--;
						if (trial==0) {
							showMessageDialog(lblshow,"총 점수는 "+total+"점 입니다.");
							try{
								PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Score.txt")));
								String str=String.valueOf(total);//점수int를 string으로 변환
								pw.append(str);
								pw.close();
								
							}catch (IOException e){
								e.printStackTrace();
							}
							//CalcRank 로 먼저가야되							
							dispose();
							setVisible(false);
							new RankPage().setVisible(true);
							//이제 여기서 txt로 점수를 저장해주면 된다.
							CalcRank.getRank();
						}//if(trial)-end
					}//오답일시 else-end
					String txt=String.valueOf(total);
					lbltotal.setText(txt);
				
					lblshow.setText(getQuestion(++cnt));//새로운 문제 띄우기
					
				}//else-end

				}catch (NumberFormatException e ){ //try-end
					showMessageDialog(lblshow,"숫자로만 입력해 주세요");
					e.printStackTrace();
				}	
			}//mouseClicked-end

		});//btnchek.MouseListener-end


		btncheck.setFont(new Font("경기천년제목V Bold", Font.BOLD, 22));
		btncheck.setBounds(455, 561, 184, 41);
		contentPane.add(btncheck);

		
		try {
		BufferedReader br =new BufferedReader(new FileReader("Nickname.txt"));
		nickname=(br.readLine()).trim();
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		lblnick = new JLabel(nickname+"님의 현재점수 :");
		lblnick.setFont(new Font("바탕체", Font.BOLD, 25));
		lblnick.setBounds(41, 31, 367, 84);
		contentPane.add(lblnick);
		
		lblwrong = new JLabel("");
		lblwrong.setForeground(Color.RED);
		lblwrong.setFont(new Font("바탕체", Font.BOLD, 29));
		lblwrong.setBounds(363, 367, 367, 65);
		contentPane.add(lblwrong);
		
		lbltotal = new JLabel("0");
		lbltotal.setFont(new Font("바탕체", Font.BOLD, 30));
		lbltotal.setBounds(377, 35, 184, 84);
		contentPane.add(lbltotal);
		



	}
}


