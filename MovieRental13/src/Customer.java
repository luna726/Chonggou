import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer (String name) {
		_name = name;
	}
	
	public void addRental (Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName () {
		return _name;
	}
	
	
	
	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}
	
	
	
	private int frequentRenterPoints(Rental aRental) {
  	  return aRental.getFrequentRenterPoints();
    }
	
	private double getTotalCharge() {
		// TODO Auto-generated method stub
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		// TODO Auto-generated method stub
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return (int) result;
	}

	public String Statement(){
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(each.getCharge()) + "\n";
		}
		
		//add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())+
		" frequent renter points";
		return result;
		}
		
}
