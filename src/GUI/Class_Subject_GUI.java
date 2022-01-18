package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


import DAO.ClassDAO;
import DAO.Class_SubjectDAO;
import DAO.SubjectDAO;
import File.ParseFile;
import pojo.Class_Subject;
import pojo.Subject;
import javax.swing.border.LineBorder;


import java.awt.Color;
import javax.swing.JRadioButton;

public class Class_Subject_GUI {

	public static JFrame frame;
	private static JTextField Mamon_text;
	private static JTextField Tenmon_text;
	private static JTextField Malop_text;
	private static JTextField Phonghoc_text;
	private static JTable mon_Table;
	private static JScrollPane mon_ScrollPane;
	private static JTable mon_lop_table;
	private static JScrollPane mon_lop_ScrollPane;
	private static JList lop_List;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_Subject_GUI window = new Class_Subject_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Class_Subject_GUI() {
		initialize();
	}

	public static void refresh(int col) {

		switch (col) {
		case 0: {
			mon_Table.setModel(new Subject_Table(SubjectDAO.getList(), new String[] { "Mã môn", "Tên môn" }));
			mon_Table.getColumnModel().getColumn(0).setMaxWidth(50);
			mon_ScrollPane.setViewportView(mon_Table);
			return;
		}
		case 1: {
			List<pojo.Class> Class_list = ClassDAO.getList();
			List<String> l = new ArrayList<String>();
			for (int i = 0; i < Class_list.size(); i++) {
				l.add(Class_list.get(i).getiD());
			}
			
			lop_List.setModel(
					new DefaultListModel() {
				String[] values = l.toArray(new String[0]);

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			return;
		}
		case 2: {
			mon_lop_table.setModel(
					new Class_Subject_Table(Class_SubjectDAO.getList(), new String[] { "Mã môn học", "Lớp", "Phòng" }));
			mon_lop_ScrollPane.setViewportView(mon_lop_table);
			return;
		}
		default:
		}

	}

	public static void initialize() {
		frame = new JFrame("Thoi Khoa Bieu");
		frame.setBounds(100, 100, 1000, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		// col 1
		JScrollPane mon_ScrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, mon_ScrollPane, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mon_ScrollPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, mon_ScrollPane, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mon_ScrollPane, 210, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(mon_ScrollPane);

		mon_Table = new JTable();
		mon_Table.setModel(new Subject_Table(SubjectDAO.getList(), new String[] { "Mã môn", "Tên môn" }));
		mon_Table.getColumnModel().getColumn(0).setMaxWidth(50);
		mon_ScrollPane.setViewportView(mon_Table);

		// col2

		lop_List = new JList();
		lop_List.setBorder(new LineBorder(new Color(0, 0, 0)));
		List<pojo.Class> Class_list = ClassDAO.getList();
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < Class_list.size(); i++) {
			l.add(Class_list.get(i).getiD());
		}
		lop_List.setModel(new AbstractListModel() {
			String[] values = l.toArray(new String[0]);

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, lop_List, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lop_List, 10, SpringLayout.EAST, mon_ScrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, lop_List, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lop_List, 110, SpringLayout.EAST, mon_ScrollPane);
		frame.getContentPane().add(lop_List);

		// col3
		mon_lop_ScrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, mon_lop_ScrollPane, 10, SpringLayout.NORTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mon_lop_ScrollPane, 10, SpringLayout.EAST, lop_List);
		springLayout.putConstraint(SpringLayout.SOUTH, mon_lop_ScrollPane, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mon_lop_ScrollPane, -310, SpringLayout.EAST,
				frame.getContentPane());
		frame.getContentPane().add(mon_lop_ScrollPane);

		mon_lop_table = new JTable();
		mon_lop_table.setModel(
				new Class_Subject_Table(Class_SubjectDAO.getList(), new String[] { "Mã môn học", "Lớp", "Phòng" }));
		mon_lop_ScrollPane.setViewportView(mon_lop_table);

		// Radio panel
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 24, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.EAST, mon_lop_ScrollPane);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel Radio_label = new JLabel("Quản lí");
		panel_2.add(Radio_label);

		JRadioButton DSmon_rb = new JRadioButton("Danh sách môn");
		panel_2.add(DSmon_rb);

		JRadioButton DSlop_rb = new JRadioButton("Danh sách lớp");
		panel_2.add(DSlop_rb);

		JRadioButton DSdangky_rb = new JRadioButton("Danh sách đăng ký lớp - môn - phòng");
		panel_2.add(DSdangky_rb);

		ButtonGroup group = new ButtonGroup();
		group.add(DSmon_rb);
		group.add(DSlop_rb);
		group.add(DSdangky_rb);

		// line 1
		JLabel Mamon_label = new JLabel("M\u00E3 m\u00F4n");
		springLayout.putConstraint(SpringLayout.NORTH, Mamon_label, 10, SpringLayout.SOUTH, panel_2);
		springLayout.putConstraint(SpringLayout.WEST, Mamon_label, 10, SpringLayout.EAST, mon_lop_ScrollPane);
		Mamon_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Mamon_label);

		Mamon_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Mamon_text, 10, SpringLayout.SOUTH, Mamon_label);
		springLayout.putConstraint(SpringLayout.WEST, Mamon_text, 0, SpringLayout.WEST, Mamon_label);
		springLayout.putConstraint(SpringLayout.EAST, Mamon_text, -200, SpringLayout.EAST, frame.getContentPane());
		Mamon_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Mamon_text);

		JLabel Tenmon_label = new JLabel("T\u00EAn m\u00F4n");
		springLayout.putConstraint(SpringLayout.NORTH, Tenmon_label, 0, SpringLayout.NORTH, Mamon_label);
		springLayout.putConstraint(SpringLayout.WEST, Tenmon_label, 10, SpringLayout.EAST, Mamon_text);
		Tenmon_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Tenmon_label);

		Tenmon_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Tenmon_text, 0, SpringLayout.NORTH, Mamon_text);
		springLayout.putConstraint(SpringLayout.WEST, Tenmon_text, 10, SpringLayout.EAST, Mamon_text);
		springLayout.putConstraint(SpringLayout.EAST, Tenmon_text, -10, SpringLayout.EAST, frame.getContentPane());
		Tenmon_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Tenmon_text);

		// line 2
		JLabel Malop_label = new JLabel("M\u00E3 l\u1EDBp");
		springLayout.putConstraint(SpringLayout.NORTH, Malop_label, 30, SpringLayout.SOUTH, Mamon_text);
		springLayout.putConstraint(SpringLayout.WEST, Malop_label, 0, SpringLayout.WEST, Mamon_label);
		Malop_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Malop_label);

		Malop_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Malop_text, 10, SpringLayout.SOUTH, Malop_label);
		springLayout.putConstraint(SpringLayout.WEST, Malop_text, 0, SpringLayout.WEST, Mamon_label);
		springLayout.putConstraint(SpringLayout.EAST, Malop_text, -200, SpringLayout.EAST, frame.getContentPane());
		Malop_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Malop_text);

		JLabel Phonghoc_label_1 = new JLabel("Ph\u00F2ng h\u1ECDc");
		springLayout.putConstraint(SpringLayout.NORTH, Phonghoc_label_1, 0, SpringLayout.NORTH, Malop_label);
		springLayout.putConstraint(SpringLayout.WEST, Phonghoc_label_1, 10, SpringLayout.EAST, Malop_text);
		Phonghoc_label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Phonghoc_label_1);

		Phonghoc_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Phonghoc_text, 0, SpringLayout.NORTH, Malop_text);
		springLayout.putConstraint(SpringLayout.WEST, Phonghoc_text, 10, SpringLayout.EAST, Malop_text);
		springLayout.putConstraint(SpringLayout.EAST, Phonghoc_text, -10, SpringLayout.EAST, frame.getContentPane());
		Phonghoc_text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Phonghoc_text);

		// line 3
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 30, SpringLayout.SOUTH, Malop_text);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.EAST, mon_lop_ScrollPane);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		DSmon_rb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Mamon_text.setEditable(true);
				Tenmon_text.setEditable(true);
				Malop_text.setEditable(false);
				Phonghoc_text.setEditable(false);
				
				mon_Table.setEnabled(true);
				mon_Table.setBackground(Color.white);
				
				lop_List.clearSelection();
				mon_lop_table.clearSelection();
				lop_List.setEnabled(false);
				mon_lop_table.setEnabled(false);
				lop_List.setBackground(Color.LIGHT_GRAY);
				mon_lop_table.setBackground(Color.LIGHT_GRAY);

			}
		});
		DSlop_rb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Malop_text.setEditable(true);
				Mamon_text.setEditable(false);
				Tenmon_text.setEditable(false);
				Phonghoc_text.setEditable(false);
				
				lop_List.setEnabled(true);
				lop_List.setBackground(Color.white);
				
				mon_Table.clearSelection();
				mon_lop_table.clearSelection();
				mon_Table.setEnabled(false);
				mon_lop_table.setEnabled(false);
				mon_Table.setBackground(Color.LIGHT_GRAY);
				mon_lop_table.setBackground(Color.LIGHT_GRAY);
			}
		});
		DSdangky_rb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Phonghoc_text.setEditable(true);
				Mamon_text.setEditable(false);
				Malop_text.setEditable(false);
				Tenmon_text.setEditable(false);

				lop_List.setEnabled(true);
				lop_List.setBackground(Color.white);
				mon_Table.setEnabled(true);
				mon_Table.setBackground(Color.white);
				mon_lop_table.setEnabled(true);
				mon_lop_table.setBackground(Color.white);

			}
		});

		JButton Them_Button = new JButton("Th\u00EAm");
		Them_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (DSmon_rb.isSelected()) {
					if (Mamon_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập mã môn!!");
						return;
					}
					if (Mamon_text.getText().length() != 6) {
						JOptionPane.showMessageDialog(new Frame(), "Mã môn phải có 6 ký tự!!");
						return;
					}
					if (SubjectDAO.Find(new Subject(Mamon_text.getText(), "")).size() > 0) {
						JOptionPane.showMessageDialog(new Frame(), "Mã môn đã tồn tại!!");
						return;
					}
					if (Tenmon_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập tên môn!!");
						return;
					}
					SubjectDAO.Add(new Subject(Mamon_text.getText(), Tenmon_text.getText()));

					refresh(0);
					return;
				}

				if (DSlop_rb.isSelected()) {
					if (Malop_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập mã lớp!!");
						return;
					}
					if (Malop_text.getText().length() != 5) {
						JOptionPane.showMessageDialog(new Frame(), "Mã lớp phải có 5 ký tự!!");
						return;
					}
					if (ClassDAO.Find(Malop_text.getText()).size() > 0) {
						JOptionPane.showMessageDialog(new Frame(), "Mã lớp đã tồn tại!!");
						return;
					}
					ClassDAO.Add(Malop_text.getText());
					refresh(1);
					return;
				}

				if (DSdangky_rb.isSelected()) {

					if (lop_List.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(new Frame(), "Chọn lớp!!");
						return;
					}

					if (mon_Table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(new Frame(), "Chọn môn!!");
						return;
					}

					String malopString = (String) lop_List.getSelectedValue();
					int row = mon_Table.getSelectedRow();
					String mamonString = (String) mon_Table.getValueAt(row, 0);

					if (Phonghoc_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập mã phòng học!!");
						return;
					}

					if (Phonghoc_text.getText().length() != 3) {
						JOptionPane.showMessageDialog(new Frame(), "Mã phòng học phải 3 ký tự!!");
						return;
					}

					if (Class_SubjectDAO.Find(malopString, mamonString).size() > 0) {
						JOptionPane.showMessageDialog(new Frame(),
								"Không thể thêm : Lớp" + malopString + " đã đăng ký môn " + mamonString + " !!");
						return;
					}
					Class_SubjectDAO.Add(new Class_Subject(malopString, mamonString, Phonghoc_text.getText()));
					refresh(2);
					return;

				}
			}
		});
		panel.add(Them_Button);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (DSmon_rb.isSelected()) {
					if (mon_Table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(new Frame(), "Chọn môn!!");
						return;
					}
					int row = mon_Table.getSelectedRow();
					String mamonString = (String) mon_Table.getValueAt(row, 0);
					SubjectDAO.Delete(mamonString);
					refresh(0);
					return;
				}

				if (DSlop_rb.isSelected()) {

					if (lop_List.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(new Frame(), "Chọn lớp!!");
						return;
					}

					ClassDAO.Delete((String) lop_List.getSelectedValue());
					
					refresh(1);
					return;
				}

				if (DSdangky_rb.isSelected()) {

					int row = mon_lop_table.getSelectedRow();
					String malopString = (String) mon_lop_table.getValueAt(row, 0);
					String mamonString = (String) mon_lop_table.getValueAt(row, 1);


					Class_SubjectDAO.Delete(malopString, mamonString);
					refresh(2);
					return;

				}

			}
		});
		panel.add(btnXoa);

		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DSmon_rb.isSelected()) {
					if (Mamon_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập mã môn!!");
						return;
					}
					if (Mamon_text.getText().length() != 6) {
						JOptionPane.showMessageDialog(new Frame(), "Mã môn phải có 6 ký tự!!");
						return;
					}
					if (SubjectDAO.Find(new Subject(Mamon_text.getText(), "")).size() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Mã môn không tồn tại!!");
						return;
					}
					if (Tenmon_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập tên môn!!");
						return;
					}
					SubjectDAO.Update(new Subject(Mamon_text.getText(), Tenmon_text.getText()));

					refresh(0);
					return;
				}

				if (DSlop_rb.isSelected()) {
					if (Malop_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập mã lớp!!");
						return;
					}
					if (Malop_text.getText().length() != 5) {
						JOptionPane.showMessageDialog(new Frame(), "Mã lớp phải có 5 ký tự!!");
						return;
					}
					if (ClassDAO.Find(Malop_text.getText()).size() > 0) {
						JOptionPane.showMessageDialog(new Frame(), "Mã lớp đã tồn tại!!");
						return;
					}
					ClassDAO.Add(Malop_text.getText());
					refresh(1);
					return;
				}

				if (DSdangky_rb.isSelected()) {

					if (lop_List.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(new Frame(), "Chọn lớp!!");
						return;
					}

					if (mon_Table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(new Frame(), "Chọn môn!!");
						return;
					}

					String malopString = (String) lop_List.getSelectedValue();
					int row = mon_Table.getSelectedRow();
					String mamonString = (String) mon_Table.getValueAt(row, 0);

					if (Phonghoc_text.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Nhập mã phòng học!!");
						return;
					}

					if (Phonghoc_text.getText().length() != 3) {
						JOptionPane.showMessageDialog(new Frame(), "Mã phòng học phải 3 ký tự!!");
						return;
					}

					if (Class_SubjectDAO.Find(malopString, mamonString).size() == 0) {
						JOptionPane.showMessageDialog(new Frame(),
								"Không tồn tại : Lớp" + malopString + " đã đăng ký môn " + mamonString + " !!");
						return;
					}
					Class_SubjectDAO.Update(new Class_Subject(malopString, mamonString, Phonghoc_text.getText()));
					refresh(2);
					return;

				}
			}
		});
		
		panel.add(btnSua);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 30, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.EAST, mon_lop_ScrollPane);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 55, SpringLayout.SOUTH, panel);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));

		
		JButton inCSV_button = new JButton("Thêm từ CSV");
		inCSV_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Class_Subject> l = ParseFile.to_Class_Subject("..\\data\\Class_Subject.csv");
				
				Iterator<Class_Subject> it = l.iterator();
				
				while (it.hasNext()) {
					Class_Subject x = it.next();
						if (Class_SubjectDAO.Find(x.getClassID(),x.getSubjectID()).size() > 0) {
						continue;
					}
					Class_SubjectDAO.Add(x);
				}
				mon_lop_table.setModel(
						new Class_Subject_Table(Class_SubjectDAO.getList(), new String[] { "Mã môn học", "Lớp", "Phòng" }));
				mon_lop_ScrollPane.setViewportView(mon_lop_table);
				JOptionPane.showMessageDialog(new Frame(), "Nhập Class_Subject.csv thành công!!");

			}
		});
		panel_1.add(inCSV_button);
		
		JButton outCSV_button = new JButton("Xuất ra CSV");
		outCSV_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Class_Subject> l = Class_SubjectDAO.getList();
				ParseFile.Export_by_Class_Subject("..\\data\\out_Class_Subject.csv",l);
				JOptionPane.showMessageDialog(new Frame(), "Xuất out_Class_Subject.csv thành công!!");

			}
		});
		panel_1.add(outCSV_button);
		
		JButton home_bt_1 = new JButton("back to Menu");
		home_bt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Menu_GUI.initialize();
				frame = Menu_GUI.frame;
				frame.setVisible(true);
			}
		});
		panel_1.add(home_bt_1);
		


	}
}
