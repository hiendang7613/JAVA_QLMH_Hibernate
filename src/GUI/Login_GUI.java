package GUI;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;

import DAO.AccountDAO;
import pojo.Account;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login_GUI {

	private JFrame frame;
	private JTextField user_text;
	private JTextField pass_text;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_GUI window = new Login_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login_GUI() {	
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 660, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel avatar = new JLabel("");
		avatar.setIcon(new ImageIcon("..\\data\\logo-khtn.png"));
		springLayout.putConstraint(SpringLayout.NORTH, avatar, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, avatar, 200, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(avatar);

		JLabel user_label = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		springLayout.putConstraint(SpringLayout.NORTH, user_label, 10, SpringLayout.SOUTH, avatar);
		springLayout.putConstraint(SpringLayout.WEST, user_label, 10, SpringLayout.WEST, avatar);
		frame.getContentPane().add(user_label);

		user_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, user_text, 10, SpringLayout.SOUTH, user_label);
		springLayout.putConstraint(SpringLayout.WEST, user_text, 0, SpringLayout.WEST, user_label);
		springLayout.putConstraint(SpringLayout.EAST, user_text, -10, SpringLayout.EAST, avatar);
		frame.getContentPane().add(user_text);
		user_text.setColumns(10);

		JLabel pass_label = new JLabel("M\u1EADt kh\u1EA9u");
		springLayout.putConstraint(SpringLayout.NORTH, pass_label, 10, SpringLayout.SOUTH, user_text);
		springLayout.putConstraint(SpringLayout.WEST, pass_label, 0, SpringLayout.WEST, user_label);
		frame.getContentPane().add(pass_label);

		pass_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, pass_text, 10, SpringLayout.SOUTH, pass_label);
		springLayout.putConstraint(SpringLayout.WEST, pass_text, 0, SpringLayout.WEST, user_text);
		springLayout.putConstraint(SpringLayout.EAST, pass_text, -10, SpringLayout.EAST, avatar);
		frame.getContentPane().add(pass_text);
		pass_text.setColumns(10);

		JButton dangnhap_button = new JButton("\u0110\u0103ng nh\u1EADp");
		dangnhap_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (user_text.getText().length() == 0 || pass_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Hay nhap username va password !!");
					return;
				}

				List<Account> list = AccountDAO.Find(new Account(user_text.getText(), pass_text.getText(),false,""));

			
				if (list.size() != 1) {
					JOptionPane.showMessageDialog(new Frame(), "Sai tai khoan hoac mat khau!!");
				} else {
					frame.setVisible(false);
					Menu_GUI.isGiaovu = list.get(0).getIsGiaovu();
					BangDiem_GUI.studentID = list.get(0).getStudentID();
					JOptionPane.showMessageDialog(new Frame(), list.get(0).getStudentID());

					Menu_GUI.initialize();
					frame = Menu_GUI.frame;
					frame.setVisible(true);
				}

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, dangnhap_button, 15, SpringLayout.SOUTH, pass_text);
		springLayout.putConstraint(SpringLayout.WEST, dangnhap_button, -10, SpringLayout.WEST, avatar);
		springLayout.putConstraint(SpringLayout.EAST, dangnhap_button, 120, SpringLayout.WEST, avatar);
		frame.getContentPane().add(dangnhap_button);

		JButton dangky_button = new JButton("\u0110\u0103ng k\u00FD");
		dangky_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (user_text.getText().length() == 0 || pass_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Hay nhap username va password !!");
					return;
				}

				List<Account> list = AccountDAO.Find(new Account(user_text.getText(),"",false,"") );

				if (list.size() != 0) {
					JOptionPane.showMessageDialog(new Frame(), "Tai khoan da ton tai");
				} else {
					AccountDAO.Add(new Account(user_text.getText(), pass_text.getText(),false,""));
					JOptionPane.showMessageDialog(new Frame(), "Dang ky thanh cong!!");
				}

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, dangky_button, 0, SpringLayout.NORTH, dangnhap_button);
		springLayout.putConstraint(SpringLayout.WEST, dangky_button, 10, SpringLayout.EAST, dangnhap_button);
		springLayout.putConstraint(SpringLayout.EAST, dangky_button, 10, SpringLayout.EAST, avatar);
		frame.getContentPane().add(dangky_button);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("..\\data\\background.jpg"));
		frame.getContentPane().add(background);

	}
}
