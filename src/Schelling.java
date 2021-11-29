/**
* This class is an implementation of Conways game of immigration (Schelling with colors).
* It inherits the Conways class
* Based on the new rule of immigration, the methods newRectangles and drawRectangles are rewritten.
* Giving a number of colors, and a list of those colors, The colors start grouping together  
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/

import java.util.LinkedList;
import java.util.Random;

import gui.*;

import java.awt.Point;
import java.awt.Color;

public class Schelling extends Conways{

	private int seuil;
	private LinkedList<Point> empty_squares;
	private  Color[] color_names;
	private  int empty;
    
	/**
	 * 
	 * @param squares
	 * @param largeur
	 * @param longeur
	 * @param ig
	 * @param seuil number of different colors that if exceeded, the current rectangle immigrates.
	 * @param color_names  list of colors
	 * @param empty  a linkedList to store empty spaces (rectangles with color white)
	 */
	public Schelling(Space squares, int largeur, int longeur, GUISimulator ig, int seuil, Color[] color_names, int empty) {
		super(squares, largeur, longeur, ig);
		this.seuil = seuil;
		this.color_names = color_names;
		this.empty_squares = new LinkedList<Point>();
		this.empty = empty;
		SetEmptySquares();
	}

/**
 * create (empty) empty spaces and put them in the empty_squares LinkedList 
 */
public void SetEmptySquares(){
	Random rand = new Random();
	for (int k = 0; k < this.empty; ++k){
		int i = rand.nextInt(this.largeur/20);
		int j = rand.nextInt(this.longeur/20);
		this.rectangles[i][j] = 0;
		Point p = new Point(i,j);
		empty_squares.add(p);
	}
}

/**
 * Calculate the number of different neighbors
 * @param k number that represents the index of the color in color_names.
 * @param neighbors list of 8 values
 * @return the count 
 */
public int getDifferentColors(int k, int[] neighbors){
	int count = 0;
	for (int i = 0; i < neighbors.length; i++){
		if (neighbors[i] != k && neighbors[i] != 0){
			count += 1;
		}
	}
	return count;
}

	@Override
  public void newRectangles(){
    for (Point p : this.conway_map.keySet()){
      int i = p.x;
      int j = p.y;
      int[] neighbors = this.conway_map.get(p);
      int k = this.rectangles[i][j];
      if (k != 0){
    	  int different = getDifferentColors(k,neighbors);
    	  if (different >= this.seuil){
	    	  Random rand = new Random();
	    	  int r = rand.nextInt(empty_squares.size());
	    	  Point q = this.empty_squares.get(0);
	    	  this.rectangles[q.x][q.y] = k;
	    	  empty_squares.remove(q);
	    	  empty_squares.add(p);
	    	  this.rectangles[i][j] = 0;

	      }
	   }
    }
  }


  @Override
  public void drawRectangles(int[][] rect){
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longeur/20; j++){
        Color couleur = color_names[rect[i][j]];
        this.ig.addGraphicalElement(new Rectangle(20*i, 20*j , Color.LIGHT_GRAY, couleur,20));
      }
    }
  }




}
