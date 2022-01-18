package GUI;

import java.util.List;

import pojo.Student;

public class Student_Table extends Table {

	public Student_Table(List list, String[] columnNames) {
		super(list, columnNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = (Student) l.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return student.getStudentID();
		case 1:
			return student.getName();
		case 2:
			return student.getGender();
		case 3:
			return student.getiD();
		case 4:
			return student.getClassID();
		}
		return student;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		}
		return null;
	}
	
	
}
