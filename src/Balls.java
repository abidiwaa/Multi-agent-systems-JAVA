import java.awt.*;
/**
cette classe fournit l'implantation d'un ensemble de balle,
*/
public class Balls{
    /** l'enseble des balles qui définit et caractrise un objet Balls*/
    private Ball[] balls;

    /** constructeur d'un objet Balls
    *@param balls une liste des objets de type Ball "des balles"
    */
    public Balls(Ball[] balls){
        this.balls = balls;
      }
    /** accesseurs à l'attribut balls c-à-d à la liste des balles */
    public Ball[] getBalls(){
      return this.balls;
    }
    /** méthode qui mis à jour les composantes du vecteur de translation courant pour toutes les balles
    *par la suite toutes les balles auront le même vecteur comme vecteur de translation courant
    *@param trans_x la composante horizontale du vecteur de translation
    *@param trans_y la composante verticale du vecteur de translation
    */
    public void setballstrans(int trans_x,int trans_y){
      for (int i = 0 ; i<balls.length ; i++){
        this.balls[i].settrans(trans_x,trans_y);
      }
    }
    /** cette méthode translate les balles sans des contraintes
    *@param dx c'est la coordonnée x de translation
    *@param dy c'est la coordonnée y de translation
    */
    public void translatewithnocondition(int dx, int dy) {
        for (int i = 0 ; i<balls.length ; i++){
            this.balls[i].translatewithnocondition(dx,dy);
        }
    }

    /** cette méthode translate les balles mais cette fois avec des contraintes (rebondissement)
    *elle fait appel à la méthode "translater" pour déplacer chaque balle
    *Avant de faire appel à cette méthode ,
    *il faut au moins modifier "initialiser" une fois les valeurs du vecteur de translation courant
    *car à la création d'un objet ball les composantes du vecteur de translation courant d'une balle sont par défaut nuls
    *ca se fera en géneral à l'aide de la méthode "setballstrans"
    *@param height c'est la longueur de la fenêtre de l'interface du simulateur
    *@param width c'est la largeur de la fenêtre de l'interface du simulateur
    */
    public void translate(int height, int width) {
        for (int i = 0 ; i<balls.length ; i++){
            this.balls[i].translater(height,width);
        }
    }

    /** cette méthode modifie les positions courantes de toutes les balles par leurs positions initiales */
    public void reInit(){
        for (int i = 0; i < balls.length; i++){
          Ball b = new Ball(this.balls[i].getPos_init());
          this.balls[i]=b;
        }
    }
    /** redéfinition de la méthode "toString" qui donne une description textuelle de l'objet
    * @return une chaine de caractéres décrivant les positions des balles 
    */
    @Override
    public String toString(){
        String s = new String("Les positions des balles sont : %n");
        for (int i = 0 ; i<this.balls.length ; i++){
            s+=(this.balls[i].getball().x +","+ this.balls[i].getball().y)+"%n";
        }
        return s;
    }
}
