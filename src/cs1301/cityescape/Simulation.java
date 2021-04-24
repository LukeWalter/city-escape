package cs1301.cityescape;

import java.util.ArrayList;

public class Simulation {

    int rows;
    int cols;
    boolean[][] visited;
    
    int currR;
    int currC;
    
    public Simulation(int numRows, int numCols) {

	rows = numRows;
	cols = numCols;
	
	visited = new boolean[rows][cols];

	reset();

    } // Simulation

    public void reset() {

	for (int r = 0; r < rows; r++) {
	    for (int c = 0; c < cols; c++) {
		visited[r][c] = false;

	    } // for

	} // for

	currR = rows / 2;
	currC = cols / 2;

	visited[currR][currC] = true;

    } // reset

    public boolean run() {

	reset();

	while (true) {

	    // System.out.println(this);
	    
	    if (currR <= 0 || currR >= rows - 1 ||
		currC <= 0 || currC >= cols - 1) {
		return true;

	    } else {

		ArrayList<Character> validMoves = new ArrayList<>();

		if (!visited[currR - 1][currC])
		    validMoves.add('U');

		if (!visited[currR + 1][currC])
		    validMoves.add('D');

		if (!visited[currR][currC - 1])
		    validMoves.add('L');

		if (!visited[currR][currC + 1])
		    validMoves.add('R');

		int numMoves = validMoves.size();	    
		if (numMoves == 0) return false;

		int index = (int)(validMoves.size() * Math.random());
		char move = validMoves.get(index).charValue();

		switch (move) {

		case 'U':
		    currR--;
		    break;
		
		case 'D':
		    currR++;
		    break;
		
		case 'L':
		    currC--;
		    break;
		case 'R':
		    currC++;
		    break;
		
		default: 
		    throw new RuntimeException();
		
		} // switch

		visited[currR][currC] = true;
		
	    } // if

	} // while

    } // run
    
    
    public String toString() {

	String result = "";
	
	for (int r = 0; r < rows; r++) {

	    for (int c = 0; c < cols; c++) {
		if (visited[r][c]) result += "X ";
		else result += "- ";

	    } // for

	    result += "\n";
	    
	} // for

	return result;

    } // toString

} // Simulation
