package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_GUI {

	public static boolean isGiaovu = false;

	public static JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_GUI window = new Menu_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu_GUI() {
		initialize();
	}

	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 150, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 20, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -20, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -20, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);

		GridLayout myGridLayout = new GridLayout(0, 3, 0, 0);
		myGridLayout.setHgap(10);
		panel.setLayout(myGridLayout);

		JButton DKHPvaDiem_button = new JButton("H\u1ECDc ph\u1EA7n v\u00E0 \u0111i\u1EC3m");
		DKHPvaDiem_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		DKHPvaDiem_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isGiaovu) {
					frame.setVisible(false);
					Class_Subject_Student_GUI.initialize();
					frame = Class_Subject_Student_GUI.frame;
					frame.setVisible(true);
				} else {
					frame.setVisible(false);
					BangDiem_GUI.initialize();
					frame = BangDiem_GUI.frame;
					frame.setVisible(true);
				}
			}
		});
		panel.add(DKHPvaDiem_button);

		JButton LopvaMon_button = new JButton("L\u1EDBp v\u00E0 m\u00F4n");
		LopvaMon_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		LopvaMon_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Class_Subject_GUI.initialize();
				frame = Class_Subject_GUI.frame;
				frame.setVisible(true);
			}
		});
		panel.add(LopvaMon_button);

		JButton Sinhvien_button = new JButton("Sinh vi\u00EAn");
		Sinhvien_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		Sinhvien_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Student_GUI.initialize();
					frame = Student_GUI.frame;
					frame.setVisible(true);
			}
		});
		panel.add(Sinhvien_button);

		JLabel lblNewLabel = new JLabel("MENU");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 30, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frame.getContentPane());

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		frame.getContentPane().add(lblNewLabel);

		if (!isGiaovu) {
			LopvaMon_button.setEnabled(false);
			Sinhvien_button.setEnabled(false);
		}

	}
}
