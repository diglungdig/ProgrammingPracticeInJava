import java.util.ArrayList;
import java.util.HashSet;

import com.sun.org.apache.regexp.internal.ReaderCharacterIterator;

public class DP_RobotInGrid {
	//Dynamic Programming Robot in a Grid Problem
	
	//Brutal Force Solution:
	ArrayList<Point> getPath(boolean [][] maze){
		if(maze == null || maze.length == 0) return null;
		
		ArrayList<Point> path = new ArrayList<Point>();
		
		if(getPath(maze, maze.length - 1, maze[0].length - 1, path))
		{
			return path;
		}		
		return null;
	}
	

	boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path){
		if(col < 0 || row < 0 || !maze[row][col]){
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(maze, row, col-1, path) || getPath(maze, row-1, col, path)){
			Point point = new Point(row, col);
			path.add(point);
			return true;
		}
		
		return false;
	}
	//The above functions runs at O(2^(r+c))
	//Down is the modified version with dynamic programming
	
	//Optimize exponent algorithm by reducing down repeating work
	
	ArrayList<Point> getPathDP(boolean [][] maze){
		if(maze == null || maze.length == 0) return null;
		
		ArrayList<Point> path = new ArrayList<Point>();
		
		HashSet<Point> failedPoints = new HashSet<Point>();

		
		if(getPathDP(maze, maze.length - 1, maze[0].length - 1, path, failedPoints))
		{
			return path;
		}		
		return null;
	}
	
	
	

	boolean getPathDP(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
		if(col < 0 || row < 0 || !maze[row][col]){
			return false;
		}
		
		Point test = new Point(row, col);
		
		if(failedPoints.contains(test)){
			return false;
		}
		
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(maze, row, col-1, path) || getPath(maze, row-1, col, path)){
			Point point = new Point(row, col);
			path.add(point);
			return true;
		}
		
		failedPoints.add(test);//Cached
		return false;
	}
	//The above algorithm runs at O(xy) time

}



class Point{
	int row, col;
	public Point(int x, int y){
		row = x;
		col = y;
	}
}