import java.lang.Math;

/**
 * Cette classe fournit l'implantation d'un boid caractérisé par sa position , sa vitesse .
 */
public class Boid{
    /** coordonnées (x,y) de la position du boid. */
    private Point_double position;
    /** coordonnées (x,y) de la vitesse du boid. */
    private Point_double velocity;

    /**
     * Constructeur de l'objet boid.
     * @param position sa position
     * @param velocity sa vitesse
     */
    public Boid(Point_double position,Point_double velocity) {
        Point_double p = new Point_double(position.getX(),position.getY());
        Point_double q = new Point_double(velocity.getX(),velocity.getY());
        this.position = p;
        this.velocity = q;
    }

    /** calcule la norme de la position ( distance de l'origine ) . */
    public double norme_pos(){
        return Math.sqrt(Math.pow(this.position.getX(),2)+Math.pow(this.position.getY(),2));
    }

    /** calcule la norme de la vitesse . */
    public double norme_velocity(){
        return Math.sqrt(Math.pow(this.velocity.getX(),2)+Math.pow(this.velocity.getY(),2));
    }
    /** récupère la position courante du boid. */
    public Point_double getPosition() {
        return position;
    }
    /** met à jour la position du boid . */
    public void setPosition(Point_double position) {
        this.position = position;
    }
    /** récupère la vitesse courante du boid. */
    public Point_double getVelocity() {
        return velocity;
    }
    /** met à jour la vitesse du boid */
    public void setVelocity(Point_double velocity) {
        this.velocity = velocity;
    }

    /** Effectue la translation du boid , le met en mouvement sur l'interface fournie par le simulateur
     *
     * @param height longueur de la fenêtre du simulateur
     * @param width  largeur de la fenêtre du simulateur
     */
   public void translate(int height,int width){
      if (this.position.getX() + this.velocity.getX() > width){
        this.position.setX((int) (this.position.getX() + this.velocity.getX()) % width + this.position.getX() + this.velocity.getX()-(int) (this.position.getX() + this.velocity.getX()));
      }
      else if (this.position.getX() + this.velocity.getX() < 0){
        this.position.setX((int) (this.position.getX() + this.velocity.getX()) % width + width + this.position.getX() + this.velocity.getX()-(int) (this.position.getX() + this.velocity.getX()));
      }
      else {
        this.position.setX(this.position.getX() + this.velocity.getX());
      }
      if (this.position.getY() + this.velocity.getY() > height){
        this.position.setY((int) (this.position.getY() + this.velocity.getY()) % height + this.position.getY() + this.velocity.getY()-(int) (this.position.getY() + this.velocity.getY()));
      }
      else if (this.position.getY() + this.velocity.getY() < 0){
        this.position.setY((int) (this.position.getY() + this.velocity.getY()) %height + height + this.position.getY() + this.velocity.getY()-(int) (this.position.getY() + this.velocity.getY()));
      }
      else {
        this.position.setY(this.position.getY() + this.velocity.getY()) ;
      }
    }

    /**
     * Oblige le boid à ne jamais dépasser une vitesse limite
     * @param vlim
     */
    public void limit_velocity(int vlim){
      if (this.norme_velocity()>vlim){
        Point_double p = new Point_double(this.getVelocity().getX()*vlim/this.norme_velocity(),this.getVelocity().getY()*vlim/this.norme_velocity());
        this.setVelocity(p);
      }
    }

    /**
     * Définit la règle de cohésion , impose à chaque boid de se diriger vers le centre de masse de ses voisins.
     * @param boids tableau de boids
     * @param dst_neighborhood rayon du voisinage.
     * @return le vecteur de translation pour la règle de cohésion.
     */
    public Point_double rule1(Boid[] boids,int dst_neighborhood){
        Point_double p = new Point_double(0,0);
        int cpt = 0;
        for (Boid b1 : boids){
            if (b1.position != this.position) {
              Point_double p1 = new Point_double(b1.position.getX()-this.position.getX(),b1.position.getY()-this.position.getY());
              Boid b2 = new Boid(p1,p1);
              if (b2.norme_pos() < dst_neighborhood){
                p.setX(p.getX() + b1.position.getX());
                p.setY(p.getY() + b1.position.getY());
                cpt++;
              }
            }
          }
          if (cpt>0){
            p.setX(p.getX()/cpt -this.position.getX());
            p.setY(p.getY()/cpt -this.position.getY());
            p.setX(p.getX()/100);
            p.setY(p.getY()/100);
          }
          return p;
    }

    /**
     * définit la règle séparation pour éviter les collisions entre voisins.
     * @param boids tableau de boids
     * @param dst_neighborhood rayon du voisinage.
     * @return retourne le vecteur de translation pour la règle de séparation.
     */
    public Point_double rule2(Boid[] boids,int dst_neighborhood){
        Point_double c = new Point_double(0,0);
        for (Boid b1 : boids){
            if (b1.position != this.position){
                Point_double p1 = new Point_double(b1.position.getX()-this.position.getX(),b1.position.getY()-this.position.getY());
                Boid b2 = new Boid(p1,p1);
                if (b2.norme_pos() < 5){
                    c.setX(c.getX()-(b2.position.getX()));
                    c.setY(c.getY()-(b2.position.getY()));
                }
            }
        }
        return c;
    }

    /**
     * définit la règle d'alignement , permet aux boids voisins d'aller dans la même direction à la même vitesse.
     * @param boids tableau de boids.
     * @param dst_neighborhood rayon du voisinage.
     * @return retourne le veteur de translation pour la règle d'alignement.
     */
    public Point_double rule3(Boid[] boids,int dst_neighborhood){
        Point_double p = new Point_double(0,0);
        int cpt =0;
        for (Boid b1 : boids) {
            if (b1.position != this.position) {
              Point_double p1 = new Point_double(b1.position.getX()-this.position.getX(),b1.position.getY()-this.position.getY());
              Boid b2 = new Boid(p1,p1);
              if (b2.norme_pos() < 2*dst_neighborhood ){
                p.setX(p.getX() + this.velocity.getX());
                p.setY(p.getY() + this.velocity.getY());
                cpt++;
              }
            }
        }
        if (cpt>0){
          p.setX(p.getX()/cpt-this.getVelocity().getX());
          p.setY(p.getY()/cpt-this.getVelocity().getY());
          p.setX(p.getX()/8);
          p.setY(p.getY()/8);
        }
        return p;
    }
}
