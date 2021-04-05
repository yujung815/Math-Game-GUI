package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.JLayeredPane;

public class FirstTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private static JButton btnstart;
	
	
	private void BackgroundImageJFrame() {
		// TODO Auto-generated method stub
		setTitle("Background Color for JFrame");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException,NullPointerException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstTest frame = new FirstTest();
					frame.setLocationRelativeTo(null);
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
	public FirstTest() {
		
		getContentPane().setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("rungame\\test\\typewriter.jpg"));
		getContentPane().add(background);
		background.setLayout(new FlowLayout());
		background.add(contentPane);
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1200,800,1200,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1200, 1200);
		contentPane.add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(-46, -51, 1981, 1462);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel icon = new JLabel("");
		icon.setBounds(407, 74, 250, 278);
		panel.add(icon);
		icon.setIcon(new ImageIcon(FirstTest.class.getResource("/rungame/brain.png")));
		
		JLabel lbltitle = new JLabel("\uBE0C\uB808\uC778 \uBBF8\uB2C8 \uAC8C\uC784");
		lbltitle.setBounds(445, 573, 212, 73);
		panel.add(lbltitle);
		lbltitle.setFont(new Font("경기천년제목V Bold", Font.BOLD, 27));
		
		JButton btnrank = new JButton("\uB7AD\uD0B9\uBCF4\uAE30");
		btnrank.setBounds(451, 504, 152, 59);
		panel.add(btnrank);
		btnrank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnrank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				dispose();
				setVisible(false);
				new RankPage().setVisible(true);
							
				
			}
		});
		btnrank.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
		
		txtname = new JTextField();
		txtname.setBounds(451, 407, 177, 45);
		panel.add(txtname);
		txtname.setText("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694");
		txtname.setColumns(10);
		
		JLabel lblname = new JLabel("\uB2C9\uB124\uC784 :");
		lblname.setBounds(268, 470, 96, 59);
		panel.add(lblname);
		lblname.setFont(new Font("굴림", Font.BOLD, 22));
		
		btnstart = new JButton("\uAC8C\uC784\uC2DC\uC791");
		btnstart.setBounds(260, 412, 152, 59);
		panel.add(btnstart);
		btnstart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=(txtname.getText()).toString();
				if(name.isEmpty() || name.equals("이름을 입력하세요")) {
					showMessageDialog(btnstart,"닉네임을 입력해주세요!!");
				}else {
					try {
					PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Nickname.txt")));
					pw.append(name);
					pw.close();
					}catch (IOException ex) {
						ex.printStackTrace();
					}
					dispose();
					setVisible(false);
					new GamePage().setVisible(true);
					
				}
			}
		});
		btnstart.setFont(new Font("휴먼옛체", Font.PLAIN, 17));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(48, 31, 1200, 800);
		panel.add(lblBackground);
		lblBackground.setIcon(new ImageIcon(FirstTest.class.getResource("/test/typewriter.jpg")));
	}
}
