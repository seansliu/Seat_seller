Sean Liu
sl3497

1. How to use this program.
With 'Seat.java', 'SeatChart.java', and 'SeatTester.java' in the same directory, compile all above the files and run 'StoreTest'. Then, follow the instructions.

2. Design decisions.
Seat:
I wrote this class to only deal with the information associated with a seat--I had it save the seat's price, row, and column. I used rows and columns because doing so made it easier to iterate through the 2-D seating array, as 2-D array use [row][column] to locate each element. For user convenience, I wrote accessor methods getRow() and getColumn() to return row+1 and column+1, respectively, because outside coding people expect indices to start from 1, not 0. The method sell() updated the price of a Seat to 0, indicating it has been sold.

SeatChart:
I wrote this class to deal with everything else: the seating arrangement and selling tickets.
I used a private 2-D prices array identical to the pricing array given in the assignment as a reference for instantiating the class. I wrote my code this way to allow the user to easily update the seating prices and/or seating format. The SeatChart object will update the seating accordingly when it gets instantiated, because all its information comes from the price array. It used resetSeating(int[][] prices), which iterated through the input array to instantiate objects in seating, which has the same dimensions.
The toString() method returns the prices of the Seats in seating as one formatted string, with indices for rows and columns. When returned, rows and columns started from 1, because outside coding people expect indices to start from 1, not 0.
The isAvailable(Seat s) method checks whether s is still available and returns the appropriate boolean.
The transaction(Seat s) method uses s.sell() to sell the seat, and prints the payment and location of s for user convenience.
The pickSeat() method gets user input for seat row and column, subtracts 1 because indices in java start with 0, not 1. It then saves the Seat in that location as target, checks whether target is available, and carries out the appropriate task: sells ticket if it is available, prints apology if it is taken.
The pickPrice() method gets user input for price and sets price to -1 if it is 0. (If price were 0, the program would sell Seats that have already been sold.) It then uses the findSeat(buyerPrice) method to search for a Seat with that price. findSeat(int price) iterates through the seating array, starting from the frontmost row, from left to right. I did this because people generally want Seats closer to the stage, but have mixed opinions about whether they want Seats in the middle or edge of the row. If a Seat with the desired price is not found, the method returns null. There is no need to use isAvailable(), because if a Seat's price is non-zero, it cannot be taken. pickPrice() then checks whether the returned Seat is null, and carries out the appropriate task: sells ticket if a Seat is returned, prints apology if it is not.
The method sellTicket allows the user to choose which mode to use for picking Seat.
Finally, runSeating() prints seating, then sells a ticket and prints a new updated seating in a while loop. The while loop allows the user to keep buying more tickets while the seating array keeps updating to reflect these sales.


SeatTest:
This class was simple. It instantiated SeatChart, printed a welcome message, and carried out runSeating().