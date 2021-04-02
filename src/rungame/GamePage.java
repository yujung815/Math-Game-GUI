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
	public static int cnt=0; //�����ٲٴ� �뵵 
	public static int trial = 3; //3���� ��ȸ
	public static int opt;//��Ģ����
	private static int point=0;//������ ����
	private static int total=0;//�� ����
	public static int answer;//����
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
		case 1: int ran1 = (int)(Math.random()*10+1);	//-----------0~9���� ������
		ran=ran1;
		break;
		case 2: 
		case 3:
		case 4:
		case 5: int ran2 = (int)(Math.random()*89+10);//----------- 10~99���� ������
		ran=ran2;
		break;
		case 6:
		case 7:
		case 8:
		default:int ran3 =(int)(Math.random()*899+100);//------------ 100~999���� ������
		ran=ran3;
		break;
		
		}
		return ran;//random ������ ����
	}//getRandom-end
	
	public static int getPoint(int cnt){
		point=0;	
		switch(cnt){
		case 0:
		case 1: 	//-----------0~9���� ������
		point+=10;
		break;
		case 2: 
		case 3:
		case 4:
		case 5: //----------- 10~99���� ������
		point+=20;
		break;
		case 6:
		case 7:
		case 8:
		default:;//------------ 100~999���� ������
		point+=30;
		break;
		
		}
		return point;//random ������ ����
	}//getRandom-end



	public static int getOpt(int i) { //��Ģ���� ��ȯ���ִ� �޼���

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
	//Ŭ���Ҷ� cnt�� �þ�
	public static String getQuestion(int cnt) {

			
			 num1=getRandom(cnt);//cnt�� �Ű������� ->switch case �̿��ؼ� random ���ڸ� ������
			 num2=getRandom(cnt+1);//������ ���� ���� ������ ����Ҷ� �ٽ� ȣ���ϸ� ���ڰ� �� ���ϱ� ����.
			char opt =(char)getOpt(cnt);//��Ģ���� ��ȯ �ޱ�
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

		lblquestion = new JLabel("\uBB38\uC81C"+": "); //"���� :"����ϴ� �� 
		lblquestion.setFont(new Font("����ü", Font.BOLD, 60));
		lblquestion.setBounds(175, 173, 202, 184);
		contentPane.add(lblquestion);


		//btnenter.accActionListener


		txtanswer = new JTextField(); //���Է¹޴� textfield
		txtanswer.setFont(new Font("����ü", Font.BOLD, 40));
		txtanswer.setBounds(414, 442, 274, 99);
		contentPane.add(txtanswer);
		txtanswer.setColumns(10);

		lblshow = new JLabel(getQuestion(cnt));
		lblquestion.setLabelFor(lblshow);
		lblshow.setBackground(Color.WHITE);
		lblshow.setFont(new Font("����ü", Font.BOLD, 60));
		lblshow.setBounds(363, 173, 453, 184);
		contentPane.add(lblshow);


		btncheck.addMouseListener(new MouseAdapter() {//Ȯ�ι�ư ��������
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{String answer =(txtanswer.getText()).toString();//����޾ƿ���

				if(answer.isEmpty()) { //�ƹ��͵� ������ ����ó��
					showMessageDialog(lblshow,"������ �Է����ּ���!");		
							
				}else {//if-end
					answer =txtanswer.getText();//�����Է¹޾� String answer�� ����
					int answer1=Integer.parseInt(answer);
					if (answer1==getAnswer(num1,num2,cnt)) {//������ġȮ��
						lblwrong.setText("�����Դϴ�!");
						getPoint(cnt);
						total+=point;
					}else {//����Ȯ�� if-end
						lblwrong.setText("��! �����Դϴ�!");
						trial--;
						if (trial==0) {
							showMessageDialog(lblshow,"�� ������ "+total+"�� �Դϴ�.");
							try{
								PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Score.txt")));
								String str=String.valueOf(total);//����int�� string���� ��ȯ
								pw.append(str);
								pw.close();
								
							}catch (IOException e){
								e.printStackTrace();
							}
							//CalcRank �� �������ߵ�							
							dispose();
							setVisible(false);
							new RankPage().setVisible(true);
							//���� ���⼭ txt�� ������ �������ָ� �ȴ�.
							CalcRank.getRank();
						}//if(trial)-end
					}//�����Ͻ� else-end
					String txt=String.valueOf(total);
					lbltotal.setText(txt);
				
					lblshow.setText(getQuestion(++cnt));//���ο� ���� ����
					
				}//else-end

				}catch (NumberFormatException e ){ //try-end
					showMessageDialog(lblshow,"���ڷθ� �Է��� �ּ���");
					e.printStackTrace();
				}	
			}//mouseClicked-end

		});//btnchek.MouseListener-end


		btncheck.setFont(new Font("���õ������V Bold", Font.BOLD, 22));
		btncheck.setBounds(455, 561, 184, 41);
		contentPane.add(btncheck);

		
		try {
		BufferedReader br =new BufferedReader(new FileReader("Nickname.txt"));
		nickname=(br.readLine()).trim();
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("������ ã�� �� �����ϴ�.");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		lblnick = new JLabel(nickname+"���� �������� :");
		lblnick.setFont(new Font("����ü", Font.BOLD, 25));
		lblnick.setBounds(41, 31, 367, 84);
		contentPane.add(lblnick);
		
		lblwrong = new JLabel("");
		lblwrong.setForeground(Color.RED);
		lblwrong.setFont(new Font("����ü", Font.BOLD, 29));
		lblwrong.setBounds(363, 367, 367, 65);
		contentPane.add(lblwrong);
		
		lbltotal = new JLabel("0");
		lbltotal.setFont(new Font("����ü", Font.BOLD, 30));
		lbltotal.setBounds(377, 35, 184, 84);
		contentPane.add(lbltotal);
		



	}
}


