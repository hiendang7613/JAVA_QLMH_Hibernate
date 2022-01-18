package GUI;

import java.util.List;

import pojo.Subject;

public class Subject_Table extends Table {
	public Subject_Table(List list, String[] columnNames) {
		super(list, columnNames);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Subject x = (Subject) l.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return x.getiD();
		case 1:
			return x.getName();
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
		}
		return null;
	}
}
