package tictactoe;

import java.util.*;

//aiplayer that will play best possible move in 3x3 Noughts&Crosses / Tictactoe
//Human player is O
//ai player is X

public class AIMinimaxSearch {
	//initialising objects to be used in methods and list in the class
List<PointsAndScores> ChildNodeSc;


//variables used in Maximum
public int maxNumb;
public int ord1;
public int A;
//variables used in Minimum
public int minNumb;
public int ord2; 
public int B;
//initialising variables for min and max in minimax search,
public int minimaxMIN;
public int minimaxMAX;


protected int Maximum(List<Integer> list1) {   //return maximum                           
	ord1 = -1;                                 //index variable, must equal -1
  maxNumb = -99999;                          //max number, must equal extremely low number/ minimum number value
  int i;  //variable made fore use in for loop
  for (i = 0;list1.size() > i; i = 1 +i) {
      if (maxNumb<list1.get(i) ) {
      	ord1 = i;               
          maxNumb = list1.get(i);  }
  }
  A = list1.get(ord1);
  return A ;                                  //returns first maximum list
}

protected int Minimum(List<Integer> list2) {   //returns minimum
	                                            
  minNumb = 99999;                             //min number, must equal extremely big number/ maximum number value
  ord2 = -1;                                   //index variable, must equal -1
  
  int j; //variable made fore use in for loop
  for (j = 0; list2.size()> j; j = 1 +j) {    
      if (minNumb > list2.get(j) ) {
      	ord2 = j;
          minNumb = list2.get(j);
       }
  }
  B = list2.get(ord2);                          //returns minimum second list
  return B;
}


public int miniSearch(int depthInt, int turnsInt) {                        
  List<Integer>scoreList = new ArrayList<>();
  if (TicTacToe.b.hasOWon()){          // minimax search - if we(human player) win we get a lower number
  	return -5; }
  if (TicTacToe.b.hasXWon()){           
  	return +5; }
  
  int scoreAtInstant;
  Point pos;
  
  
  List<Point> posList = TicTacToe.b.getAvailablePoints();   
  if (posList.isEmpty()){ 
  	return 1; }
  
  int u; 
  for (u=0;posList.size() > u; u =1+u)
  {   pos = posList.get(u); 
      if (turnsInt != 1)                      //human player turn will pick lowest possible
      	{ TicTacToe.b.placeMove(pos, 2);
       scoreList.add(miniSearch(1 + depthInt, 1));    //going to the next depth/a depth deeper

      } 
  else if (turnsInt == 1)                   //ai player turn will pick highest possible
     	{  TicTacToe.b.placeMove(pos, 1);
         scoreAtInstant = miniSearch(1 + depthInt, 2);  //going a depth deeper
         scoreList.add(scoreAtInstant); 
         
         if (depthInt < 1) {                        //if not depth 1 or further 
              ChildNodeSc.add(new PointsAndScores(scoreAtInstant, pos));  }
      } 
      TicTacToe.b.board[pos.x][pos.y]=0;
  }
  
  
  if (turnsInt != 1) {     //if turnsInt is 1 then Maximum  will be return if not then minimum is returned
	   turnsInt = Minimum(scoreList);   //this is the min or max part of the minimax search
  
   return Minimum(scoreList);  
  }
   else  { turnsInt = Maximum(scoreList);
  return Maximum(scoreList); 
   }
}

public void MinimaxSearch(int depthInt, int turnsInt) {    //what we will call in TicTacToe.java
  ChildNodeSc = new ArrayList<>( );
  miniSearch(depthInt, turnsInt);     }

protected Point BestPosMove() {  //return the best possible move     //uses Point from Board.java
	 minimaxMIN = -5;                     //needs to have a larger value than minimaxMAX for Minimax search to work
	 minimaxMAX = -9999;     
	int e;                                  //variable made fore use in for loop
	for (e=0; ChildNodeSc.size() > e; e = 1 +e)  {            
	if ( ChildNodeSc.get(e).score>minimaxMAX ) {  
		minimaxMAX = ChildNodeSc.get(e).score;
		minimaxMIN = e;   
	  }  } return ChildNodeSc.get(minimaxMIN).pos;         //pos variable used for position
}
}
