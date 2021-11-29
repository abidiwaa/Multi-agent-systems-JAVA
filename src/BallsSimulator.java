import gui.*;
import java.awt.Color;
/**
cette classe fournit l'implantation d'un simulateur de mouvement de balle,qui implemente l'interface simulable
*/
public class BallsSimulator implements Simulable{
    /** une liste de balles */
    private Balls balls;
    /** une interface graphique */
    private GUISimulator ig;
    /** la composante horizontale du vecteur de translation initiale de toutes les balles */
    // c'est un vecteur de translation inital car il change pour une balle qui dépasse les bords
    private int trans_x;
    /** la composante verticale du vecteur de translation initiale de toutes les balles */
    private int trans_y;

    /**
    * constructeur d'un simulateur de mouvement de balles
    *@param balls la liste des balles
    *@param ig une interface graphique
    *@param trans_x la composante horizontale du vecteur de translation initiale de toutes les balles
    *@param trans_y la composante verticale du vecteur de translation initiale de toutes les balles
    */
    public BallsSimulator(Balls balls,GUISimulator ig,int trans_x,int trans_y){
        this.balls=balls;
        this.ig=ig;
        this.balls.setballstrans(trans_x,trans_y);
        this.trans_x=trans_x;
        this.trans_y=trans_y;
    }

    /** cette méthode implémente la méthode next fournit par l'interface simulable qui permet de passer d'une état à l'état suivante */
    @Override
    public void next(){
      //les dimensions de la fenêtre lors de l'appui sur le bouton suivant,ils changent selon la taille de la fenêtre à chaque moment
      int height=ig.getHeight();
      int width=ig.getWidth();
      this.balls.translate(height,width);
      this.ig.reset();
      this.dessiner();
    }

    /** cette métode implémente la méthode restart fournit par l'interface simulable qui permet de revenir à l'état initial */
    @Override
    public void restart(){
        this.balls.reInit();
        this.ig.reset();
        //après le retour des balles à leurs Pos_init ,si on rajoute pas cette ligne rien ne se passe lors de l'appui sur le bouton début puisque
        //chaque balle est initialiser (voir reInit) et donc trans_x et trans_y sont nuls
        //(en effet le constructeur Ball n'initialise que les attributs ball et pos_init)
        this.balls.setballstrans(this.trans_x,this.trans_y);
        this.dessiner();
    }

    /** cette métode dessine les balles  dans l'interface graphique*/
    public void dessiner(){
    	for (int i=0;i<balls.getBalls().length;i++){
        ig.addGraphicalElement(new Oval(balls.getBalls()[i].getball().x, balls.getBalls()[i].getball().y, Color.WHITE, Color.WHITE, 10));
      }
    }
}
