/**
* This class creates two identical matrixes to store the values in the recantgles.
* @author ABIDI, BAKIR and MANSOUR
* @version 1.0
*/

public class Space{
  private int[][] squares;
  
  private int[][] initial_squares;

  /**
   * 
   * @param largeur (width of the graphical window)
   * @param longeur  (height of the graphical window)
   * @param rect     (matrix with values 0 and 1)
   */
  public Space(int largeur, int longeur, int[][] rect){
    squares = new int[largeur/20][longeur/20];
    initial_squares = new int[largeur/20][longeur/20];
    /**
     * copy the values of rect into squares
     */
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longeur/20; j++){
        int value = rect[i][j];
        squares[i][j] = value;
      }
    }
    /**
     * copy the values of rect into initial_squares
     */
    for (int i = 0; i < largeur/20; i++){
      for (int j = 0; j < longeur/20; j++){
        int valeur = rect[i][j];
        initial_squares[i][j] = valeur;
      }
    }
  }

  public int[][] getSquares(){
    return this.squares;
  }

  
  public int[][] getInitialSquares(){
    return this.initial_squares;
  }



}
