package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.SpringLayout;


import DAO.ClassDAO;
import DAO.StudentDAO;
import File.ParseFile;
import pojo.Student;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;

public class Student_GUI {

	public static JFrame frame;
	private static JTextField MSSV_text;
	private static JTextField CMND_text;
	private static JTextField Hoten_text;
	private static JLabel Gioitinh_label;
	private static JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_GUI window = new Student_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student_GUI() {
		initialize();
	}

	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JScrollPane list = new JScrollPane();
		frame.getContentPane().add(list);

		table = new JTable();
		table.setModel(new Student_Table(StudentDAO.getList(), new String[] { "Mã số sinh viên", "Họ và tên", "Giới tính", "Số cmnd", "Mã lớp" }));
		springLayout.putConstraint(SpringLayout.NORTH, list, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -370, SpringLayout.EAST, frame.getContentPane());
		list.setViewportView(table);

		// line 1
		JLabel MSSV_label = new JLabel("M\u00E3 s\u1ED1 sinh vi\u00EAn");
		springLayout.putConstraint(SpringLayout.NORTH, MSSV_label, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, MSSV_label, 10, SpringLayout.EAST, list);
		MSSV_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(MSSV_label);

		MSSV_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, MSSV_text, 10, SpringLayout.SOUTH, MSSV_label);
		springLayout.putConstraint(SpringLayout.WEST, MSSV_text, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, MSSV_text, -110, SpringLayout.EAST, frame.getContentPane());
		MSSV_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(MSSV_text);

		JLabel Lop_label = new JLabel("L\u1EDBp");
		springLayout.putConstraint(SpringLayout.NORTH, Lop_label, 0, SpringLayout.NORTH, MSSV_label);
		springLayout.putConstraint(SpringLayout.WEST, Lop_label, 10, SpringLayout.EAST, MSSV_text);
		Lop_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Lop_label);

		JComboBox Lop_cb = new JComboBox();
		List<pojo.Class> listClasses = ClassDAO.getList();

		List<String> l = (List<String>) listClasses.stream().map(o -> ((pojo.Class) o).getiD())
				.collect(Collectors.toList());
		Lop_cb.setModel(new DefaultComboBoxModel(l.toArray()));
		springLayout.putConstraint(SpringLayout.NORTH, Lop_cb, 0, SpringLayout.NORTH, MSSV_text);
		springLayout.putConstraint(SpringLayout.WEST, Lop_cb, 10, SpringLayout.EAST, MSSV_text);
		springLayout.putConstraint(SpringLayout.EAST, Lop_cb, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(Lop_cb);

		// line2
		JLabel Hoten_label = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		springLayout.putConstraint(SpringLayout.NORTH, Hoten_label, 30, SpringLayout.SOUTH, MSSV_text);
		springLayout.putConstraint(SpringLayout.WEST, Hoten_label, 10, SpringLayout.EAST, list);
		Hoten_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Hoten_label);

		Hoten_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Hoten_text, 10, SpringLayout.SOUTH, Hoten_label);
		springLayout.putConstraint(SpringLayout.WEST, Hoten_text, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, Hoten_text, -10, SpringLayout.EAST, frame.getContentPane());
		Hoten_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Hoten_text);

		// line 3
		Gioitinh_label = new JLabel("Gi\u1EDBi T\u00EDnh");
		springLayout.putConstraint(SpringLayout.NORTH, Gioitinh_label, 30, SpringLayout.SOUTH, Hoten_text);
		springLayout.putConstraint(SpringLayout.WEST, Gioitinh_label, 10, SpringLayout.EAST, list);
		Gioitinh_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Gioitinh_label);

		JComboBox Gioitinh_cb = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, Gioitinh_cb, 10, SpringLayout.SOUTH, Gioitinh_label);
		springLayout.putConstraint(SpringLayout.WEST, Gioitinh_cb, 10, SpringLayout.EAST, list);
		Gioitinh_cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Gioitinh_cb.setModel(new DefaultComboBoxModel(new String[] { "\u2642 Nam", "\u2640 N\u1EEF" }));
		frame.getContentPane().add(Gioitinh_cb);

		JLabel CMND_label = new JLabel("S\u1ED1 Ch\u1EE9ng minh nh\u00E2n d\u00E2n");
		springLayout.putConstraint(SpringLayout.NORTH, CMND_label, 0, SpringLayout.NORTH, Gioitinh_label);
		springLayout.putConstraint(SpringLayout.WEST, CMND_label, 10, SpringLayout.EAST, Gioitinh_cb);
		CMND_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(CMND_label);

		CMND_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, CMND_text, 0, SpringLayout.NORTH, Gioitinh_cb);
		springLayout.putConstraint(SpringLayout.WEST, CMND_text, 10, SpringLayout.EAST, Gioitinh_cb);
		springLayout.putConstraint(SpringLayout.EAST, CMND_text, -10, SpringLayout.EAST, frame.getContentPane());
		CMND_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(CMND_text);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 30, SpringLayout.SOUTH, Gioitinh_cb);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton Them_Button = new JButton("Th\u00EAm");
		Them_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (MSSV_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Nhập mssv!!");
					return;
				}
				if (Hoten_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Nhập họ tên!!");
					return;
				}
				if (CMND_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Nhập cmnd!!");
					return;
				}

				if (MSSV_text.getText().length() != 7) {
					JOptionPane.showMessageDialog(new Frame(), "Mssv phải có 7 ký tự!!");
					return;
				}
				if (CMND_text.getText().length() != 9) {
					JOptionPane.showMessageDialog(new Frame(), "Cmnd phải có 9 ký tự!!");
					return;
				}

				if (StudentDAO.Find(new Student(MSSV_text.getText(), "", "", "", "")).size() > 0) {
					JOptionPane.showMessageDialog(new Frame(), "Sinh viên đã tồn tại!!");
					return;
				}

				StudentDAO.Add(
						new Student(MSSV_text.getText(), Hoten_text.getText(), Gioitinh_cb.getSelectedItem().toString().substring(2),
								CMND_text.getText(), Lop_cb.getSelectedItem().toString()));
				table.setModel(new Student_Table(StudentDAO.getList(), new String[] { "Mã số sinh viên", "Họ và tên", "Giới tính", "Số cmnd", "Mã lớp" }));
				list.setViewportView(table);
			}
		});
		panel.add(Them_Button);

		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new Frame(), "Chọn sinh viên!!");
					return;
				}
				int row = table.getSelectedRow();
				String mssv = (String) table.getValueAt(row, 0);
				StudentDAO.Delete(mssv);
				table.setModel(new Student_Table(StudentDAO.getList(), new String[] { "Mã số sinh viên", "Họ và tên", "Giới tính", "Số cmnd", "Mã lớp" }));
				list.setViewportView(table);
			}
		});
		
		panel.add(btnXa);

		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (MSSV_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Nhập mssv!!");
					return;
				}
				if (Hoten_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Nhập họ tên!!");
					return;
				}
				if (CMND_text.getText().length() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Nhập cmnd!!");
					return;
				}

				if (MSSV_text.getText().length() != 7) {
					JOptionPane.showMessageDialog(new Frame(), "Mssv phải có 7 ký tự!!");
					return;
				}
				if (CMND_text.getText().length() != 9) {
					JOptionPane.showMessageDialog(new Frame(), "Cmnd phải có 9 ký tự!!");
					return;
				}

				if (StudentDAO.Find(new Student(MSSV_text.getText(), "", "", "", "")).size() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Sinh viên không tồn tại!!");
					return;
				}

				StudentDAO.Update(
						new Student(MSSV_text.getText(), Hoten_text.getText(), Gioitinh_cb.getSelectedItem().toString().substring(2),
								CMND_text.getText(), Lop_cb.getSelectedItem().toString()));;
				table.setModel(new Student_Table(StudentDAO.getList(), new String[] { "Mã số sinh viên", "Họ và tên", "Giới tính", "Số cmnd", "Mã lớp" }));
				list.setViewportView(table);
			}
		});
		panel.add(btnSua);

		// line 5
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 30, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frame.getContentPane());
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		frame.getContentPane().add(panel_1);

		JButton inCSV_button = new JButton("Thêm từ CSV");
		inCSV_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> l = ParseFile.to_Student("..\\data\\Student.csv");
				
				Iterator<Student> it = l.iterator();
				
				while (it.hasNext()) {
					Student student = it.next();
						if (StudentDAO.Find(student).size() > 0) {
						continue;
					}
					StudentDAO.Add(student);
				}
				table.setModel(new Student_Table(StudentDAO.getList(), new String[] { "Mã số sinh viên", "Họ và tên", "Giới tính", "Số cmnd", "Mã lớp" }));
				list.setViewportView(table);
				JOptionPane.showMessageDialog(new Frame(), "Nhập Subject.csv thành công!!");
			}
		});
		panel_1.add(inCSV_button);

		JButton outCSV_button = new JButton("Xuất ra CSV");
		outCSV_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> l = StudentDAO.getList();
				ParseFile.Export_by_Student("..\\data\\out_Student.csv",l);
				JOptionPane.showMessageDialog(new Frame(), "Xuất out_Subject.csv thành công!!");
			}
		});
		panel_1.add(outCSV_button);
		
		JButton home_bt = new JButton("back to Menu");
		home_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Menu_GUI.initialize();
				frame = Menu_GUI.frame;
				frame.setVisible(true);
			}
		});
		panel_1.add(home_bt);

	}
}
