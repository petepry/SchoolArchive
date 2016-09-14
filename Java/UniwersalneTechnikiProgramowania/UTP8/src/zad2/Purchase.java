/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.beans.*;


public class Purchase {

	//wsparcie
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
	private VetoableChangeSupport veto = new VetoableChangeSupport(this);

	private String prod;
	private String data;
	private Double price;
//	data (typu String) i price (typu Double).
	
	
	public Purchase(String prod, String data, Double price){
		this.prod = prod;
		this.data = data;
		this.price = price;
	}
	
	// setter
	synchronized void setData(String newData) { // pamiętamy o wielowątkowości!

		String oldData =  data;   // stara wartość

		data = newData;			// ustalenie nowej wartości
		// powiadomienie
		propertyChange.firePropertyChange("data", oldData, newData);
	}
	
	synchronized void setPrice(Double newPrice) throws PropertyVetoException { // pamiętamy o wielowątkowości!

		Double oldPrice = price;   // stara wartość
		
		// wywołujemy metodę fireVotoableChange, która z kolei
		// wywołuje metody vetoableChange zarejestrowanych słuchaczy
		// jeśli któraś z nich zgłasza veto, setter kończy działanie
		// a wyjątek PropertyVetoException jest przekazywany do obsługi
		//  przez metodę wywołującą setText

		veto.fireVetoableChange("price", oldPrice, newPrice);
		price = newPrice;			// ustalenie nowej wartości
		// powiadomienie
		propertyChange.firePropertyChange("price", oldPrice, newPrice);
	}


	// metody dodawania i usuwania słuchaczy
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		propertyChange.addPropertyChangeListener(l);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		propertyChange.removePropertyChangeListener(l);
	}
	public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
		veto.addVetoableChangeListener(l);
	}
	public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
		veto.removeVetoableChangeListener(l);
	}

	@Override
	public String toString() {
		return "Purchase [prod=" + prod + ", data=" + data + ", price=" + price
				+ "]";
	}



}  
