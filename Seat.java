//****************************************************************************
// Sean Liu
// sl3497
//
// Objects of this class manage information related to a seat.
//****************************************************************************

public class Seat {
	private double price;
	private int row, column;
	
	// Initializes the information associated with the Seat.
	public Seat(double p, int r, int c){
		price = p;
		row = r;
		column = c;
	}
	
	// Sets price to zero to indicate the seat is sold.
	public void sell(){
		price = 0;
	}
	
	// Accesses the price information.
	public double getPrice(){
		return price;
	}
	
	// Accesses the seat row.
	public int getRow(){
		return row + 1; // Real life index starts at 1.
	}
	
	// Accesses the seat column.
	public int getColumn(){
		return column + 1; // Real life index starts at 1.
	}
	
	// Returns the price as String.
	public String toString(){
		return ("" + price);
		
	}
}