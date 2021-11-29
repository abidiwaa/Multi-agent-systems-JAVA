import gui.* ;
import java.awt.*;
import java.util.Random;

/**
 * Classe de test pour notre simulateur de boids.
 */
public class TestBoidsSimulator {
    public static void main ( String [] args ) {
        /**
         * Initialisation de l'interface graphique.
         */
        GUISimulator ig = new GUISimulator (800, 800 , Color . BLACK);
        /** Initialisation d'un objet de type Random pour pouvoir utiliser en suite la méthode nextInt. */
        Random rand = new Random();
        /** Initialisation d'une liste de boids. */
        Boid[] list = new Boid[150];
        for (int i=0;i<75;i++){
            Point_double p1 = new Point_double(rand.nextInt(200), rand.nextInt(200));
            Point_double p2 = new Point_double(rand.nextInt(10),rand.nextInt(10));
            Boid b = new Boid(p1,p2);
            //Point_double p3 = new Point_double((int)((p2.x*75) /b.norme_velocity()),(int)((p2.y*75) /b.norme_velocity()));
            //Boid l = new Boid(p1,p3);
            list[i] = b;
        }


        for (int i=0;i<75;i++){
            Point_double p1 = new Point_double(1350-rand.nextInt(200), 780-rand.nextInt(200));
            Point_double p2 = new Point_double(-rand.nextInt(18),-rand.nextInt(18));
            Boid b = new Boid(p1,p2);
            list[i+75] = b;
          }
        /**
         * Initialisation d'un groupe de boids.
         */

        Boids boids = new Boids(list,200,1,1,5);
        /**
         * Initialisation du simulateur. */
         
        BoidsSimulator bs  = new BoidsSimulator(boids,ig,35);
        ig.setSimulable(bs);
        bs.dessiner();
    }
    }
