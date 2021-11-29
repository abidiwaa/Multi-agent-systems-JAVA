/**
* This class creates a test of Conways game of immigration (question 7)
* the user chooses the colors (in the color_names)
* and the seuil, and empty which is an integer representing how many empty spaces we want in the test.
* It associates a random value (between 1 and number_of_colors - 1) to each rectangle in the graphical window.
* To change the test you can change the height and width in the 
* following line GUISimulator ig = new GUISimulator(700,700,Color.MAGENTA);
* and you can also list of colors by adding a color name to the list Color[] color_names
* you can also change the seuil in the line seuil = 3; 
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/

import gui.GUISimulator ;
import java.awt.*;
import java.util.Random;

public class TestSchelling{
  public void test(){
    GUISimulator ig = new GUISimulator(700,700,Color.GRAY);
    Color[] color_names = {Color.WHITE, Color.RED, Color.GREEN,
                        Color.BLUE, Color.BLACK, Color.PINK};
    int seuil = 4;
    int empty = 300;
    int largeur = ig.getPanelWidth();
    int longueur = ig.getPanelHeight();
    Random rand = new Random();
    int[][] rect = new int[largeur/20][longueur/20];
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longueur/20; j++){
        rect[i][j] = 1 + rand.nextInt(color_names.length - 1);
      }
    }


    Space sp = new Space(largeur,longueur,rect);

    Schelling sh = new Schelling(sp,largeur,longueur,ig,seuil, color_names, empty);
    sh.drawRectangles(sp.getSquares());
    ig.setSimulable(sh);
}

  public static void main(String[] args){
    TestSchelling tcw = new TestSchelling();
    tcw.test();
  }
}
