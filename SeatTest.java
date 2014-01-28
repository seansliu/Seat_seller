//****************************************************************************
// Sean Liu
// sl3497
//
// This program tests the methods of the SeatChart class through the
// SeatRunner class.
//****************************************************************************

public class SeatTest {	
	
	public static void main (String[] args) {
		
		double[][] myPrices = {{10,10,10,10,10,10,10,10,10,10},
				  		  	   {10,10,10,10,10,10,10,10,10,10},
				  		  	   {10,10,10,10,10,10,10,10,10,10},
				  		  	   {10,10,20,20,20,20,20,20,10,10},
				  		  	   {10,10,20,20,20,20,20,20,10,10},
				  		  	   {10,10,20,20,20,20,20,20,10,10},
				  		  	   {20,20,30,30,40,40,30,30,20,20},
				  		  	   {20,30,30,40,50,50,40,30,30,20},
				  		  	   {30,40,50,50,50,50,50,50,40,30}}; 
							   // Array of prices (given).
		
		// Instantiate SeatRunner object.
		SeatRunner sr = new SeatRunner(myPrices);
		sr.run();
	}
}
