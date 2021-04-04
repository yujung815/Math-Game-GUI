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





	/**
	 * Launch the application.
	 */
	public  void main(String[] args) throws IOException{

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



		JLabel lblrktitle = new JLabel("∑©≈∑");
		lblrktitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblrktitle.setFont(new Font("πŸ≈¡√º", Font.BOLD, 30));
		lblrktitle.setBounds(475, 29, 136, 89);
		contentPane.add(lblrktitle);


		JButton btnyes = new JButton("»Æ¿Œ");//»Æ¿Œπˆ∆∞
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

		UpdateRank ur = new UpdateRank();
		GetRank gr =new GetRank();
		try {
			ur.sortRSave(gr.getRScore(), gr.getRName());
			arrscore=gr.getRScore();
			arrname=gr.getRName();
		}catch(IOException e) {
			e.printStackTrace();
		}


		lblshow1 = new JLabel(arrname[0]+":\t"+arrscore[0]+"¡°"); //String ≈∏¿‘¿« str¿ª ¿¸¥ﬁ
		lblshow1.setFont(new Font("πŸ≈¡", Font.BOLD, 30));
		lblshow1.setBounds(153, 128, 819, 59);
		contentPane.add(lblshow1);

		lblshow2 = new JLabel(arrname[1]+":\t"+arrscore[1]+"¡°");
		lblshow2.setFont(new Font("πŸ≈¡", Font.BOLD, 30));
		lblshow2.setBounds(153, 217, 819, 59);
		contentPane.add(lblshow2);

		lblshow3 = new JLabel(arrname[2]+":\t"+arrscore[2]+"¡°");
		lblshow3.setFont(new Font("πŸ≈¡", Font.BOLD, 30));
		lblshow3.setBounds(153, 311, 819, 59);
		contentPane.add(lblshow3);

		lblshow4 = new JLabel(arrname[3]+":\t"+arrscore[3]+"¡°");
		lblshow4.setFont(new Font("πŸ≈¡", Font.BOLD, 30));
		lblshow4.setBounds(153, 406, 819, 59);
		contentPane.add(lblshow4);

		lblshow5 = new JLabel(arrname[4]+":\t"+arrscore[4]+"¡°");
		lblshow5.setFont(new Font("πŸ≈¡", Font.BOLD, 30));
		lblshow5.setBounds(153, 491, 819, 59);
		contentPane.add(lblshow5);







	}
}