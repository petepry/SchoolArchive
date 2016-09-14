package zad1;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MCellRenderer implements TableCellRenderer{




	//	JPanel p = new JPanel();
	JLabel l = new JLabel();

	MCellRenderer() {
		//		l.setFont(new Font("Dialog", Font.BOLD, 18));
		//		l.setBorder(BorderFactory.createLineBorder(Color.black));
		//		l.setText("?");
		//		l.setOpaque(true);
		//		l.setBackground(Color.yellow);
		//		p.add(l);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		if (value != null)  {
			int val = ((Integer) value).intValue();
			if (val > 20000000)  {
				l.setForeground(Color.red);
			}
			else{
				l.setForeground(Color.black);
			}
			l.setText(""+ value);

		}

		return l;
	}



}
