package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import DAO.ClassDAO;
import DAO.Class_SubjectDAO;
import DAO.Class_Subject_StudentDAO;
import DAO.StudentDAO;
import DAO.SubjectDAO;
import File.ParseFile;
import pojo.Class_Subject_Student;
import pojo.Student;
import pojo.Subject;

import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Class_Subject_Student_GUI {

	public static JFrame frame;
	private static JComboBox MSSV_cb;
	private static JTextField Cuoiky_text;
	private static JTextField Hoten_text;
	private static JLabel Giuaky_label;
	private static JTextField Giuaky_text;
	private static JTextField Diemkhac_text;
	private static JTextField Diemtong_text;
	private static JTable table;
	private static JScrollPane list;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_Subject_Student_GUI window = new Class_Subject_Student_GUI();
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
	public Class_Subject_Student_GUI() {
		initialize();
	}
	
	private static void refresh() {
		
		table.setModel(new Class_Subject_Student_Table(Class_Subject_StudentDAO.getList(), new String[] {
				"Mã sinh viên", "Mã môn học", "Lớp", "Điểm GK", "Điểm CK", "Điểm cộng", "Điểm TB", "Kết quả" }));
		list.setViewportView(table);
		
		int pass=0;
		int n = table.getRowCount();
		for (int i = 0; i < n; i++) {
			if((float)table.getValueAt(i, 6)>=5) {
				pass++;
			}
		}
		
		lblNewLabel_1.setText(String.valueOf(pass));
		lblNewLabel_2.setText(String.valueOf(pass*100/n));
		lblNewLabel_3.setText(String.valueOf(100-pass*100/n));
	}


	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		list = new JScrollPane();
		frame.getContentPane().add(list);

		table = new JTable();
		table.setModel(new Class_Subject_Student_Table(Class_Subject_StudentDAO.getList(), new String[] {
				"Mã sinh viên", "Mã môn học", "Lớp", "Điểm GK", "Điểm CK", "Điểm cộng", "Điểm TB", "Kết quả" }));
		springLayout.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, -310, SpringLayout.EAST, frame.getContentPane());
		list.setViewportView(table);

		// line 1
		JLabel MSSV_label = new JLabel("M\u00E3 s\u1ED1 sinh vi\u00EAn");
		springLayout.putConstraint(SpringLayout.NORTH, MSSV_label, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, MSSV_label, 10, SpringLayout.EAST, list);
		MSSV_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(MSSV_label);

		MSSV_cb = new JComboBox();
		List<Student> listStudents = StudentDAO.getList();
		List<String> l = (List<String>) listStudents.stream().map(o -> ((Student) o).getStudentID())
				.collect(Collectors.toList());
		MSSV_cb.setModel(new DefaultComboBoxModel(l.toArray()));
		springLayout.putConstraint(SpringLayout.NORTH, MSSV_cb, 10, SpringLayout.SOUTH, MSSV_label);
		springLayout.putConstraint(SpringLayout.WEST, MSSV_cb, 0, SpringLayout.WEST, MSSV_label);
		springLayout.putConstraint(SpringLayout.EAST, MSSV_cb, -190, SpringLayout.EAST, frame.getContentPane());
		MSSV_cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(MSSV_cb);

		JLabel Mamon_label = new JLabel("M\u00E3 m\u00F4n");
		springLayout.putConstraint(SpringLayout.NORTH, Mamon_label, 0, SpringLayout.NORTH, MSSV_label);
		springLayout.putConstraint(SpringLayout.WEST, Mamon_label, 10, SpringLayout.EAST, MSSV_cb);
		Mamon_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Mamon_label);

		JComboBox Ma_mon_cb = new JComboBox();
		List<Subject> subjects = SubjectDAO.getList();
		l = (List<String>) subjects.stream().map(o -> ((Subject) o).getiD()).collect(Collectors.toList());
		Ma_mon_cb.setModel(new DefaultComboBoxModel(l.toArray()));
		springLayout.putConstraint(SpringLayout.NORTH, Ma_mon_cb, 0, SpringLayout.NORTH, MSSV_cb);
		springLayout.putConstraint(SpringLayout.WEST, Ma_mon_cb, 10, SpringLayout.EAST, MSSV_cb);
		springLayout.putConstraint(SpringLayout.EAST, Ma_mon_cb, -90, SpringLayout.EAST, frame.getContentPane());
		Ma_mon_cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Ma_mon_cb);

		JLabel Malop_label = new JLabel("M\u00E3 l\u1EDBp");
		springLayout.putConstraint(SpringLayout.NORTH, Malop_label, 0, SpringLayout.NORTH, MSSV_label);
		springLayout.putConstraint(SpringLayout.WEST, Malop_label, 10, SpringLayout.EAST, Ma_mon_cb);
		Malop_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Malop_label);

		JComboBox Lop_cb = new JComboBox();
		List<pojo.Class> listClasses = ClassDAO.getList();
		l = (List<String>) listClasses.stream().map(o -> ((pojo.Class) o).getiD()).collect(Collectors.toList());
		Lop_cb.setModel(new DefaultComboBoxModel(l.toArray()));
		springLayout.putConstraint(SpringLayout.NORTH, Lop_cb, 0, SpringLayout.NORTH, MSSV_cb);
		springLayout.putConstraint(SpringLayout.WEST, Lop_cb, 10, SpringLayout.EAST, Ma_mon_cb);
		springLayout.putConstraint(SpringLayout.EAST, Lop_cb, -10, SpringLayout.EAST, frame.getContentPane());
		Lop_cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Lop_cb);

		// line2
		JLabel Hoten_label = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		springLayout.putConstraint(SpringLayout.NORTH, Hoten_label, 30, SpringLayout.SOUTH, MSSV_cb);
		springLayout.putConstraint(SpringLayout.WEST, Hoten_label, 10, SpringLayout.EAST, list);
		Hoten_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Hoten_label);

		Hoten_text = new JTextField();
		Hoten_text.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, Hoten_text, 10, SpringLayout.SOUTH, Hoten_label);
		springLayout.putConstraint(SpringLayout.WEST, Hoten_text, 0, SpringLayout.WEST, Hoten_label);
		springLayout.putConstraint(SpringLayout.EAST, Hoten_text, -10, SpringLayout.EAST, frame.getContentPane());
		Hoten_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Hoten_text);

		MSSV_cb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = StudentDAO.Find(new Student(MSSV_cb.getSelectedItem().toString(), "", "", "", "")).get(0)
						.getName();
				Hoten_text.setText(s);
			}
		});

		// line 3
		JPanel Diem_panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, Diem_panel, 30, SpringLayout.SOUTH, Hoten_text);
		springLayout.putConstraint(SpringLayout.WEST, Diem_panel, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, Diem_panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(Diem_panel);
		Diem_panel.setLayout(new GridLayout(0, 4, 0, 0));

		Giuaky_label = new JLabel("Gi\u1EEFa k\u1EF3");
		Diem_panel.add(Giuaky_label);
		springLayout.putConstraint(SpringLayout.NORTH, Giuaky_label, 30, SpringLayout.SOUTH, Hoten_text);
		springLayout.putConstraint(SpringLayout.WEST, Giuaky_label, 10, SpringLayout.EAST, list);
		Giuaky_label.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Cuoiky_label = new JLabel("Cu\u1ED1i k\u1EF3");
		Diem_panel.add(Cuoiky_label);
		springLayout.putConstraint(SpringLayout.WEST, Cuoiky_label, 105, SpringLayout.EAST, list);
		Cuoiky_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, Cuoiky_label, 7, SpringLayout.SOUTH, Diem_panel);

		JLabel Diemkhac_label = new JLabel("\u0110i\u1EC3m kh\u00E1c");
		Diem_panel.add(Diemkhac_label);
		springLayout.putConstraint(SpringLayout.EAST, Diemkhac_label, 0, SpringLayout.EAST, Ma_mon_cb);
		Diemkhac_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, Diemkhac_label, 7, SpringLayout.SOUTH, Diem_panel);

		JLabel Diemtong_label = new JLabel("\u0110i\u1EC3m t\u1ED5ng");
		Diem_panel.add(Diemtong_label);
		springLayout.putConstraint(SpringLayout.EAST, Diemtong_label, -7, SpringLayout.EAST, frame.getContentPane());
		Diemtong_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, Diemtong_label, 7, SpringLayout.SOUTH, Diem_panel);

		Giuaky_text = new JTextField();
		Diem_panel.add(Giuaky_text);
		springLayout.putConstraint(SpringLayout.NORTH, Giuaky_text, 34, SpringLayout.SOUTH, Diem_panel);
		springLayout.putConstraint(SpringLayout.WEST, Giuaky_text, 39, SpringLayout.EAST, list);
		Giuaky_text.setFont(new Font("Tahoma", Font.PLAIN, 14));

		Cuoiky_text = new JTextField();
		Diem_panel.add(Cuoiky_text);
		springLayout.putConstraint(SpringLayout.NORTH, Cuoiky_text, 30, SpringLayout.SOUTH, Diem_panel);
		// springLayout.putConstraint(SpringLayout.NORTH, CMND_text, 22,
		// SpringLayout.SOUTH, panel_2);
		springLayout.putConstraint(SpringLayout.EAST, Cuoiky_text, -87, SpringLayout.EAST, frame.getContentPane());
		Cuoiky_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// springLayout.putConstraint(SpringLayout.NORTH, Xoa_button, 25,
		// SpringLayout.SOUTH, CMND_text);

		Diemkhac_text = new JTextField();
		Diemkhac_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Diem_panel.add(Diemkhac_text);

		Diemtong_text = new JTextField();
		Diemtong_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Diem_panel.add(Diemtong_text);

		// line 4
		JPanel Sua_panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, Sua_panel, 30, SpringLayout.SOUTH, Diem_panel);
		springLayout.putConstraint(SpringLayout.WEST, Sua_panel, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, Sua_panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(Sua_panel);
		Sua_panel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton Them_Button = new JButton("Th\u00EAm");
		Them_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float gk;
				float ck;
				float khac;
				float tong;

				if (Giuaky_text.getText().toString().length() == 0) {
					gk = 0;
				} else {
					gk = Integer.parseInt(Giuaky_text.getText());
				}

				if (Cuoiky_text.getText().toString().length() == 0) {
					ck = 0;
				} else {
					ck = Integer.parseInt(Cuoiky_text.getText());
				}

				if (Diemkhac_text.getText().toString().length() == 0) {
					khac = 0;
				} else {
					khac = Integer.parseInt(Diemkhac_text.getText());
				}

				if (Diemtong_text.getText().toString().length() == 0) {
					tong = 0;
				} else {
					tong = Integer.parseInt(Diemtong_text.getText());
				}

				String lop = Lop_cb.getSelectedItem().toString();
				String mon = Ma_mon_cb.getSelectedItem().toString();

				if (Class_SubjectDAO.Find(lop, mon).size() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Lớp " + lop + " chưa đăng ký môn " + mon + " !!");
					return;
				}

				if (Class_Subject_StudentDAO
						.Find(new Class_Subject_Student(lop, mon, MSSV_cb.getSelectedItem().toString(), 0, 0, 0, 0))
						.size() > 0) {
					JOptionPane.showMessageDialog(new Frame(), "Đăng ký đã tồn tại!!");
					return;
				}

				Class_Subject_StudentDAO.Add(new Class_Subject_Student(Lop_cb.getSelectedItem().toString(),
						Ma_mon_cb.getSelectedItem().toString(), MSSV_cb.getSelectedItem().toString(), gk, ck, khac,
						tong));
				
				refresh();
			}
		});
		Sua_panel.add(Them_Button);
		springLayout.putConstraint(SpringLayout.WEST, Them_Button, 6, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.SOUTH, Them_Button, -293, SpringLayout.SOUTH, frame.getContentPane());

		JButton Xoa_button = new JButton("X\u00F3a");
		Xoa_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				String st = (String) table.getValueAt(row, 0);
				String mon = (String) table.getValueAt(row, 1);
				String lop = (String) table.getValueAt(row, 2);

				Class_Subject_StudentDAO.Delete(lop, mon, st);
				
				refresh();
			}
		});
		Sua_panel.add(Xoa_button);

		JButton Sua_button = new JButton("S\u1EEDa");
		Sua_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float gk;
				float ck;
				float khac;
				float tong;

				if (Giuaky_text.getText().toString().length() == 0) {
					gk = 0;
				} else {
					gk = Integer.parseInt(Giuaky_text.getText());
				}

				if (Cuoiky_text.getText().toString().length() == 0) {
					ck = 0;
				} else {
					ck = Integer.parseInt(Cuoiky_text.getText());
				}

				if (Diemkhac_text.getText().toString().length() == 0) {
					khac = 0;
				} else {
					khac = Integer.parseInt(Diemkhac_text.getText());
				}

				if (Diemtong_text.getText().toString().length() == 0) {
					tong = 0;
				} else {
					tong = Integer.parseInt(Diemtong_text.getText());
				}

				String lop = Lop_cb.getSelectedItem().toString();
				String mon = Ma_mon_cb.getSelectedItem().toString();

				if (Class_SubjectDAO.Find(lop, mon).size() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Lớp " + lop + " chưa đăng ký môn " + mon + " !!");
					return;
				}

				if (Class_Subject_StudentDAO
						.Find(new Class_Subject_Student(lop, mon, MSSV_cb.getSelectedItem().toString(), 0, 0, 0, 0))
						.size() == 0) {
					JOptionPane.showMessageDialog(new Frame(), "Đăng ký không tốn tại. Hãy kiểm tra lại thông tin!!");
					return;
				}

				Class_Subject_StudentDAO.Update(new Class_Subject_Student(Lop_cb.getSelectedItem().toString(),
						Ma_mon_cb.getSelectedItem().toString(), MSSV_cb.getSelectedItem().toString(), gk, ck, khac,
						tong));

				refresh();
			}
		});
		Sua_panel.add(Sua_button);
		springLayout.putConstraint(SpringLayout.WEST, Sua_button, 71, SpringLayout.EAST, list);

		// line 5
		JPanel Import_panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, Import_panel, 30, SpringLayout.SOUTH, Sua_panel);
		springLayout.putConstraint(SpringLayout.WEST, Import_panel, 10, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, Import_panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(Import_panel);
		Import_panel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton Import_text = new JButton("Thêm từ CSV");
		Import_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Class_Subject_Student> l = ParseFile.To_Class_Subject_Student_by_dangky("..\\data\\Dangky.csv");
				Iterator<Class_Subject_Student> it = l.iterator();
				while (it.hasNext()) {
					Class_Subject_Student x = it.next();

					if (StudentDAO.Find(new Student(x.getStudentID(), "", "", "", "")).size() == 0) {
						continue;
					}
					if (Class_SubjectDAO.Find(x.getClassID(), x.getSubjectID()).size() == 0) {
						continue;
					}
					if (Class_Subject_StudentDAO.Find(
							new Class_Subject_Student(x.getClassID(), x.getSubjectID(), x.getStudentID(), 0, 0, 0, 0))
							.size() > 0) {
						continue;
					}

					Class_Subject_StudentDAO.Add(x);
				}

				List<Class_Subject_Student> l2 = ParseFile.to_Class_Subject_Student_by_diem("..\\data\\Score.csv");
				it = l2.iterator();
				while (it.hasNext()) {
					Class_Subject_Student x = it.next();
					if (Class_Subject_StudentDAO.Find(
							new Class_Subject_Student(x.getClassID(), x.getSubjectID(), x.getStudentID(), 0, 0, 0, 0))
							.size() == 0) {
						continue;
					}
					Class_Subject_StudentDAO.Update(x);
				}

				refresh();
				
				JOptionPane.showMessageDialog(new Frame(), "Nhập Score.csv và Dangky.csv thành công!!");
			}
		});
		Import_panel.add(Import_text);

		JButton Export_text = new JButton("Xuất ra CSV");
		Export_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Class_Subject_Student> l = Class_Subject_StudentDAO.getList();
				ParseFile.Export_by_Class_Subject_Student_dangky("..\\data\\out_Dangky.csv", l);
				ParseFile.Export_by_Class_Subject_Student_diem("..\\data\\out_Score.csv", l);
				JOptionPane.showMessageDialog(new Frame(), "Xuất out_Score.csv và out_Dangky.csv thành công!!");

			}
		});
		Import_panel.add(Export_text);

		JButton home_bt = new JButton("back to Menu");
		home_bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Menu_GUI.initialize();
				frame = Menu_GUI.frame;
				frame.setVisible(true);
			}
		});
		Import_panel.add(home_bt);

		JLabel line0_lb = new JLabel("Thống kê :");
		springLayout.putConstraint(SpringLayout.NORTH, line0_lb, 20, SpringLayout.SOUTH, Import_panel);
		springLayout.putConstraint(SpringLayout.WEST, line0_lb, 10, SpringLayout.EAST, list);
		frame.getContentPane().add(line0_lb);

		JLabel line1_lb = new JLabel("\r\n\t- Số lượng sinh viên đậu là :");
		springLayout.putConstraint(SpringLayout.NORTH, line1_lb, 10, SpringLayout.SOUTH, line0_lb);
		springLayout.putConstraint(SpringLayout.WEST, line1_lb, 20, SpringLayout.EAST, list);
		line1_lb.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(line1_lb);

		JLabel line2_lb = new JLabel("\r\n\t- Tỉ lệ đậu là:\r\n");
		springLayout.putConstraint(SpringLayout.NORTH, line2_lb, 10, SpringLayout.SOUTH, line1_lb);
		springLayout.putConstraint(SpringLayout.WEST, line2_lb, 20, SpringLayout.EAST, list);
		line2_lb.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(line2_lb);

		JLabel line3_lb = new JLabel("- Tỉ lệ rớt là:");
		springLayout.putConstraint(SpringLayout.NORTH, line3_lb, 10, SpringLayout.SOUTH, line2_lb);
		springLayout.putConstraint(SpringLayout.WEST, line3_lb, 20, SpringLayout.EAST, list);
		line3_lb.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(line3_lb);

		lblNewLabel_1 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, line1_lb);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.EAST, line1_lb);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, line2_lb);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);

		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, line3_lb);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);

		frame.getContentPane().add(lblNewLabel_3);



		refresh();

	}
}
