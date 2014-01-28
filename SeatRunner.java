//****************************************************************************
// Sean Liu
// sl3497
//
// Objects of this class contain methods to perform the transactions of 
// seats and update the seating chart through user interation.
//****************************************************************************

import java.util.Scanner;

public class SeatRunner {
	
	private SeatChart seats;
	private Scanner input = new Scanner(System.in);
	private int buyerRow, buyerColumn; // Buyer variables.
	private double buyerPrice, buyerTotal = 0;
	private Seat current;
	
	// Constructs the SeatRunner class by instantiating the SeatChart.
	public SeatRunner(double[][] prices){
		seats = new SeatChart(prices);
	}
	
	// Returns user's choice of how to buy a Seat.
	private int userChoice(){
		// Get user input.
		System.out.println("How would you like to buy your seat? ");
		System.out.print("1: Choose a seat. \t 2: Choose a price. \t");
		int mode = input.nextInt();
		System.out.println();
		return mode;
	}
	
	// Depending on mode input, locates and returns a Seat.
	public void locateSeat(int mode){
		if (mode == 1){
			// Get user input.
			System.out.print("Which ROW is your desired seat in? ");
			buyerRow = input.nextInt() -1; // Array indices start at 0.
			System.out.print("Which COLUMN is your desired seat in? ");
			buyerColumn = input.nextInt() -1; // Array indices start at 0.
			current = seats.findSeat(buyerRow, buyerColumn);
		}
		else if (mode == 2){
			// Get user input.
			System.out.print("Enter a price for your desired seat: $");
			buyerPrice = input.nextDouble();
			current = seats.findSeat(buyerPrice);
		}
		else // Invalid option.
			current = null;
	}
	
	// Performs and prints transaction of Seat sale.
	private void transaction(){
		if (current == null) // Cannot sell null.
			System.out.println("Error occurred. Please try again. \n");
		else{
			System.out.println("Your Seat:\tRow " + current.getRow() + 
							   "  Column " + current.getColumn());
			System.out.println("You will be charged $" + 
							   current.getPrice() + "\n");
			buyerTotal += current.getPrice();
			current.sell();
		}
	}
	
	// Run ticket sales.
	public void run(){
		System.out.println("Welcome to the Ticket Booth! \n");
		String again = "y"; // Allow user to keep buying seats.
		System.out.println(seats.toString());
		int choice;
		while (again.equals("y")){
			choice = userChoice();
			locateSeat(choice);
			transaction();
			System.out.println("Updating... \n");
			System.out.println(seats.toString()); // Show updated seating.
			System.out.print("Would you like to keep buying tickets? y/n  ");
			again = input.next();
			System.out.println();
		}
		System.out.println("You will be charged a total of $" + buyerTotal);
		System.out.println("Thank you for your business.");
	}	
}
