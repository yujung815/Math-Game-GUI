package rungame;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;




class RankPage extends JFrame {
	public static String point;
	public static boolean result;
	public static int max=0, min=0;
	private static String[] strRank;
	private static JLabel lblshow1;
	private static JLabel lblshow2;
	private static JLabel lblshow3;
	private static JLabel lblshow4;
	private static JLabel lblshow5;
	private JPanel contentPane;
	private static String strCurrentLine;
	private static String s;

	public static String getStr(int i){
		try{

			BufferedReader br3 =new BufferedReader(new FileReader("Ranking.txt"));

			while((strCurrentLine=br3.readLine())!=null) {
				strRank[i++]=strCurrentLine;
			}
			br3.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		s=strRank[i];
		//줄별로 출력하는거만들기
		return s;
	}





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankPage frame = new RankPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RankPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1200,800,1200,800);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JLabel lblrktitle = new JLabel("랭킹");
		lblrktitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblrktitle.setFont(new Font("바탕체", Font.BOLD, 30));
		lblrktitle.setBounds(475, 29, 136, 89);
		contentPane.add(lblrktitle);


		JButton btnyes = new JButton("확인");//확인버튼
		btnyes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				dispose();
				setVisible(false);
				new FirstPage().setVisible(true);
			}
		});//mouseListener -end
		btnyes.setBounds(504, 642, 146, 42);
		contentPane.add(btnyes);


		lblshow1 = new JLabel(getStr(0)); //String 타입의 str을 전달
		lblshow1.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow1.setBounds(153, 128, 819, 59);
		contentPane.add(lblshow1);

		lblshow2 = new JLabel(getStr(1));
		lblshow2.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow2.setBounds(153, 217, 819, 59);
		contentPane.add(lblshow2);

		lblshow3 = new JLabel(getStr(2));
		lblshow3.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow3.setBounds(153, 311, 819, 59);
		contentPane.add(lblshow3);

		lblshow4 = new JLabel(getStr(3));
		lblshow4.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow4.setBounds(153, 406, 819, 59);
		contentPane.add(lblshow4);

		lblshow5 = new JLabel(getStr(4));
		lblshow5.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow5.setBounds(153, 491, 819, 59);
		contentPane.add(lblshow5);







	}
}