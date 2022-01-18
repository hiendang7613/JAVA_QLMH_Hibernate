package GUI;

import java.util.List;

import pojo.Class_Subject_Student;

public class Class_Subject_Student_Table extends Table {
	
	public Class_Subject_Student_Table(List list, String[] columnNames) {
		super(list, columnNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Class_Subject_Student x = (Class_Subject_Student) l.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return x.getStudentID();
		case 1:
			return x.getSubjectID();
		case 2:
			return x.getClassID();
		case 3:
			return x.getDiemCK();
		case 4:
			return x.getDiemGK();
		case 5:
			return x.getDiemCong();
		case 6:
			return x.getDiemTB();
		case 7:
			return x.getDiemTB()>=5?"Đậu":"Rớt";
		}
		return x;
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
			return int.class;
		case 4:
			return int.class;
		case 5:
			return int.class;
		case 6:
			return int.class;
		case 7:
			return String.class;
		}
		return null;
	}
}
