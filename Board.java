package AIassignment;

// Chloe Skillman  reg no. - 1601341
//cs16523 

import java.util.*;

class Point {
  int x, y;

  public Point(int x, int y) {
      this.x = x;
      this.y = y;
  }

  @Override
  public String toString() {
      return "[" + (x+1) + ", " + (y+1) + "]";
  }
}

class PointsAndScores {
  int score;
  Point pos;  //change the variable name to pos

  PointsAndScores(int score, Point pos) {
      this.score = score;
      this.pos = pos;
  }
}

class Board { 
  List<Point> availablePoints;
  Scanner scan = new Scanner(System.in);
  int[][] board = new int[3][3];

  public Board() {
  }

  public boolean isGameOver() {
      return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty());
  }

  public boolean hasXWon() {
      if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
          return true;
      }
      for (int i = 0; i < 3; ++i) {
          if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                  || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
              return true;
          }
      }
      return false;
  }

  public boolean hasOWon() {
      if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
          return true;
      }
      for (int i = 0; i < 3; ++i) {
          if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                  || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
              return true;
          }
      }
      return false;
  }

  public List<Point> getAvailablePoints() {
      availablePoints = new ArrayList<>();
      for (int i = 0; i < 3; ++i) {
          for (int j = 0; j < 3; ++j) {
              if (board[i][j] == 0) {
                  availablePoints.add(new Point(i, j));
              }
          }
      }
      return availablePoints;
  }
  
  public int getState(Point pos){
  	return board[pos.x][pos.y];
  }

  public void placeMove(Point pos, int player) {
      board[pos.x][pos.y] = player;   
  }

  public void displayBoard() {
      System.out.println();

      for (int i = 0; i < 3; ++i) {
          for (int j = 0; j < 3; ++j) {
		if (board[i][j]==1)           
                  System.out.print("X ");
              else if (board[i][j]==2)
                  System.out.print("O ");
              else
                  System.out.print(". ");
          }
          System.out.println();
      }
  }

}
