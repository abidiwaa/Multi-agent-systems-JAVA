import gui.*;
import java.awt.Color;
import java.util.Random;

public class testSpace{
  public void test(){
    GUISimulator ig = new GUISimulator(1000,1000,Color.WHITE);
    Random rand = new Random();
    int[][] rect = new int[100][100];
    for (int i = 0; i < 100; i++){
      for (int j = 0; j < 100; j++){
        rect[i][j] = rand.nextInt(2);
      }
    }

    Space sp = new Space(1000,1000,rect);

    int[][] squares = sp.getSquares();
    for (int i = 0; i < 100; i++){
      for (int j = 0; j < 100; j++){
        if (squares[i][j] == 1){
          ig.addGraphicalElement(new Rectangle(10*i, 10*j , Color.RED, Color.RED, 10));
        }
      }
    }
  }

  public static void main(String[] args){
    testSpace ts = new testSpace();
    ts.test();
  }
}
