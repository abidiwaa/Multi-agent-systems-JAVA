/**
* This class creates a test of Conways game of immigration (question 6)
* the user chooses the integer number of states
* It associates a random value (between 0 and number_of_states - 1) to each rectangle in the graphical window.
* To change the test you can change the height and width in the 
* following line GUISimulator ig = new GUISimulator(500,500,Color.MAGENTA);
* and you can change the number of states in the line int number_of_states = 5;
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/

import gui.GUISimulator ;
import java.awt.*;
import java.util.Random;

public class TestImmigration{
  public void testImmigration(){
	  
    GUISimulator ig = new GUISimulator(500,500,Color.MAGENTA);
    
    int number_of_states = 5;
    
    int largeur = ig.getPanelWidth();
    int longueur = ig.getPanelHeight();
    
    Random rand = new Random();
    int[][] rect = new int[largeur/20][longueur/20];
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longueur/20; j++){
        rect[i][j] = rand.nextInt(number_of_states);
      }
    }

    Space sp = new Space(largeur,longueur,rect);

    Immigration im = new Immigration(sp,largeur,longueur,ig,number_of_states);
    
    
    im.drawRectangles(sp.getSquares());
    ig.setSimulable(im);
}

  public static void main(String[] args){
    TestImmigration tcw = new TestImmigration();
    tcw.testImmigration();
  }
}
