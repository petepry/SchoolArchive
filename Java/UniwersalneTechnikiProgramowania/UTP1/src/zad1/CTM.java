package zad1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CTM extends AbstractTableModel{


	
	
	private String[] columnNames;
	private List<Country> countries;
	
	
	public CTM(String fileName){
		
		try {
			File cFile = new File(fileName);
			Scanner sc = new Scanner(cFile);
			
			columnNames = sc.nextLine().split("	");
			String[] line = null;
			countries = new ArrayList<Country>();
			
			while(sc.hasNextLine()){
				line = sc.nextLine().split("	");
				countries.add(new Country(line));
			}
			


			sc.close();
		} catch (IOException e) {

		}

		
	}
	

	public int getRowCount() {
		return countries.size();
	}


	public int getColumnCount() {
		return columnNames.length;
	}
	

	public String getColumnName(int col) {
		return columnNames[col];
	}

	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object obj = null;
		switch (columnIndex) {
	       case 0 :  obj = countries.get(rowIndex).getName(); break;
	       case 1 :  obj = countries.get(rowIndex).getCapital(); break;
	       case 2 :  obj = countries.get(rowIndex).getPopulation(); break;
	       default: break;
	       }
		return obj;
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	

}
