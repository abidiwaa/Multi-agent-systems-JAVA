import java.awt.*;
/**
* Cette classe fournit l'implantation d'une balle,
*/
public class Ball{
    /** un vecteur de deux entiers qui représente la position de la balle */
    private Point ball;
    /** un vecteur de deux entiers qui représente et enregistre la position initiale de la balle */
    private Point pos_init;
    /** la composante horizontale du vecteur de translation courant de la balle */
    private int trans_x;
    /** la composante verticale du vecteur de translation courant de la balle */
    private int trans_y;

    /** le constructeur de l'objet Ball
    *@param ball : un vecteur de deux entiers qui représente la position initiale d'une balle lors de sa création
    */
    public Ball(Point ball){
      Point q = new Point(ball.x,ball.y);
      this.ball=q;
      Point p = new Point(ball.x,ball.y);
      this.pos_init = p;
    }

    /** cette méthode est un mutateur qui modifie les composantes du vecteur de translation courant de la balle
    *@param trans_x
    *@param trans_y
    */
    public void settrans(int trans_x,int trans_y){
        this.trans_x=trans_x;
        this.trans_y=trans_y;
    }
    /** cette méthode translate la balle sans des contraintes
    *@param dx c'est la coordonnée x de translation
    *@param dy c'est la coordonnée y de translation
    */
    public void translatewithnocondition(int dx ,int dy){
        this.ball.x=this.ball.x+dx;
        this.ball.y=this.ball.y+dy;
    }
    /** accesseurs à l'attribut pos_init c-à-d à la position initiale d'une balle */
    public Point getPos_init(){
        return this.pos_init;
    }
    /** accesseurs à l'attribut ball c-à-d à la position courante d'une balle */
    public Point getball(){
        return this.ball;
    }
    /** cette méthode translate la balle mais cette fois avec des contraintes (rebondissement)
    *Avant de faire appel à cette méthode ,
    *il faut au moins modifier "initialiser" une fois les valeurs du vecteur de translation courant
    *car à la création d'un objet ball les composantes du vecteur de translation courant d'une balle sont par défaut nuls
    *@param height c'est la longueur de la fenêtre de l'interface du simulateur
    *@param width c'est la largeur de la fenêtre de l'interface du simulateur
    */
    public void translater(int height,int width){
        if (this.ball.y+this.trans_y>height){
          this.ball.y=2*height-this.ball.y-this.trans_y;
          this.settrans(this.trans_x,-this.trans_y);
        }
        else if (this.ball.y+this.trans_y<0){
          this.ball.y=-this.ball.y-this.trans_y;
          this.settrans(this.trans_x,-this.trans_y);
        }
        else{
          this.ball.y=this.ball.y+this.trans_y;
        }
        if (this.ball.x+this.trans_x>width){
          this.ball.x=2*width-this.ball.x-this.trans_x;
          this.settrans(-this.trans_x,this.trans_y);
        }
        else if (this.ball.x+this.trans_x<0){
          this.ball.x=-this.ball.x-this.trans_x;
          this.settrans(-this.trans_x,this.trans_y);
        }
        else{
          this.ball.x=this.ball.x+this.trans_x;
        }
      }
}
