package monthly_invoice_counter;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		try {
			menu.setHowManyMonths();
			menu.setMonthToStartCounting();
			menu.getAllMonthsOPurchase();
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Oh no... Something get Wrong with the App... See more in the next pop up");
			JOptionPane.showMessageDialog(null, "The current Error is:\n\n" + e);
		}
		

	}

}
