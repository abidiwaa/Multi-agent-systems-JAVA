/**
* This class sets a map for each point (square) in a way that it points to its neighbors (8 voisines)
* Fill in the recatngles matrix every time with new values based on Conway rules.
* Simulate Conways game of life.
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;


public class Conways implements Simulable{
  protected HashMap<Point, int[]> conway_map;
  protected GUISimulator ig ;
  protected int[][] rectangles;
  protected int[][] initial_rectangles;
  protected int largeur;
  protected int longeur;

  /**
   * 
   * @param squares (class of type Space that holds the initial test values) 
   * @param largeur (width of the window)
   * @param longeur (height of the window)
   * @param ig  (a GUI simulator)
   */
  public Conways(Space squares, int largeur, int longeur, GUISimulator ig){
     this.largeur = largeur;
     this.longeur = longeur;
     conway_map = new HashMap<Point, int[]>();
     this.rectangles = squares.getSquares();
     this.initial_rectangles = squares.getInitialSquares();
     this.ig = ig;


  }
 
  /**
   * put every rectangle in the map alongside with its rectangle neighbors
   */
  public void setConway(){
	/**
	 * The map is going to be used a lot, so it needs to be cleared each time  
	 */
    conway_map.clear();
    int t_long = longeur/20;
    int t_larg = largeur/20;
    for (int i = 0; i < t_larg; i++){
      for (int j = 0; j < t_long; j++){
        Point p = new Point(i,j);
        int n0 = rectangles[(i-1 + t_larg) % t_larg][(j-1 + t_long) % t_long];
        int n1 = rectangles[i][(j-1 + t_long) % t_long];
        int n2 = rectangles[(i+1) % t_larg][(j-1 + t_long) % t_long];
        int n3 = rectangles[(i-1 + t_larg) % t_larg][j];
        int n4 = rectangles[(i+1) % t_larg][j];
        int n5 = rectangles[(i-1 + t_larg) % t_larg][(j+1) % t_long];
        int n6 = rectangles[i][(j+1) % t_long];
        int n7 = rectangles[(i+1 + t_larg) % t_larg][(j+1) % t_long];
        int[] neighbors = {n0,n1,n2,n3,n4,n5,n6,n7};
        conway_map.put(p,neighbors);
      }
    }
  }



 /**
  * iterate over every point in the map and calculate how many live cells amongst its neighbors 
  * Then change its value following the Conway rule.
  */
  public void newRectangles(){
    for (Point p : conway_map.keySet()){
      int i = p.x;
      int j = p.y;
      int[] neighbor = conway_map.get(p);
      int count_alive = 0;
      for (int k = 0; k < 8; k++){
        if (neighbor[k] == 1){
          count_alive++;
        }
      }
      if (this.rectangles[i][j] == 0 && count_alive == 3){
        this.rectangles[i][j] = 1;
      }
      if (this.rectangles[i][j] == 1 && (count_alive!=2 && count_alive!=3)){
          this.rectangles[i][j] = 0;
        }
    }
  }

  /**
   * copy the new values into the rectangles attribute. 
   * @param newR
   */
  public void setRectangles(int[][] newR){
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longeur/20; j++){
        int value = newR[i][j];
        this.rectangles[i][j] = value;
      }
    }
  }

  /**
   * 
   * @param rect (matrix with values 0 and 1)
   * if the value is 0, draw the rectangle in WHITE
   * if the value is 1, draw the rectangle in BLUE
   * the filling in each case is with LIGHT_GRAY
   */
  public void drawRectangles(int[][] rect){
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longeur/20; j++){
        if (rect[i][j] == 1){
          this.ig.addGraphicalElement(new Rectangle(20*i, 20*j , Color.LIGHT_GRAY, Color.BLUE, 20));
        }
        if (rect[i][j] == 0){
            this.ig.addGraphicalElement(new Rectangle(20*i, 20*j , Color.LIGHT_GRAY, Color.WHITE, 20));
          }
      }
    }
  }

 /**
  * set the map
  * Then update rectangles with the new values
  * Draw the updated rectangles  
  */
public void drawAll(){
  setConway();
  newRectangles();
  drawRectangles(this.rectangles);
}

  /**
   * implementing the next method
   * each time, reset then draw All using the drawAll method
   */
  @Override
  public void next(){
    this.ig.reset();
    drawAll();
  }

  /**
   * implementing the restart method
   * each time, reset then draw the initial rectangles, then set rectangles to its initial values 
   */
  @Override
  public void restart(){
    this.ig.reset();
    drawRectangles(this.initial_rectangles);
    setRectangles(this.initial_rectangles);
  }


}
