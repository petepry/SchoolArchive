package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PurchaseChangeListener implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent e) {
//		Change value of: data from: nie ma promocji to: w promocji
		System.out.println("Change value of: " + e.getPropertyName() + " from: " + e.getOldValue() +
				" to: " + e.getNewValue());
	}

}
