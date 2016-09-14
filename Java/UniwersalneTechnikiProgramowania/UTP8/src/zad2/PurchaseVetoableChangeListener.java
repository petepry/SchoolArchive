package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class PurchaseVetoableChangeListener implements VetoableChangeListener {
	
	private static int min = 1000;
	
	@Override
	public void vetoableChange(PropertyChangeEvent e)
			throws PropertyVetoException {
		Double newVal = (Double) e.getNewValue();
		if (newVal < min)
//			Price change to: 500.0 not allowed
			throw new PropertyVetoException("Price change to: " + newVal + " not allowed", e);
	}

}
