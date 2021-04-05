package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BGTest2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BGTest2 frame = new BGTest2();
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
	public BGTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 805);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1200, 800);
		contentPane.add(layeredPane);
		
		JLabel label = new JLabel("\uBE0C\uB808\uC778 \uBBF8\uB2C8 \uAC8C\uC784");
		label.setBounds(142, 183, 212, 73);
		layeredPane.add(label);
		label.setFont(new Font("∞Ê±‚√µ≥‚¡¶∏ÒV Bold", Font.BOLD, 27));
		
		textField = new JTextField();
		textField.setBounds(67, 26, 177, 45);
		layeredPane.add(textField);
		textField.setText("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\uB2C9\uB124\uC784 :");
		label_1.setBounds(633, 369, 96, 59);
		layeredPane.add(label_1);
		label_1.setFont(new Font("±º∏≤", Font.BOLD, 22));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1280);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-53, -10, 1920, 1280);
		panel.add(lblNewLabel);
		layeredPane.setLayer(lblNewLabel, 1);
		lblNewLabel.setIcon(new ImageIcon(BGTest2.class.getResource("/test/typewriter.jpg")));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(125, 417, 250, 278);
		panel.add(label_2);
		
		JButton button = new JButton("\uB7AD\uD0B9\uBCF4\uAE30");
		button.setBounds(43, 306, 152, 59);
		panel.add(button);
		button.setFont(new Font("»ﬁ∏’øæ√º", Font.PLAIN, 17));
		
		JButton button_1 = new JButton("\uAC8C\uC784\uC2DC\uC791");
		button_1.setBounds(0, 0, 152, 59);
		layeredPane.add(button_1);
		button_1.setFont(new Font("»ﬁ∏’øæ√º", Font.PLAIN, 17));
		
		
	}
}
