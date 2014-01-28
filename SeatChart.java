//****************************************************************************
// Sean Liu
// sl3497
//
// Objects of this class contain methods to handle the selling of seats and 
// update the seating chart.
//****************************************************************************

public class SeatChart {
	private int rows, columns;
	private Seat[][] seating;

	// Initializes the SeatChart information.
	public SeatChart(double[][] prices){
		rows = prices.length;
		columns = prices[0].length;
		seating = new Seat[rows][columns]; 
		resetSeating(prices);
	}
	
	// Instantiates a Seat object for every seat location in seating.
	private void resetSeating(double[][] prices){
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++)
				seating[i][j] = new Seat(prices[i][j], i, j);
		}
	}
	
	// Returns string of formatted column numbers for convenient printing.
	private String makeColumns(){
		String c = " ";
		for (int i=1; i<=columns; i++) // Real life indices start at 1.
			c += "     " + i;
		c += " COLUMNS \n\n";
		return c;
	}
	
	// Returns the string of formatted rows of the seating array for printing.
	private String makeRows(){
		String r = "";
		for (int i=1; i<=rows; i++){ // Real life indices start at 1.
			r += i + "  ";
			for (Seat x : seating[i-1])
				if (x.getPrice()==0)
					r += "   " + x.toString();
				else
					r += "  " + x.toString();
			r += "\n";
		}
		r += "ROWS \n\n";
		return r;
	}
	
	// Returns the seating array as a formatted string for printing.
	// For user convenience, row and column indexes start from 1.
	public String toString(){
		String chart = "\t\t Seating Chart and Prices \n";
		chart += makeColumns() + makeRows();
		chart += "\t\tFRONT STAGE \n";	
		return chart;
	}
	
	// Checks and returns whether a given seat is still available.
	private boolean isAvailable(Seat s){
		if (s.getPrice() == 0) // Sold seat has price zero.
			return false;
		else
			return true;
	}
	
	// Returns a Seat through location input.
	public Seat findSeat(int row, int column){
		if (row < rows && column < columns){ // Check for valid location.
			Seat target = seating[row][column];
			if (isAvailable(target))
				return target;
		}
		return null; // if no available seat found.
	}
	
	// Returns a Seat given a desired price.
	public Seat findSeat(double price){
		if (price != 0){ // price 0 will sell a sold seat.
			for (int i = rows-1; i >= 0; i--){ // Start from front row.
				for (int j = 0; j < columns; j++){
					Seat target = seating[i][j];
					if (target.getPrice() == price)
						return target;
				}
			}
		}
		return null; // if price=0 or no available seat found.
	}
}