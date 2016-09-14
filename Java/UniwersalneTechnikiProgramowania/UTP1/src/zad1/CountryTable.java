package zad1;


import javax.swing.JTable;

@SuppressWarnings("serial")
public class CountryTable extends JTable {

	public CountryTable(String countriesFileName) {
		super(new CTM(countriesFileName));
		this.setDefaultRenderer(this.getColumnClass(2), new MCellRenderer());
	}

}
