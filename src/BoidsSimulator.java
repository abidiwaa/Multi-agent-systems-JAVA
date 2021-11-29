import gui.*;
import java.awt.*;

/**
 * Classe du simulateur des boids , implémente l'interface Simulable.
 */
public class BoidsSimulator implements Simulable {
    /** Groupe de boids. */
    private Boids boids;
    /** Interface graphique. */
    private GUISimulator ig;
    /** vitesse limite des boids. */
    private int vlim;

    /**
     * Constructeur du simulateur des boids.
     * @param boids Groupe de boids.
     * @param ig Interface graphique du simulateur .
     * @param vlim vitesse limite des boids.
     */
    public BoidsSimulator(Boids boids,GUISimulator ig,int vlim) {
        this.boids = boids;
        this.ig = ig;
        this.vlim = vlim;
    }

    /**
     *  implémente la méthode next fournie par l'interface Simulable , qui permet de passer d'un état à l'état suivant.
     */
    @Override
    public void next(){
      int height=ig.getHeight();
      int width=ig.getWidth();
      this.boids.move_all_boids_to_new_positions(height,width,this.vlim);
      this.ig.reset();
      this.dessiner();
    }

    /**
     * implémente la méthode restart de l'interface Simulable qui permet de réinitialiser le mouvement à l'état initial.
     */
    @Override
    public void restart(){
        this.boids.setBoids(boids.getInitial_boids());
        this.ig.reset();
        this.dessiner();
    }

    /**
     * méthode permettant de dessiner les boids sur la fenêtre du simulateur.
     */
    public void dessiner(){
        for (int i=0;i<this.boids.getBoids().length;i++){
            ig.addGraphicalElement(new Oval((int) boids.getBoids()[i].getPosition().getX(), (int) boids.getBoids()[i].getPosition().getY(), Color.WHITE, Color.WHITE, 4));
            //ig.addGraphicalElement(new Oval(boids.getBoids()[i].getPosition().x +(int) (12*boids.getBoids()[i].getVelocity().x)/(int) boids.getBoids()[i].norme_velocity(), boids.getBoids()[i].getPosition().y+(int) (12*boids.getBoids()[i].getVelocity().y)/(int) boids.getBoids()[i].norme_velocity(), Color.RED, Color.RED, 2));
        }
    }
}
