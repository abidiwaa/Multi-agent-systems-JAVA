/**
* This class is an implementation of Conways game of immigration.
* It inherits the Conways class
* Based on the rules of immigration, the methods newRectangles and drawRectangles are rewritten.
* Giving a number of states n, the class creates n colors (levels of gray from white to black), and 
* apply the rules of immigration on those states.  
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/

import gui.*;
import java.awt.Color;
import java.awt.Point;


public class Immigration extends Conways{
  private int number_of_states;

  
  /**
   * 
   * @param squares 
   * @param largeur
   * @param longueur
   * @param ig
   * @param n (number of states)
   */
  public Immigration(Space squares, int largeur, int longueur, GUISimulator ig, int n){
	 /**
	  * use the Conways constructor to initialize these four attributes. 
	  */
     super(squares,largeur,longueur,ig);
     
     this.number_of_states = n;
  }


  /**
   *  
   * @param k (number between 0 and number_of_states - 1)
   * @param neighbors (list of 8 integer values)
   * @return the number of neighbors in the (k+1) state [next state] 
   */
  public int getNextState(int k, int[] neighbors){
    int count = 0;
    for (int i = 0; i < neighbors.length; i++){
      if (neighbors[i] == ((k + 1) % this.number_of_states)){
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
      int states = getNextState(k,neighbors);
      /**
       * change the value stored in this rectangle when it has more than three neighbors in the next state 
       */
      if (states >= 3){
        this.rectangles[i][j] = (k + 1) % (number_of_states);
      }
    }
  }


  
  @Override
  public void drawRectangles(int[][] rect){
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longeur/20; j++){
    	/**
    	 * if number_of_states is n, then create n level of gray (from white to black) 
    	 * and associate the value in the rectangle to the corresponding color using 
    	 * the following mathematical expression.  
    	 */
        int gray = 255 - (rect[i][j] * 255)/(this.number_of_states - 1);
        Color couleur = new Color(gray,gray,gray);
        this.ig.addGraphicalElement(new Rectangle(20*i, 20*j , Color.BLACK, couleur,20));
      }
    }
  }



}
