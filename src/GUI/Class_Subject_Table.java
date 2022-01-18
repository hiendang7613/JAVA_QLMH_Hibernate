package GUI;

import java.util.List;

import pojo.Class_Subject;

public class Class_Subject_Table extends Table {
	public Class_Subject_Table(List list, String[] columnNames) {
		super(list, columnNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Class_Subject x = (Class_Subject) l.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return x.getClassID();
		case 1:
			return x.getSubjectID();
		case 2:
			return x.getClassRoom();
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
		}
		return null;
	}
}
