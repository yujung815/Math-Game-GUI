package rungame;

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
import java.awt.Color;

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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300,1200,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("\uB2C9\uB124\uC784 :");
		lblname.setBounds(394, 360, 95, 79);
		contentPane.add(lblname);
		lblname.setForeground(new Color(0, 128, 128));
		lblname.setBackground(new Color(255, 255, 255));
		lblname.setFont(new Font("경기천년제목V Bold", Font.BOLD, 25));
		
		JLabel lbltitle = new JLabel("\uBE0C\uB808\uC778 \uBBF8\uB2C8 \uAC8C\uC784");
		lbltitle.setForeground(new Color(0, 128, 128));
		lbltitle.setBackground(new Color(0, 128, 128));
		lbltitle.setFont(new Font("경기천년제목V Bold", Font.BOLD, 40));
		lbltitle.setBounds(424, 40, 331, 73);
		contentPane.add(lbltitle);
		
		txtname = new JTextField();
		txtname.setText("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694");
		txtname.setBounds(494, 380, 177, 45);
		txtname.setForeground(new Color(192, 192, 192));
		txtname.setFont(new Font("경기천년제목V Bold", Font.BOLD, 12));
		txtname.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtname.setText("");
				txtname.setForeground(new Color(0,0,0));
				txtname.setFont(new Font("경기천년제목V Bold", Font.BOLD, 14));
				
			}
		});
	
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnrank = new JButton("\uB7AD\uD0B9\uBCF4\uAE30");
		btnrank.setForeground(new Color(0, 139, 139));
		btnrank.setBackground(new Color(255, 255, 240));
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
		btnrank.setFont(new Font("경기천년제목 Bold", Font.BOLD, 20));
		btnrank.setBounds(505, 521, 152, 59);
		contentPane.add(btnrank);
		
		btnstart = new JButton("\uAC8C\uC784\uC2DC\uC791");
		btnstart.setBackground(new Color(255, 255, 240));
		btnstart.setForeground(new Color(0, 139, 139));
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
		btnstart.setFont(new Font("경기천년제목V Bold", Font.BOLD, 20));
		btnstart.setBounds(505, 615, 152, 59);
		contentPane.add(btnstart);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(FirstPage.class.getResource("/rungame/math.png")));
		icon.setBounds(454, 122, 240, 252);
		contentPane.add(icon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FirstPage.class.getResource("/rungame/openbook.png")));
		lblNewLabel.setBounds(0, 0, 1200, 800);
		contentPane.add(lblNewLabel);
	}
}
