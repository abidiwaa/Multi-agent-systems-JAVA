/**
* This class creates a test of Conways game of life (question 5)
* It associates a random value (0 or 1) to each rectangle in the graphical window.
* To change the test you can change the height and width in the 
* following line GUISimulator ig = new GUISimulator(600,600,Color.BLACK);
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/
import gui.GUISimulator ;
import java.awt.*;
import java.util.Random;

public class TestConway{
  /**
   * create the test and execute it	
   */
  public void testConway(){
	  
    GUISimulator ig = new GUISimulator(600,600,Color.BLACK);
    int largeur = ig.getPanelWidth();
    int longueur = ig.getPanelHeight();
    Random rand = new Random();
    
    int[][] rect = new int[largeur/20][longueur/20];
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longueur/20; j++){
        rect[i][j] = rand.nextInt(2);
      }
    }
     
    Space sp = new Space(largeur,longueur,rect);

    Conways cw = new Conways(sp,largeur,longueur,ig);
    
    cw.drawRectangles(sp.getSquares());
    
    ig.setSimulable(cw);
}

  public static void main(String[] args){
    TestConway tcw = new TestConway();
    tcw.testConway();
  }
}
