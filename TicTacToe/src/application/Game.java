package application;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
List<Point> availablePoints;	
int game[][] = new int[3][3];

public Game() {
}

public boolean isGameOver() {
    //Game is over is someone has won, or board is full (draw)
    return (hasXWon() || hasOWon() || getAvailableStates().isEmpty());
}

public boolean hasXWon() {
    if ((game[0][0] == game[1][1] && game[0][0] == game[2][2] && game[0][0] == 1) || (game[0][2] == game[1][1] && game[0][2] == game[2][0] && game[0][2] == 1)) {
        //System.out.println("X Diagonal Win");
        return true;
    }
    for (int i = 0; i < 3; ++i) {
        if (((game[i][0] == game[i][1] && game[i][0] == game[i][2] && game[i][0] == 1)
                || (game[0][i] == game[1][i] && game[0][i] == game[2][i] && game[0][i] == 1))) {
            // System.out.println("X Row or Column win");
            return true;
        }
    }
    return false;
}

public boolean hasOWon() {
    if ((game[0][0] == game[1][1] && game[0][0] == game[2][2] && game[0][0] == 2) || (game[0][2] == game[1][1] && game[0][2] == game[2][0] && game[0][2] == 2)) {
        // System.out.println("O Diagonal Win");
        return true;
    }
    for (int i = 0; i < 3; ++i) {
        if ((game[i][0] == game[i][1] && game[i][0] == game[i][2] && game[i][0] == 2)
                || (game[0][i] == game[1][i] && game[0][i] == game[2][i] && game[0][i] == 2)) {
            //  System.out.println("O Row or Column win");
            return true;
        }
    }

    return false;
}

public void placeAMove(Point point, int player) {
    game[point.x][point.y] = player;   //player = 1 for X, 2 for O
} 


public List<Point> getAvailableStates() {
    availablePoints = new ArrayList<>();
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (game[i][j] == 0) {
                availablePoints.add(new Point(i, j));
            }
        }
    }
    return availablePoints;
}


Point computersMove;


public int minimax(int depth, int turn) {  
    if (hasXWon()) return +1; 
    if (hasOWon()) return -1;

    List<Point> pointsAvailable = getAvailableStates();
    if (pointsAvailable.isEmpty()) return 0; 

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
     
    for (int i = 0; i < pointsAvailable.size(); ++i) {  
        Point point = pointsAvailable.get(i);   
        if (turn == 1) { 
            placeAMove(point, 1); 
            int currentScore = minimax(depth + 1, 2);
            max = Math.max(currentScore, max);
            
            if(depth == 0)System.out.println("Score for position "+(i+1)+" = "+currentScore);
            if(currentScore >= 0){ if(depth == 0) computersMove = point;} 
            if(currentScore == 1){game[point.x][point.y] = 0; break;} 
            if(i == pointsAvailable.size()-1 && max < 0){if(depth == 0)computersMove = point;}
        } else if (turn == 2) {
            placeAMove(point, 2); 
            int currentScore = minimax(depth + 1, 1);
            min = Math.min(currentScore, min); 
            if(min == -1){game[point.x][point.y] = 0; break;}
        }
        game[point.x][point.y] = 0; //Reset this point
    } 
    return turn == 1?max:min;
}  
}
