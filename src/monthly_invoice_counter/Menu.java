package monthly_invoice_counter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Menu {
	
	private int  howManyMonths;
	private LocalDate monthToStartCounting;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );
	
	private String FOREGROUND_COLOR_GREEN = "\u001B[32m";
	private String FOREGROUND_COLOR_YELLOW = "\u001B[33m";
	private String RESET_FOREGROUND_COLOR = "\u001B[0m";
	
	public void presentationOfApp() {
		JOptionPane.showMessageDialog(null, "======================================================"
				+ "\nHellow and Welcome to the Monthly purchase fee calculator!!!\n"
				+ "======================================================");
	}
	
	public void setHowManyMonths() {
		
		try {
			
			do {
				this.howManyMonths = Integer.valueOf( JOptionPane.showInputDialog( "In how many months "
						+ "will you complete the account?\n\n" ) );
			} while ( this.howManyMonths <= 0 );
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "OOOPS... You entered a not valid value..."
					+ "\nPlease try restart the app and enter a valid number!", "Invalid Value!", JOptionPane.ERROR_MESSAGE );
		}
		
	}
	
	public int getHowManyMonths() {
		return howManyMonths;
	}
	
	public void setMonthToStartCounting() {
		
		try {
			String userAnswer = JOptionPane.showInputDialog( "Please"
					+ " enter the date of the purchase\n\nEx.: dd/mm/yyyy" ).replace("-", "/").replace(".", "/").replace(",", "/");
			
			this.monthToStartCounting = LocalDate.parse( userAnswer, formatter );
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "OH NO!! You typed a invalid value... Please restart the app "
					+ "and put a valid value", "Invalid Value!", JOptionPane.ERROR_MESSAGE );
		}
		
	}
	
	public LocalDate getMonthToStartCounting() {
		return monthToStartCounting;
	}
	
	public void getAllMonthsOPurchase() throws Exception {
		
		for(int currentMonth = 1; currentMonth <= howManyMonths; currentMonth++) {
			monthToStartCounting = monthToStartCounting.plusMonths( 1 );
			
			if(monthToStartCounting.getDayOfWeek() == DayOfWeek.SATURDAY  ) {
				monthToStartCounting = monthToStartCounting.plusDays( 2 );
				System.out.println("The bill number " + FOREGROUND_COLOR_GREEN + currentMonth + RESET_FOREGROUND_COLOR
				+ " - will expirate in: " + monthToStartCounting.format(formatter) );
				monthToStartCounting = monthToStartCounting.minusDays( 2 );
			
			} else if (monthToStartCounting.getDayOfWeek() == DayOfWeek.SUNDAY  ) {
				monthToStartCounting = monthToStartCounting.plusDays( 1 );
				System.out.println("The bill number " + FOREGROUND_COLOR_GREEN + currentMonth + RESET_FOREGROUND_COLOR
				+ " - will expirate in: " + monthToStartCounting.format(formatter) );
				monthToStartCounting = monthToStartCounting.minusDays( 1 );
			
			} else {
				System.out.println("The bill number " + FOREGROUND_COLOR_GREEN + currentMonth + RESET_FOREGROUND_COLOR
				+ " - will expirate in: " + monthToStartCounting.format(formatter) );
			}
			
			Thread.sleep(2000);
			
		}
		
		System.out.println(FOREGROUND_COLOR_YELLOW +
		"\n\nAnd finish all the " + howManyMonths + " installments" + RESET_FOREGROUND_COLOR);
		
	}

}
