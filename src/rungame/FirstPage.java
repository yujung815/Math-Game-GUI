package rungame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class FirstPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private static JButton btnstart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException,NullPointerException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1200,800,1200,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitle = new JLabel("\uBE0C\uB808\uC778 \uBBF8\uB2C8 \uAC8C\uC784");
		lbltitle.setFont(new Font("경기천년제목V Bold", Font.BOLD, 27));
		lbltitle.setBounds(469, 36, 212, 73);
		contentPane.add(lbltitle);
		
		txtname = new JTextField();
		txtname.setText("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694");
		txtname.setBounds(494, 380, 177, 45);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblname = new JLabel("\uB2C9\uB124\uC784 :");
		lblname.setFont(new Font("굴림", Font.BOLD, 22));
		lblname.setBounds(386, 370, 96, 59);
		contentPane.add(lblname);
		
		JButton btnrank = new JButton("\uB7AD\uD0B9\uBCF4\uAE30");
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
		btnrank.setBounds(505, 459, 152, 59);
		contentPane.add(btnrank);
		
		btnstart = new JButton("\uAC8C\uC784\uC2DC\uC791");
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
		btnstart.setBounds(505, 554, 152, 59);
		contentPane.add(btnstart);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(FirstPage.class.getResource("/rungame/brain.png")));
		icon.setBounds(469, 83, 250, 278);
		contentPane.add(icon);
	}
}
