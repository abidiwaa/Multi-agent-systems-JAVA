/**
 * Cette classe permet de d'implanter un groupe de boids et ses propriétés .
 */
public class Boids {
    /** Tableau de boids. */
    private Boid[] boids;
    /** Tableau conservant les positions et vitesses initiales des boids. */
    private Boid[] initial_boids;
    /** rayon des voisinages de boids. */
    private int dst_neighborhood;
    /** paramètre précisant l'intensité de la première règle . */
    private int r1;
    /** paramètre précisant l'intensité de la deuxième règle . */
    private int r2;
    /** paramètre précisant l'intensité de la troisième règle . */
    private int r3;


    /**
     * Cette foncion permet le déplacement de tous les boids.
     * @param height longueur de la fenêtre du simulateur.
     * @param width  largeur de la fenêtre du simulateur.
     * @param vlim   vitesse limite des boids.
     */
    public void move_all_boids_to_new_positions(int height ,int width,int vlim){
        for (Boid b : this.boids){
            Point_double p1 = b.rule1(this.boids,this.dst_neighborhood);
            Point_double p2 = b.rule2(this.boids,this.dst_neighborhood);
            Point_double p3 = b.rule3(this.boids,this.dst_neighborhood);
            int  a = this.r1+this.r2+this.r3;
            double abs = b.getVelocity().getX()+this.r1*p1.getX()+this.r2*p2.getX()+this.r3*p3.getX();
            double ord = b.getVelocity().getY()+this.r1*p1.getY()+this.r2*p2.getY()+this.r3*p3.getY();
            Point_double new_velocity = new Point_double(abs,ord);
            b.setVelocity(new_velocity);
            b.limit_velocity(vlim);
            b.translate(height,width);

            //System.out.println(l.getX()==t.getX() && l.getY()==t.getY());
            //System.out.println(b.getPosition().toString());
            }
    }

    /**
     * récupère les positions initiales des boids.
     * @return tableau de boids remis à leurs positions initiales.
     */
    public Boid[] getInitial_boids() {
        return initial_boids;
    }

    /**
     * Met à jour  la tableau de boids.
     * @param boids tableau de boids.
     */
    public void setBoids(Boid[] boids) {
      for (int i=0 ;i<boids.length;i++){
        Point_double p1 = new Point_double(boids[i].getPosition().getX(),boids[i].getPosition().getY());
        Point_double p2 = new Point_double(boids[i].getVelocity().getX(),boids[i].getVelocity().getY());
        Boid b = new Boid(p1,p2);
        this.boids[i]=b;
      }
    }
    /** récupère le tableau de boids. */
    public Boid[] getBoids() {
        return boids;
    }

    /**
     * Constructeur du groupe de boids.
     * @param boids tableau des boids avec leurs positions et vitesses initiales.
     * @param d rayon des voisinages.
     * @param r1 intensité première règle.
     * @param r2 intensité deuxième règle.
     * @param r3 intensité troisième règle.
     */
    public Boids(Boid[] boids,int d,int r1,int r2,int r3) {
        this.r1=r1;
        this.r2=r2;
        this.r3=r3;
        this.dst_neighborhood = d;
        this.boids = boids;
        this.initial_boids = new Boid[boids.length];
        for (int i=0;i<boids.length;i++){
            Point_double p1 = new Point_double(boids[i].getPosition().getX(),boids[i].getPosition().getY());
            Point_double p2 = new Point_double(boids[i].getVelocity().getX(),boids[i].getVelocity().getY());
            Boid b = new Boid(p1,p2);
           this.initial_boids[i] = b;
        }
    }


}
