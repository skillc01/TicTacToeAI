package AIassignment;

//Made by Chloe Skillman  reg no. - 1601341

//Made by cs16523 

import java.util.*;


public class TicTacToe {
	//Instantiating object for later use 
    public static Board b;         
    public static Random rand = new Random();
    public static Point p;
    public static AIMinimaxSearch artificialInt;
    
    
  public static void main(String[] args) {
	 	  
	  p = new Point(rand.nextInt(3), rand.nextInt(3));   
      artificialInt = new AIMinimaxSearch();             // creating a new AIMinimaxSearch object(the Ai) 
      
      b = new Board();                      //creating the board, named 'b'
      b.displayBoard();                    //initial state of board being shown

      System.out.println("Who makes first move? (1)Computer (2)User: ");
      int choice = b.scan.nextInt();
      if(choice == 1){
          p.x = rand.nextInt(3);
          p.y = rand.nextInt(3);
          b.placeMove(p, 1);  
          b.displayBoard();
      }
      
      while (!b.isGameOver()) {
          
          System.out.println("Your move: row (1, 2, or 3) column (1, 2, or 3)");
          Point userMove = new Point(b.scan.nextInt()-1, b.scan.nextInt()-1);
	    while (b.getState(userMove)!=0) {
	    	System.out.println("Invalid move. Make your move again: ");
	    	userMove.x=b.scan.nextInt()-1;
	    	userMove.y=b.scan.nextInt()-1;
	    }
          b.placeMove(userMove, 2);  
          b.displayBoard();                         //showing what the board now looks like
          
          if (b.isGameOver()) {
              break;
          
          

      }
          //replaced do while loop
      artificialInt.MinimaxSearch(0,1);     //calling from AIMinimaxSearch.java
      
      b.placeMove(artificialInt.BestPosMove(), 1);   //calling from AIMinimaxSearch.java
      
      b.displayBoard();                         //showing what the board now looks like
     }     
      if (b.hasXWon()) {
          System.out.println("Unfortunately, you lost!");
      } else if (b.hasOWon()) {
          System.out.println("You win!");
      } else {
          System.out.println("It's a draw!");
      }
  }
  
}