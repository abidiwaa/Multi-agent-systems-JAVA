import gui.GUISimulator ;
import java.awt.*;

/** une classe de teste de notre simulateur de balles */
 public class TestBallsSimulator {
     public static void main ( String [] args ) {
      Point p1 = new Point(30,40);
      Point p2 = new Point(50,60);
      Point p3 = new Point(90,110);
      Point p4 = new Point(80,100);
      Point p5 = new Point(100,120);
      Ball b1 = new Ball(p1);
      Ball b2 = new Ball(p2);
      Ball b3 = new Ball(p3);
      Ball b4 = new Ball(p4);
      Ball b5 = new Ball(p5);
      Ball[] tab={b1,b2,b3,b4,b5};
      Balls balles = new Balls(tab);
      //la valeur 500 est arbitraire ,dans notre code le rebondissement s'effectue selon la taille de la fenêtre qui channge avec le curseur
      //cette valeur est mise juste pour l'initialisation
      GUISimulator ig = new GUISimulator (500 , 500 , Color . BLACK ) ;
      BallsSimulator bs = new BallsSimulator(balles,ig,11,23);
      ig.setSimulable(bs);
      bs.dessiner();
      }
}
