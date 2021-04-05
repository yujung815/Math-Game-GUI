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
import rank.GetRank;
import rank.UpdateRank;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;


class RankPage extends JFrame {
	public  String point;
	public  boolean result;
	public  int max=0, min=0;
	private  JLabel lblshow1;
	private  JLabel lblshow2;
	private  JLabel lblshow3;
	private  JLabel lblshow4;
	private  JLabel lblshow5;
	private JPanel contentPane;

	private String[] arrscore;
	private String[] arrname;
	private JLabel lblbg;
	private JLabel lblRank;
	private JLabel label;
	private JLabel label_1;




	/**
	 * Launch the application.
	 */
	public  void main(String[] args) throws IOException{

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankPage frame = new RankPage();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
		setBounds(600,300,1200,800);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_1 = new JLabel("\uB2E4\uC2DC \uB3C4\uC804\uC744 \uC704\uD574\uC11C \"\uD655\uC778\" \uBC84\uD2BC\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694~!");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("경기천년제목V Bold", Font.BOLD, 24));
		label_1.setBounds(53, 609, 524, 42);
		contentPane.add(label_1);
		
		label = new JLabel("\uB7AD\uD0B9\uC5D0 \uC774\uB984\uC744 \uC62C\uB9AC\uACE0 \uC2F6\uB2E4\uBA74 \uBA38\uB9AC\uB97C \uC4F0\uC138\uC694!");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("경기천년제목V Bold", Font.BOLD, 24));
		label.setBounds(12, 205, 627, 42);
		contentPane.add(label);
		
		lblRank = new JLabel("\uB7AD\uD0B9\uC740 5\uB4F1\uAE4C\uC9C0\uB9CC \uAE30\uB85D\uB429\uB2C8\uB2E4.\r\n");
		lblRank.setVerticalAlignment(SwingConstants.TOP);
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		lblRank.setFont(new Font("경기천년제목V Bold", Font.BOLD, 24));
		lblRank.setBounds(65, 144, 469, 42);
		contentPane.add(lblRank);



		JLabel lblrktitle = new JLabel("Ranking");
		lblrktitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblrktitle.setFont(new Font("바탕체", Font.BOLD, 38));
		lblrktitle.setBounds(739, 106, 211, 89);
		contentPane.add(lblrktitle);


		JButton btnyes = new JButton("확인");//확인버튼
		btnyes.setForeground(new Color(0, 0, 128));
		btnyes.setBackground(SystemColor.text);
		btnyes.setFont(new Font("경기천년제목V Bold", Font.BOLD, 22));
		btnyes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				dispose();
				setVisible(false);
				new FirstPage().setVisible(true);
			}
		});//mouseListener -end
		btnyes.setBounds(744, 664, 146, 42);
		contentPane.add(btnyes);

		UpdateRank ur = new UpdateRank();
		GetRank gr =new GetRank();
		try {
			ur.sortRSave(gr.getRScore(), gr.getRName());
			arrscore=gr.getRScore();
			arrname=gr.getRName();
		}catch(IOException e) {
			e.printStackTrace();
		}


		lblshow1 = new JLabel("1등\t\t"+arrname[0]+":\t"+arrscore[0]+"점"); //String 타입의 str을 전달
		lblshow1.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow1.setBounds(645, 199, 429, 59);
		contentPane.add(lblshow1);

		lblshow2 = new JLabel("2등\t\t"+arrname[1]+":\t"+arrscore[1]+"점");
		lblshow2.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow2.setBounds(645, 288, 429, 59);
		contentPane.add(lblshow2);

		lblshow3 = new JLabel("3등\t\t"+arrname[2]+":\t"+arrscore[2]+"점");
		lblshow3.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow3.setBounds(645, 382, 429, 59);
		contentPane.add(lblshow3);

		lblshow4 = new JLabel("4등\t\t"+arrname[3]+":\t"+arrscore[3]+"점");
		lblshow4.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow4.setBounds(645, 477, 429, 59);
		contentPane.add(lblshow4);

		lblshow5 = new JLabel("5등\t\t"+arrname[4]+":\t"+arrscore[4]+"점");
		lblshow5.setFont(new Font("바탕", Font.BOLD, 30));
		lblshow5.setBounds(645, 562, 429, 59);
		contentPane.add(lblshow5);
		
		lblbg = new JLabel("");
		lblbg.setIcon(new ImageIcon(RankPage.class.getResource("/rungame/note.png")));
		lblbg.setBounds(0, 0, 1200, 800);
		contentPane.add(lblbg);



	}
}