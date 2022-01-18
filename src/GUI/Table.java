package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class Table extends AbstractTableModel {

	protected List l;
    private String[] columnNames;

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
         
    }

    @Override     
    public int getRowCount() {
        return l.size();
    }

    @Override        
    public int getColumnCount() {
        return columnNames.length; 
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	
	public Table(List list,String[] columnNames) {
		super();
		l = list;
		this.columnNames = columnNames;
		
	}

}
